package com.jdc.shopping.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.shopping.model.entity.Product;
import com.jdc.shopping.model.service.CategoryService;
import com.jdc.shopping.model.service.ProductService;

@WebServlet(
		urlPatterns = {
				"/products",
				"/products/edit"
		})
public class ProductController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private CategoryService catService;
	private ProductService proService;
	
	@Override
	public void init() throws ServletException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		catService = new CategoryService(emf.createEntityManager());
		proService = new ProductService(emf.createEntityManager());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = null;
		
		if("/products".equals(req.getServletPath())) {
			
			// get parameter
			String catId = req.getParameter("category");
			String name = req.getParameter("name");
			
			// search product with parameter
			List<Product> list = proService.search(catId, name);
			
			// add result to request scope
			req.setAttribute("list", list);
			
			page = "/views/products/list.jsp";
		} else {
			
			String pId = req.getParameter("id");
			
			if(null != pId) {
				// edit product
				// find product by id
				// add product to request scope
				req.setAttribute("title", "Edit Product");
			} else {
				// add new product
				req.setAttribute("title", "Add New Product");
			}
			
			page = "/views/products/edit.jsp";
		}
		
		// search category and add to request scope
		req.setAttribute("categories", catService.getAll());
		
		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}

}
