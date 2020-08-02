package com.jdc.shopping.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.shopping.model.entity.Sale;
import com.jdc.shopping.model.service.SaleService;

@WebServlet({"/sales", "/sales/edit"})
public class SalesController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private SaleService service;
	
	@Override
	public void init() throws ServletException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		service = new SaleService(emf.createEntityManager());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();
		if("/sales".equals(path)) {
			String from = req.getParameter("from");
			String to = req.getParameter("to");
			
			List<Sale> list = service.search(from, to);
			req.setAttribute("list", list);
			req.setAttribute("menu", "sales");
			
			getServletContext().getRequestDispatcher("/views/history.jsp").forward(req, resp);
		} else if ("/sales/edit".equals(path)) {
			
			String id = req.getParameter("id");
			
			if(null != id && !id.isEmpty()) {
				Sale sale = service.findById(id);
				HttpSession session = req.getSession(true);
				session.setAttribute("cart", sale);
			}
			
			resp.sendRedirect(req.getContextPath().concat("/home"));
		}
	}
}
