package com.jdc.students.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.students.model.entity.Course;
import com.jdc.students.model.entity.Course.Level;
import com.jdc.students.model.service.CourseService;

@WebServlet({"/auth/courses", "/auth/course-edit"})
public class CourseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private CourseService service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		// to forward jsp
		String view = null;
		
		if("/auth/courses".equals(path)) {
			
			// course list
			List<Course> list = service.getAll();
			req.setAttribute("list", list);
			
			view = "/views/course-list.jsp";
		} else {
			// navigate to edit course
			String str = req.getParameter("id");
			
			if(null != str && !str.isEmpty()) {
				int id = Integer.parseInt(str);
				Course course = service.findById(id);
				req.setAttribute("course", course);
			}
			
			req.setAttribute("levels", Level.values());
			
			view = "/views/course-edit.jsp";
		}
		
		getServletContext().getRequestDispatcher(view).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// save course 
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String level = req.getParameter("level");
		String hours = req.getParameter("hours");
		String fees = req.getParameter("fees");
		String description = req.getParameter("description");
		
		Course c = new Course();
		c.setId(getInt(id));
		c.setName(name);
		c.setLevel(Level.valueOf(level));
		c.setHours(getInt(hours));
		c.setFees(getInt(fees));
		c.setDescription(description);
		
		service.save(c);
		
		resp.sendRedirect(req.getContextPath().concat("/auth/courses"));
	}
	
	private int getInt(String str) {
		return null != str && !str.isEmpty() ? Integer.parseInt(str) : 0;
	}
}
