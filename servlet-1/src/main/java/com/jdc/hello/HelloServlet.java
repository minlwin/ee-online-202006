package com.jdc.hello;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Hello Servlet Initialization");
		super.init(config);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.getWriter().append("Hello Servlet").flush();
		System.out.println("Service is called");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy Hello Servlet");
		super.destroy();
	}

}
