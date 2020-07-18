package com.jdc.communication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/forward", "/forward-jsp"})
public class ForwardServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();

		String [] interest = req.getParameterValues("interest");
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < interest.length; i ++) {
			
			if(i > 0) {
				sb.append(", ");
			}
			
			sb.append(interest[i]);
		}
		
		req.setAttribute("interest", sb.toString());
		
		if(path.equals("/forward")) {
			getServletContext().getRequestDispatcher("/forward-to").forward(req, resp);
		} else {
			getServletContext().getRequestDispatcher("/forward.jsp").forward(req, resp);
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
		System.out.println("Post informations");
	}
}
