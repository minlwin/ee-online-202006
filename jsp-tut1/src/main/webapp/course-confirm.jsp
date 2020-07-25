<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<jsp:useBean id="course" 
		class="com.jdc.students.model.entity.Course" scope="request"></jsp:useBean>
		
	<jsp:setProperty property="*" name="course" />
	
	<jsp:forward page="courses"></jsp:forward>

</body>
</html>