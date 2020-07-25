<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a href="index.jsp" class="navbar-brand"><%= request.getParameter("title") %></a>
		
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a href="courses" class="nav-link">Courses</a>
			</li>
			
			<li class="nav-item">
				<a href="classes" class="nav-link">Classes</a>
			</li>

			<li class="nav-item">
				<a href="registrations" class="nav-link">Registrations</a>
			</li>

		</ul>
	</div>
</nav>