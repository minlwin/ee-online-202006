package com.jdc.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/http", loadOnStartup = 1)
public class HelloHttpServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		resp.getWriter()
			.append("<html><body>")
			.append("<h1>")
			.append("Name is ").append(name)
			.append("</h1>")
			.append("</body></html>")
			.flush();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String subject = req.getParameter("subject");
		String gender = req.getParameter("gender");
		String [] interest = req.getParameterValues("interest");
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < interest.length; i ++) {
			
			if(i > 0) {
				sb.append(", ");
			}
			
			sb.append(interest[i]);
		}
		
		resp.getWriter()
		.append("<html><body>")
		.append("<h1>").append("Post Values").append("</h1>")
		.append("<table>")
		.append("<tr>").append("<td>").append("Name is ").append("</td>").append("<td>").append(name).append("</td>").append("</tr>")
		.append("<tr>").append("<td>").append("Subject is ").append("</td>").append("<td>").append(subject).append("</td>").append("</tr>")
		.append("<tr>").append("<td>").append("Gender is ").append("</td>").append("<td>").append(gender).append("</td>").append("</tr>")
		.append("<tr>").append("<td>").append("Interest are ").append("</td>").append("<td>").append(sb.toString()).append("</td>").append("</tr>")
		.append("</table>")
		.append("</body></html>")
		.flush();
	}

}
