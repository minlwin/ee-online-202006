<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar navbar-expand navbar-dark bg-dark">
	
	<div class="container">
		<c:url value="/home" var="home"></c:url>
		<a href="${home}" class="navbar-brand">
			<i class="fa fa-home"></i> Registrations
		</a>
		
		<ul class="navbar-nav nav mr-auto">
			

			<c:if test="${login.role eq 'Office'}">
				<li class="nav-item">
					<c:url value="/auth/registration-edit" var="register"></c:url>
					<a href="${register}" class="nav-link">
						<i class="fa fa-plus"></i> Create Registration
					</a>
				</li>
			</c:if>

			<li class="nav-item">
				<c:url value="/auth/students" var="students"></c:url>
				<a href="${students}" class="nav-link">
					<i class="fa fa-users"></i> Students
				</a>
			</li>
			
			<c:if test="${login.role eq 'Teacher'}">
				<li class="nav-item">
					<c:url value="/auth/courses" var="courses"></c:url>
					<a href="${courses}" class="nav-link">
						<i class="fa fa-book"></i> Courses
					</a>
				</li>
				<li class="nav-item">
					<c:url value="/auth/course-edit" var="coursEdit"></c:url>
					<a href="${coursEdit}" class="nav-link">
						<i class="fa fa-plus"></i> Create Course
					</a>
				</li>
			</c:if>
			
			
		</ul>
		
		<ul class="nav navbar-nav">
		
			<li class="nav-item">
				<span class="nav-link"><i class="fa fa-user"></i> ${login.name}</span>
			</li>
			
			<li class="nav-item">
				<a href="#" id="logoutMenu" class="nav-link">
					<i class="fa fa-sign-out"></i> Sign Out
				</a>
			</li>

		</ul>
	</div>
	
	<c:url value="/logout" var="signOut"></c:url>
	<form id="logoutForm" action="${signOut}" method="post" class="d-none" ></form>
	
	<script>
		$(() => {
			$('#logoutMenu').click(() => $('#logoutForm').submit())
		})
	</script>
</div>