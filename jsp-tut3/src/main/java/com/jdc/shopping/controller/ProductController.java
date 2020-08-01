package com.jdc.shopping.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jdc.shopping.model.entity.Category;
import com.jdc.shopping.model.entity.Product;
import com.jdc.shopping.model.service.CategoryService;
import com.jdc.shopping.model.service.ProductService;

@WebServlet(
		urlPatterns = {
				"/products",
				"/products/edit",
				"/products/upload"
		})
@MultipartConfig
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
			
			req.setAttribute("menu", "products");
			
			page = "/views/products/list.jsp";
		} else {
			
			String pId = req.getParameter("id");
			
			if(null != pId) {
				// edit product
				// find product by id
				Product product = proService.findById(Integer.parseInt(pId));
				// add product to request scope
				req.setAttribute("product", product);
				req.setAttribute("title", "Edit Product");
			} else {
				// add new product
				req.setAttribute("title", "Add New Product");
			}
			
			req.setAttribute("menu", "product-edit");
			page = "/views/products/edit.jsp";
		}
		
		// search category and add to request scope
		req.setAttribute("categories", catService.getAll());
		
		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		if(req.getServletPath().equals("/products")) {
			
			// save product
			
			String id = req.getParameter("id");
			String categoryId = req.getParameter("category");
			String name = req.getParameter("name");
			String price = req.getParameter("price");

			Product product = (null == id || id.isEmpty()) ? new Product() : proService.findById(Integer.parseInt(id));
			
			Category category = catService.findById(Integer.parseInt(categoryId));
			
			product.setCategory(category);
			product.setName(name);
			product.setPrice(Integer.parseInt(price));
			
			proService.save(product);
			
		} else {
			
			// upload file
			Part file = req.getPart("file");
			
			try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream())) ) {
				
				String line = null;
				List<String> list = new ArrayList<>();
				while (null != (line = br.readLine())) {
					list.add(line);
				}
				
				proService.saveAll(list);
			} 
			
		}

		resp.sendRedirect(req.getContextPath().concat("/products"));
	}

}
