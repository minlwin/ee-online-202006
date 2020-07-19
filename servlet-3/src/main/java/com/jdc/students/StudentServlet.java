package com.jdc.students;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.students.model.Student;
import com.jdc.students.model.StudentModel;

@WebServlet(
		urlPatterns = {"/students", "/student-add", "/student-save"},
		loadOnStartup = 1
)
public class StudentServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private StudentModel model;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		emf = Persistence.createEntityManagerFactory("servlet-3");
		em = emf.createEntityManager();
		model = new StudentModel(em);
	}
	
	@Override
	public void destroy() {
		
		em.close();
		emf.close();
		
		super.destroy();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getServletPath().equals("/students")) {
			List<Student> list = model.findAll();
			req.setAttribute("list", list);
			getServletContext().getRequestDispatcher("/student-list.jsp").forward(req, resp);
		} else if(req.getServletPath().equals("/student-add")) {
			getServletContext().getRequestDispatcher("/student-edit.jsp").forward(req, resp);
		} else {
			getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// create student object
		Student s = new Student();
		
		// set name
		s.setName(req.getParameter("name"));
		
		// set phone
		s.setPhone(req.getParameter("phone"));
		
		// set email
		s.setEmail(req.getParameter("email"));
		
		// set address
		s.setAddress(req.getParameter("address"));
		
		// insert into database
		model.save(s);
		
		// redirect student list
		resp.sendRedirect("/students");
		
	}

}
