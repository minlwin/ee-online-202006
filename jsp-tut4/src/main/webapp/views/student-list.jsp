<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>

<c:import url="/common/resources.jsp"></c:import>

</head>
<body>

	<c:import url="/common/menu.jsp"></c:import>
	
	<div class="container">
	
		<h3 class="mt-4 mb-2">Student List</h3>
		
		<!-- Search Form -->
		<div class="card">
			<div class="card-body">
				<c:url value="/auth/students" var="search"></c:url>
				<form action="${search}" class="form">
					<div class="form-row">
						<div class="col-4">
							<div class="form-group">
								<label for="name">Name</label>
								<input name="name" type="text" placeholder="Search Name" class="form-control" id="name" value="${param.name}" />
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label for="phone">Phone</label>
								<input name="phone" type="tel" placeholder="Search Phone" class="form-control" id="phone" value="${param.phone}" />
							</div>
						</div>
						<div class="col-4">
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
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<c:if test="${login.role eq 'Office'}">
						<th></th>
					</c:if>
				</tr>
			</thead>
			
			<tbody>
				
				<c:forEach items="${list}" var="s">
				
					<tr>
						<td>${s.id}</td>
						<td>${s.name}</td>
						<td>${s.phone}</td>
						<td>${s.email}</td>
						<c:if test="${login.role eq 'Office'}">
							<td>	
								<c:url value="/auth/student-edit" var="edit">
									<c:param name="id" value="${s.id}"></c:param>
								</c:url>
								<a href="${edit}">
									<i class="fa fa-pencil"></i>
								</a>
							</td>
						</c:if>
					</tr>
				
				</c:forEach>
			
			</tbody>
		
		</table>
	</div>
		

</body>
</html>