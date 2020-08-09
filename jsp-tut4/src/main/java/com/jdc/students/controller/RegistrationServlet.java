package com.jdc.students.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.students.model.entity.Account;

@WebServlet({
	"/home",
	"/auth/registration-edit"
})
public class RegistrationServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
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
				// add to request scope
				
				view = "/views/registrations.jsp";
			}
			
		} else {
			view  = "/views/registration-edit.jsp";
		}
		
		getServletContext().getRequestDispatcher(view).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// save registration
		resp.sendRedirect(req.getContextPath().concat("/home"));
	}

}
