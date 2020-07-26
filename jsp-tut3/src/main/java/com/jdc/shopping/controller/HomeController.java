package com.jdc.shopping.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = "/home", loadOnStartup = 1
)
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		
		if(null == emf) {
			emf = Persistence.createEntityManagerFactory("jsp-tut3");
			getServletContext().setAttribute("emf", emf);
		}
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
		
		getServletContext().getRequestDispatcher("/views/home.jsp").forward(req, resp);
	}

}
