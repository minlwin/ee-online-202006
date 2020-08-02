<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

</head>
<body>

	<c:if test="${empty list}">
		<c:redirect url="categories"></c:redirect>
	</c:if>	
	
	<h3>Using Data Source</h3>
	
	<ul>
		<c:forEach items="${list}" var="c">
			<li>${c.name}</li>
		</c:forEach>
	</ul>

</body>
</html>