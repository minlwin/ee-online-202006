<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward</title>
</head>
<body>

	<h1>Forward To JSP</h1>
	
	<table>
		<tr>
			<td>Name</td>
			<td>
				<%= request.getParameter("name") %>
			</td>
		</tr>
		
		<tr>
			<td>Subject</td>
			<td>
				<%= request.getParameter("subject") %>
			</td>
		</tr>

		<tr>
			<td>Gender</td>
			<td>
				<%= request.getParameter("gender") %>
			</td>
		</tr>
		
		<tr>
			<td>Interest</td>
			<td>
				<%= request.getAttribute("interest") %>
			</td>
		</tr>
		
	</table>
	
	<a href="/index.jsp">Back</a>
</body>
</html>