<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JPA with Servlet</title>
</head>
<body>

	<h1>JPA with Servlet</h1>
	<h3>Using Non-JTA DataSource by Annotations</h3>
	
	<c:choose>
		<c:when test="${empty users}">
			<c:url var="userUrl" value="/users"></c:url>
			
			<h4>Add User</h4>
			<form action="${userUrl}" method="post">
			
				<table style="width: 40%">
					<tr>
						<td>Name</td>
						<td>
							<input name="name" placeholder="Enter User Name">
						</td>
					</tr>
					<tr>
						<td>Phone</td>
						<td>
							<input name="phone" placeholder="Enter Phone Number">
						</td>
					</tr>
					
					<tr>
						<td></td>
						<td>
							<input type="submit" value="Save">
						</td>
					</tr>
					
				</table>
			</form>
			
		</c:when>
		
		<c:otherwise>
		
			<h3>Users</h3>
			
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Phone</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${users}" var="u">
						<tr>
							<td>${u.id}</td>
							<td>${u.name}</td>
							<td>${u.phone}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</c:otherwise>
	</c:choose>

</body>
</html>