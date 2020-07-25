package com.jdc.students.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.students.model.entity.Classes;
import com.jdc.students.model.entity.Registration;
import com.jdc.students.model.service.ClassesService;
import com.jdc.students.model.service.RegistrationService;

@WebServlet(urlPatterns = {"/registrations", "/registration-edit"}, loadOnStartup = 1)
public class RegistrationController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private ClassesService classService;
	private RegistrationService regService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if("/registration-edit".equals(req.getServletPath())) {
			String classId = req.getParameter("classId");
			Classes classes = classService.findById(Integer.parseInt(classId));
			req.setAttribute("classes", classes);
			getServletContext().getRequestDispatcher("/registration-edit.jsp").forward(req, resp);
			
		} else {
			req.setAttribute("list", regService.getAll());
			getServletContext().getRequestDispatcher("/registrations.jsp").forward(req, resp);
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String classId = req.getParameter("classId");
		Classes classes = classService.findById(Integer.parseInt(classId));
		
		Registration r = new Registration();
		r.setClasses(classes);
		r.setName(req.getParameter("name"));
		r.setPhone(req.getParameter("phone"));
		r.setEmail(req.getParameter("email"));
		
		regService.create(r);
		
		resp.sendRedirect("registrations");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		Object object = getServletContext().getAttribute("emf");
		
		EntityManagerFactory emf = null;
		
		if(null == object) {
			emf = Persistence.createEntityManagerFactory("jsp-tut1");
			getServletContext().setAttribute("emf", emf);
		} else {
			emf = (EntityManagerFactory) object;
		}
		
		regService = new RegistrationService(emf.createEntityManager());
		classService = new ClassesService(emf.createEntityManager());
	}
	
	@Override
	public void destroy() {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf.isOpen()) {
			emf.close();
		}
		super.destroy();
	}
}
