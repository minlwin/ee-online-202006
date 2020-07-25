<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Demo</title>

<jsp:include page="/common/resources.jsp"></jsp:include>
<link rel="stylesheet" href="resources/bootstrap.min.css" />

</head>
<body>

	<jsp:include page="/common/header.jsp">
		<jsp:param value="JSP Demo" name="title"/>
	</jsp:include>
	
	<div class="container">
	
		<h1>Add New Course</h1>
		
		<!-- form -->
		<div class="grid">
			<div class="row">
				<div class="col-6">
					<form action="course-confirm.jsp" method="post" class="form">
						
						<div class="form-group">
							<label>Name</label>
							<input name="name" type="text" placeholder="Enter Name" required="required" class="form-control" />
						</div>	
					
						<div class="form-group">
							<label>Level</label>
							<select name="level" class="form-control">
								<option>Basic</option>
								<option>Intermediate</option>
								<option>Advance</option>
							</select>
						</div>	

						<div class="form-group">
							<label>Duration</label>
							<input name="duration" type="number" placeholder="Enter Months" required="required" class="form-control" />
						</div>	

						<div class="form-group">
							<label>Fees</label>
							<input name="fees" type="number" placeholder="Enter Fees" required="required" class="form-control" />
						</div>	
						
						<div class="form-group">
							<button type="submit" class="btn btn-primary">
								Save Course
							</button>
						</div>
					</form>
				
				</div>
			</div>
		</div>
		
	</div>

</body>
</html>