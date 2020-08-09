<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses</title>

<c:import url="/common/resources.jsp"></c:import>

</head>
<body>

	<c:import url="/common/menu.jsp"></c:import>
	
	<div class="container">
		<h3 class="mt-4 mb-2">Courses</h3>
		
		<table class="table">
			
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Level</th>
					<th>Hours</th>
					<th>Fees</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${list}" var="c">
					<tr>
						<td>${c.id}</td>
						<td>${c.name}</td>
						<td>${c.level}</td>
						<td>${c.hours} Hours</td>
						<td>${c.fees} MMK</td>
						<td>
							<c:url value="/auth/course-edit" var="edit">
								<c:param name="id" value="${c.id}"></c:param>
							</c:url>
							<a href="${edit}">
								<i class="fa fa-pencil"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
		
	</div>
</body>
</html>