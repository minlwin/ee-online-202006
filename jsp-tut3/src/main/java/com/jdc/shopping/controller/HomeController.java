package com.jdc.shopping.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.shopping.model.entity.Product;
import com.jdc.shopping.model.entity.Sale;
import com.jdc.shopping.model.entity.SaleDetails;
import com.jdc.shopping.model.service.CategoryService;
import com.jdc.shopping.model.service.ProductService;
import com.jdc.shopping.model.service.SaleService;

@WebServlet(
		urlPatterns = {
				"/home", "/pos-search", "/add-to-cart"
		}, loadOnStartup = 1
)
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private CategoryService catService;
	private ProductService proService;
	private SaleService salService;
	
	@Override
	public void init() throws ServletException {
		
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		
		if(null == emf) {
			emf = Persistence.createEntityManagerFactory("jsp-tut3");
			getServletContext().setAttribute("emf", emf);
		}
		
		catService = new CategoryService(emf.createEntityManager());
		proService = new ProductService(emf.createEntityManager());
		salService = new SaleService(emf.createEntityManager());
	}
	
	@Override
	public void destroy() {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();
		
		if("/pos-search".equals(path)) {
			searchProduct(req);
		} else if ("/add-to-cart".equals(path)) {
			addToCart(req);
		}
		
		req.setAttribute("categories", catService.getAll());
		getServletContext().getRequestDispatcher("/views/home.jsp").forward(req, resp);
	}

	private void addToCart(HttpServletRequest req) {

		// find sale object from session
		HttpSession session = req.getSession(true);
		Sale sale = (Sale) session.getAttribute("cart");
		
		if(null == sale) {
			sale = new Sale();
			session.setAttribute("cart", sale);
		}
		
		String strId = req.getParameter("id");
		int id = Integer.parseInt(strId);
		
		for(SaleDetails d : sale.getDetails()) {
			if(d.getProduct().getId() == id) {
				d.setQuentity(d.getQuentity() + 1);
				return;
			}
		}
		
		Product p = proService.findById(id);
		SaleDetails details = new SaleDetails();
		details.setProduct(p);
		details.setQuentity(1);
		sale.addDetails(details);
	}

	private void searchProduct(HttpServletRequest req) {

		String category = req.getParameter("category");
		String name = req.getParameter("name");
		
		req.setAttribute("products", proService.search(category, name));
	}
	
	

}
