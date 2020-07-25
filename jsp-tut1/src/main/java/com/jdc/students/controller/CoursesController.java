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

import com.jdc.students.model.entity.Course;
import com.jdc.students.model.service.CourseService;

@WebServlet(urlPatterns = {"/courses"}, loadOnStartup = 1)
public class CoursesController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private CourseService service;
	
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
		
		service = new CourseService(emf.createEntityManager());
	}
	
	@Override
	public void destroy() {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf.isOpen()) {
			emf.close();
		}
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", service.getAll());
		getServletContext().getRequestDispatcher("/courses.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get request params
		Course c  = (Course) req.getAttribute("course");
		
		// create course
		service.create(c);
		
		// redirect to course list
		resp.sendRedirect("courses");
	}
}
