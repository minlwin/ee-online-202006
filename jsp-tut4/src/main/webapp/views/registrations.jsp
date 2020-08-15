<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>

<c:import url="/common/resources.jsp"></c:import>

</head>
<body>

	<c:import url="/common/menu.jsp"></c:import>
	
	<div class="container">
		
		<h3 class="mt-4 mb-2">Registrations</h3>
		
		<!-- Search Box -->
		<div class="card">
			<div class="card-body">
				
				<c:url value="/home" var="action"></c:url>
				<form action="${action}" class="form">
					
					<div class="form-row">
						<!-- Course -->
						<div class="col">
							<div class="form-group">
								<label for="course">Course</label>
								<select name="course" id="course" class="form-control">
									<option value="0">All Courses</option>
									<c:forEach items="${courses}" var="c">
										<option value="${c.id}" ${param.course eq c.id ? 'selected' : ''} >${c.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>						
						<!-- Student Name -->
						<div class="col">
							<div class="form-group">
								<label for="student">Student</label>
								<input type="text" class="form-control" name="student" value="${param.student}" id="student" placeholder="Search Student Name" />
							</div>
						</div>
						
						<!-- Date From -->
						<div class="col">
							<div class="form-group">
								<label for="from">Date From</label>
								<input type="date" name="from" id="from" value="${param.from}" class="form-control" placeholder="Date From" />
							</div>
						</div>
						
						<!-- Date To -->
						<div class="col">
							<div class="form-group">
								<label for="to">Date To</label>
								<input type="date" value="${param.to}" name="to" id="to" class="form-control" placeholder="Date To" />
							</div>
						</div>
						
						<div class="col">
							<div class="form-group">
								<button class="btn btn-outline-primary" style="margin-top: 32px">Search</button>
							</div>
						</div>

					
					</div>
					
				</form>
				
			</div>
		</div>
		
		<!-- Result Table -->
		
		<table class="table mt-3">
			
			<thead>
				<tr>
					<th>ID</th>
					<th>Course</th>
					<th>Apply Date</th>
					<th>Student</th>
					<th>Phone</th>
					<th>Email</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${list}" var="r">
				
					<tr>
						<td>${r.id}</td>
						<td>${r.course.name}</td>
						<td>${r.applyDate}</td>
						<td>${r.student.name}</td>
						<td>${r.student.phone}</td>
						<td>${r.student.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
	
	</div>
	

</body>
</html>