<%@page import="com.jdc.counter.Counter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scope Demo</title>
</head>
<body>

	<h1>Scope Demo</h1>
	
	<table>
		<tr>
			<td>Request</td>
			<td>
				<% 
					Object obj1 = request.getAttribute("counter");
					Counter reqCounter = null != obj1 ? (Counter)obj1 : new Counter();
				%>
				
				<%= reqCounter.getCount() %>
			</td>
		</tr>
		<tr>
			<td>Session</td>
			<td>
				<% 
					Object obj2 = session.getAttribute("counter");
					Counter sesCounter = null != obj2 ? (Counter)obj2 : new Counter();
				%>
				
				<%= sesCounter.getCount() %>
			</td>
		</tr>
		<tr>
			<td>Application</td>
			<td>
				
				<% 
					Object obj3 = application.getAttribute("counter");
					Counter appCounter = null != obj3 ? (Counter)obj3 : new Counter();
				%>
				<%= appCounter.getCount() %>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<a href="/counter">Count Up</a>
			</td>
		</tr>
		
		<tr>
			<td></td>
			<td>
				<form action="/counter" method="post">
					<button type="submit">Invalidate Session</button>
				</form>
			</td>
		</tr>
	</table>

</body>
</html>