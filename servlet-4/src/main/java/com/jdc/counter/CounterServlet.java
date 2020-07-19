package com.jdc.counter;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// add counter to application Scope
		Counter counter = new Counter();
		getServletContext().setAttribute("counter", counter);
	}

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// get counter from request scope
		Object reqCounter = req.getAttribute("counter");
		
		if(null != reqCounter) {
			Counter c = (Counter) reqCounter;
			c.countUp();
		} else {
			Counter c = new Counter();
			c.countUp();
			req.setAttribute("counter", c);
		}
		
		// get counter from session scope
		HttpSession session = req.getSession(true);
		Object sesCounter = session.getAttribute("counter");
		
		if(null != sesCounter) {
			Counter c = (Counter) sesCounter;
			c.countUp();
		} else {
			Counter c = new Counter();
			c.countUp();
			session.setAttribute("counter", c);
		}
		
		Object appCounter = getServletContext().getAttribute("counter");
		Counter c = (Counter) appCounter;
		c.countUp();
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		session.invalidate();
		resp.sendRedirect("/counter");
	}

}
