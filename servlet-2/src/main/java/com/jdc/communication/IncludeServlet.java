package com.jdc.communication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/include", loadOnStartup = 1)
public class IncludeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher header = getServletContext().getNamedDispatcher("header");
		// Include Header
		header.include(req, resp);
		
		resp.getWriter().append("<h1>").append("This is Include Servlet").append("</h1>").flush();
		
		// Include Footer
		RequestDispatcher footer = req.getRequestDispatcher("footer");
		footer.include(req, resp);
		
	}
}
