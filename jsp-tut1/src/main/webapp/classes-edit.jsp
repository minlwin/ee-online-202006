<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Demo</title>

<jsp:include page="/common/resources.jsp"></jsp:include>

</head>
<body>

	<jsp:include page="/common/header.jsp">
		<jsp:param value="JSP Demo" name="title"/>
	</jsp:include>
	
	<div class="container">
		
		<h1>Add New Class</h1>
		
		<div class="grid">
			<div class="row">
				<div class="col-6">
					
					<form action="classes" method="post" class="form">
					
						<input type="hidden" name="courseId" value="${course.id}" />
						
						<div class="form-group">
							<label>Course</label>
							<input class="form-control" type="text" readonly="readonly" value="${course.name}" />
						</div>
					
						<div class="form-group">
							<label>Start Date</label>
							<input name="startDate" required="required" class="form-control" type="date" placeholder="Enter Start Date"  />
						</div>

						<div class="form-group">
							<label>Duration</label>
							<input class="form-control" type="text" readonly="readonly" value="${course.duration} Months" />
						</div>

						<div class="form-group">
							<label>Fees</label>
							<input class="form-control" type="text" readonly="readonly" value="${course.fees} MMK" />
						</div>
						
						<div class="form-group">
							<button type="submit" class="btn btn-primary">
								Create Class
							</button>
						</div>

					</form>
				
				</div>
			
			</div>
		</div>
	</div>

</body>
</html>