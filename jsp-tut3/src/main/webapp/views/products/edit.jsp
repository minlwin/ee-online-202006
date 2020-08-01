<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>

<c:import url="/common/resources.jsp"></c:import>

</head>
<body>

	<c:import url="/common/menu.jsp"></c:import>
	
	<div class="container-fluid">
		
		<h2>${title}</h2>
		
		
		<div class="row">
		
			<div class="col-4">
				<c:url value="/products" var="save"></c:url>
				<form action="${save}" method="post">
					
					<input type="hidden" value="${product.id}" name="id">
					
					<div class="form-group">
						<label>Category</label>
						<select name="category" class="form-control">
							<c:forEach items="${categories}" var="c">
								<option value="${c.id}" ${c.id eq product.category.id ? 'selected' : ''}>${c.name}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label>Product Name</label>
						<input name="name" value="${product.name}" type="text" placeholder="Enter Name" required="required" class="form-control" />
					</div>
					
					<div class="form-group">
						<label>Price</label>
						<input type="number" value="${product.price}" name="price" class="form-control" placeholder="Enter Price" required="required" />
					</div>
					
					<div class="form-group">
						<button class="btn btn-primary" type="submit">
							<i class="fa fa-save"></i> Save
						</button>
					</div>
								
				</form>
			
			</div>
		
		</div>
	</div>

</body>
</html>