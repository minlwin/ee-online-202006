package com.jdc.students.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({
	"/login",
	"/logout"
})
public class SecurityServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if("/login".equals(req.getServletPath())) {
			
		} else {
			
		}
		
		resp.sendRedirect(req.getContextPath().concat("/home"));
	}
}
