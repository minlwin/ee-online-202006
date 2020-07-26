package com.jdc.counter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/countUp")
public class CounterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static final String COUNTER = "counter";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		Counter c1 = (Counter) req.getAttribute(COUNTER);
//		if(null == c1) {
//			c1 = new Counter();
//			req.setAttribute(COUNTER, c1);
//		}
//		
//		c1.countUp();
		
		HttpSession session = req.getSession(true);
		Counter c2 = (Counter) session.getAttribute(COUNTER);
		
		if(null == c2) {
			c2 = new Counter();
			session.setAttribute(COUNTER, c2);
		}
		
		c2.countUp();
		
		Counter c3 = (Counter) getServletContext().getAttribute(COUNTER);
		if(null == c3) {
			c3 = new Counter();
			getServletContext().setAttribute(COUNTER, c3);
		}
		
		c3.countUp();
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
