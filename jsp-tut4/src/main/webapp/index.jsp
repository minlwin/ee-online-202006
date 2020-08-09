<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>

<c:import url="/common/resources.jsp"></c:import>

</head>
<body>

	
	<div class="row ">
		
		<div class="col-4 m-auto">
			
			<div class="card login-form">
				
				<div class="card-body">
				
					<h3><i class="fa fa-sign-in mr-2"></i> Member Login</h3>
					
					<c:if test="${ not empty message }">
						<div class="alert alert-warning">${message}</div>
					</c:if>
					
					<c:url value="/login" var="login"></c:url>
					<form action="${login}" method="post" class="form">
						
						<div class="form-group">
							
							<label for="loginId">Login Id</label>
							<input type="text" name="loginId" required="required" placeholder="Enter Login Id" class="form-control" />
						
						</div>
						
						<div class="form-group">
						
							<label for="password">Password</label>
							<input type="password" class="form-control" name="password" id="password" placeholder="Enter Password" required="required" />
						</div>
						
						<button class="btn btn-primary">Member Login</button>
					
					</form>
				</div>
			
			</div>
		
		</div>
	</div>	

</body>
</html>