<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Registration</title>

<c:import url="/common/resources.jsp"></c:import>

</head>
<body>

	<c:import url="/common/menu.jsp"></c:import>
	
	<div class="container">
	
		<h3 class="mt-4 mb-2">Create Registration</h3>
		
		<div class="row">
			<div class="col-6">
				<c:url value="/auth/registration-edit" var="action"></c:url>
				<form action="${action}" method="post" class="form">
					
					<!-- Select Course -->
					<div class="form-group">
						<label for="course">Course</label>
						<select name="course" id="course" class="form-control">
							<c:forEach items="${courses}" var="c" >
								<option value="${c.id}">${c.name}</option>
							</c:forEach>
						</select>
					</div>
					
					<!-- Apply Date -->
					<div class="form-group">
						<label for="applyDate">Apply Date</label>
						<input type="date" name="applyDate" id="applyDate" placeholder="Enter Date" required="required" class="form-control" />
					</div>
					
					<!-- Student Name -->
					<div class="form-group">
						<label for="name">Student Name</label>
						<input type="text" required="required" name="name" placeholder="Enter Name" id="name" class="form-control" />
					</div>
					
					<!-- Student Phone -->
					<div class="form-group">
						<label for="phone">Phone Number</label>
						<input type="tel" name="phone" placeholder="Enter Phone" required="required" id="phone" class="form-control" />
					</div>
					
					<!-- Email -->
					<div class="form-group">
						<label for="mail">Email</label>
						<input type="email" name="mail" id="mail" required="required" class="form-control" placeholder="Enter Email" />
					</div>
					
					<button type="reset" class="btn btn-outline-primary">Clear</button>
					<button class="btn btn-outline-danger">Create Registration</button>
				</form>
			
			</div>
		</div>
	</div>

</body>
</html>