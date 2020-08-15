package com.jdc.students.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.students.model.entity.Student;
import com.jdc.students.model.service.StudentService;

@WebServlet({
	"/auth/students",
	"/auth/student-edit"
})
public class StudentServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private StudentService students;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String view = null;
		
		if("/auth/students".equals(req.getServletPath())) {
			
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			
			List<Student> list  = students.search(name, phone);
			req.setAttribute("list", list);
			
			view = "/views/student-list.jsp";
		} else {
			
			String str = req.getParameter("id");
			
			Student student = students.findById(str);
			req.setAttribute("student", student);
			
			view = "/views/student-edit.jsp";
		}
		
		getServletContext().getRequestDispatcher(view).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		students.update(id, name, phone, email);
		
		resp.sendRedirect(req.getContextPath().concat("/auth/students"));
	}
	
}
