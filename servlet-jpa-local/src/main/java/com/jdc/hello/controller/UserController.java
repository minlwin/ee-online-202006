package com.jdc.hello.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.hello.model.UserModel;
import com.jdc.hello.model.Users;

@WebServlet(urlPatterns = "/users", loadOnStartup = 1)
public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@PersistenceUnit(unitName = "servlet-jpa-local")
	private EntityManagerFactory emf;
	
	private UserModel model;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		model = new UserModel(emf.createEntityManager());
	}
	
	@Override
	public void destroy() {
		super.destroy();
		model.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("users", model.findAll());
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		
		Users user = new  Users();
		user.setName(name);
		user.setPhone(phone);
		
		model.save(user);
		
		resp.sendRedirect("users");
	}

}
