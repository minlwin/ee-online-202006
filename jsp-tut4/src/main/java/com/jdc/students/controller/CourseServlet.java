package com.jdc.students.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/auth/courses", "/auth/course-edit"})
public class CourseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		// to forward jsp
		String view = null;
		
		if("/auth/courses".equals(path)) {
			// course list
			view = "/views/course-list.jsp";
		} else {
			// navigate to edit course
			view = "/views/course-edit.jsp";
		}
		
		getServletContext().getRequestDispatcher(view).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// save course 
		
		resp.sendRedirect(req.getContextPath().concat("/auth/courses"));
	}
}
