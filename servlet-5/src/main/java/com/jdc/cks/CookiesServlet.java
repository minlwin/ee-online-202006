package com.jdc.cks;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookies")
public class CookiesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		Cookie ck  = new Cookie("myCookie", name);
		
		resp.addCookie(ck);
		
		resp.sendRedirect("/cookies");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie [] cks = req.getCookies();
		
		for(Cookie c : cks) {
			if(c.getName().equals("myCookie")) {
				req.setAttribute("name", c.getValue());
			}
		}
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
}
