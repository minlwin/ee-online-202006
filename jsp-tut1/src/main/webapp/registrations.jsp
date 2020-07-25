<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrations</title>

<jsp:include page="/common/resources.jsp"></jsp:include>

</head>
<body>

	<jsp:include page="/common/header.jsp">
		<jsp:param value="JSP Demo" name="title"/>
	</jsp:include>
	
	<div class="container">
	
		<h1>Registrations</h1>
		
		<table class="table">
		
			<thead>
				<tr>
					<th>ID</th>
					<th>Course</th>
					<th>Start Date</th>
					<th>Student</th>
					<th>Phone</th>
					<th>Email</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${list}" var="r">
					<tr>
						<td>${r.id}</td>
						<td>${r.classes.course.name}</td>
						<td>${r.classes.startDate}</td>
						<td>${r.name}</td>
						<td>${r.phone}</td>
						<td>${r.email}</td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
		
	</div>

</body>
</html>