package com.jdc.students.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jdc.students.model.entity.Account;

@WebFilter("/auth/*")
public class SecurityFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// before target
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session  = req.getSession(true);
		
		Account login = (Account) session.getAttribute("login");
		
		if(null == login) {
			req.setAttribute("message", "Please login again!");
			req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, response);
		} else {
			chain.doFilter(request, response);
		}
		
	}

}
