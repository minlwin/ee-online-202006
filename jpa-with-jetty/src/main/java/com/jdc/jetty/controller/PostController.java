package com.jdc.jetty.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.jetty.model.PostModel;
import com.jdc.jetty.model.entity.Post;

@WebServlet(urlPatterns = "/posts", loadOnStartup = 1)
public class PostController extends HttpServlet{
	
	private PostModel model;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-with-jetty");
		model = new PostModel(emf.createEntityManager());
		super.init(config);
	}
	
	@Override
	public void destroy() {
		model.terminate();
		super.destroy();
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", model.findAll());
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Post post = new Post();
		post.setTitle(req.getParameter("title"));
		post.setMessage(req.getParameter("message"));
		model.save(post);
		resp.sendRedirect("posts");
	}
}
