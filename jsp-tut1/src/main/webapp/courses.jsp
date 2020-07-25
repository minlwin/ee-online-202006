<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses</title>

<jsp:include page="/common/resources.jsp"></jsp:include>

</head>
<body>

	<jsp:include page="/common/header.jsp">
		<jsp:param value="JSP Demo" name="title"/>
	</jsp:include>
	
	<div class="container">
		<!-- Title -->
		<h1>
			Courses
			<a href="course-edit.jsp" class="btn btn-primary float-right mt-2">Add New Course</a>		
		</h1>
		
		
		<!-- Table -->
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Level</th>
					<th>Duration</th>
					<th>Fees</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${list}" var="course">
					
					<tr>
						<td>${course.id}</td>
						<td>${course.name}</td>
						<td>${course.level}</td>
						<td>${course.duration} Months</td>
						<td>${course.fees} MMK</td>
						<td>
							<c:url var="editUrl" value="/classes-edit">
								<c:param name="course" value="${course.id}"></c:param>
							</c:url>
							<a href="${editUrl}">Create Class</a>
						</td>
					</tr>
					
				</c:forEach>
			</tbody>
		</table>
	
	</div>

</body>
</html>