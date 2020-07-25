<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>

<jsp:include page="/common/resources.jsp"></jsp:include>

</head>
<body>

	<jsp:include page="/common/header.jsp">
		<jsp:param value="JSP Demo" name="title"/>
	</jsp:include>
	
	<div class="container">
		<h1>Registration</h1>
		
		<div class="grid">
			<div class="row">
				<div class="col-6">
					
					<form action="registrations" method="post" class="form">
					
						<input type="hidden" name="classId" value="${classes.id}" />
						
						<div class="form-group">
							<label>Course</label>
							<input type="text" class="form-control" readonly="readonly" value="${classes.course.name}" />
						</div>
					
						<div class="form-group">
							<label>Start Date</label>
							<input type="text" class="form-control" readonly="readonly" value="${classes.startDate}" />
						</div>

						<div class="form-group">
							<label>Name</label>
							<input name="name" type="text" required="required" class="form-control" placeholder="Enter Name" />
						</div>

						<div class="form-group">
							<label>Phone</label>
							<input name="phone" type="tel" required="required" class="form-control" placeholder="Enter Phone" />
						</div>

						<div class="form-group">
							<label>Email</label>
							<input name="email" type="email" required="required" class="form-control" placeholder="Enter Email" />
						</div>
						
						<div class="form-group">
							<button class="btn btn-primary" type="submit">Create Registration</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>