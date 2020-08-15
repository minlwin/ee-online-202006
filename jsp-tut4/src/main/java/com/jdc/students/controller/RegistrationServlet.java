package com.jdc.students.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.students.model.entity.Account;
import com.jdc.students.model.entity.Registration;
import com.jdc.students.model.entity.Student;
import com.jdc.students.model.service.CourseService;
import com.jdc.students.model.service.RegistrationService;

@WebServlet({
	"/home",
	"/auth/registration-edit"
})
public class RegistrationServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private CourseService courses;
	
	@EJB
	private RegistrationService registrations;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();
		
		String view = null;
		
		if("/home".equals(path)) {
			
			HttpSession session = req.getSession(true);
			Account login = (Account) session.getAttribute("login");
			
			if(null == login) {
				// anonymous
				view = "/index.jsp";
			} else {
				// already login
				// search registrations
				String courseId = req.getParameter("course");
				String student = req.getParameter("student");
				String from = req.getParameter("from");
				String to = req.getParameter("to");
				
				List<Registration> list = registrations.search(courseId, student, from, to);
				// add to request scope
				req.setAttribute("list", list);
				
				view = "/views/registrations.jsp";
			}
			
		} else {
			view  = "/views/registration-edit.jsp";
		}
		
		req.setAttribute("courses", courses.getAll());
		
		getServletContext().getRequestDispatcher(view).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String course = req.getParameter("course");
		String applyDate = req.getParameter("applyDate");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("mail");
		
		Student student = new Student();
		student.setName(name);
		student.setPhone(phone);
		student.setEmail(email);
		
		registrations.create(course, applyDate, student);
		
		// save registration
		resp.sendRedirect(req.getContextPath().concat("/home"));
	}

}
