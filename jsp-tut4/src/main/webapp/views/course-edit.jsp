<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${empty course ? 'Create' : 'Edit'} Course</title>

<c:import url="/common/resources.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="../resources/fontawesome-4.7/css/font-awesome.min.css" />
</head>
<body>

	<c:import url="/common/menu.jsp"></c:import>
	
	
	<div class="container">
		<h3 class="mt-4 mb-2">${empty course ? 'Create' : 'Edit'} Course</h3>
		
		
		<div class="row">
			<div class="col-lg-6">
				<c:url value="/auth/course-edit" var="save"></c:url>
				<form action="${save}" method="post" class="form">
					
					<input type="hidden" name="id" value="${course.id}" />
					<div class="form-group">
						<label for="name">Course Name</label>
						<input value="${course.name}" placeholder="Enter Course Name" required="required" type="text" name="name" class="form-control" id="name" />
					</div>
					
					<div class="form-row">
					
						<div class="col-lg-6">
							<div class="form-group">
								<label for="level">Level</label>
								<select name="level" id="level" class="form-control">
									<c:forEach items="${levels}" var="l">
										<option ${course.level eq l ? 'selected' : ''}>${l}</option>
									</c:forEach>									
								</select>
							</div>
						
						</div>
						
						<div class="col-lg-6">
							
							<div class="form-group">
								<label for="hours">Hours</label>
								<input value="${course.hours}" type="number" required="required" name="hours" id="hours" placeholder="Enter Total Hours" class="form-control" />
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label for="fees">Fees</label>
						<input value="${course.fees}" type="number" name="fees" required="required" id="fees" placeholder="Enter Course Fees" class="form-control" />
					</div>
					
					<div class="form-group">
						<label for="description">Description</label>
						<textarea name="description" id="description" class="form-control">${course.description}</textarea>
					</div>
					
					<div>
						<button type="reset" class="btn btn-primary">
							<i class="fa fa-recycle"></i> Clear
						</button>
						
						<button class="btn btn-danger">
							<i class="fa fa-save"></i> Save
						</button>
					</div>
				
				</form>
			
			</div>
		</div>
	
	</div>
	

</body>
</html>