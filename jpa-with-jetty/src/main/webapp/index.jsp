<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JPA with Jetty</title>
</head>
<body>

	<h1>JPA with Jetty</h1>
	
	<p>
		Using Jakarta Servlet 4.0, JPA 2.2 with Jetty Maven Plugin. 
	</p>

	<c:url var="post" value="/posts"></c:url>
	
	
	<c:choose>
		
		<c:when test="${empty list}">
			<h3>Add Post</h3>
			
			<form action="${post}" method="post">
				<table style="width: 50%">
					<tr>
						<td>Title</td>
						<td>
							<input name="title" style="width:100%" placeholder="Enter Title">
						</td>
					</tr>
					
					<tr>
						<td>Message</td>
						<td>
							<textarea name="message" rows="5" style="width: 100%"></textarea>
						</td>
					</tr>
					
					<tr>
						<td></td>
						<td>
							<input type="submit" value="Save" />
						</td>
					</tr>
				</table>
			</form>
		</c:when>
		
		<c:otherwise>
		
			<h3>Post List</h3>
			
			<table style="width: 80%">
				<thead>
					<tr>
						<th>Id</th>
						<th>Title</th>
						<th>Message</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${list}" var="p">
						<tr>
							<td>${p.id}</td>
							<td>${p.title}</td>
							<td>${p.message}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
		</c:otherwise>
	</c:choose>
</body>
</html>