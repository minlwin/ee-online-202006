package com.jdc.students.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.students.model.entity.Account;
import com.jdc.students.model.service.SecurityService;

@WebServlet({
	"/login",
	"/logout"
})
public class SecurityServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private SecurityService service;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);

		if("/login".equals(req.getServletPath())) {
			
			try {
				String loginId = req.getParameter("loginId");
				String password = req.getParameter("password");
				
				// check already login
				Object result = getServletContext().getAttribute(loginId);
				if(null != result) {
					throw new RuntimeException("You are already login with other browser!");
				}
				
				Account login = service.login(loginId, password);
				
				session.setAttribute("login", login);
				
			} catch (Exception e) {
				
				req.setAttribute("message", null == e.getCause() ? e.getMessage() : e.getCause().getMessage());
				getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
				
				return;
			}
			
		} else {
			session.invalidate();
		}
		
		resp.sendRedirect(req.getContextPath().concat("/home"));
	}
}
