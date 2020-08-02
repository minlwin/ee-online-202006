<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Search Product -->
<div class="fluid card">
	
	<div class="card-body">
		<h4 class="card-title">Search Product</h4>
		
		<c:url value="/home" var="search"></c:url>
		<form action="${search}" class="form form-inline">
			
			<div class="form-row">
				
				<div class="form-group mr-4">
					<label class="mr-2">Category</label>
					<select name="category" class="form-control">
						<option value="0">All Categories</option>
						
						<c:forEach items="${categories}" var="c">
							<option value="${c.id}" ${param.category eq c.id ? 'selected' : ''}>${c.name}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group mr-4">
					<label class="mr-2">Name</label>
					<input name="name" value="${param.name}" type="text" placeholder="Search Name" class="form-control" />
				</div>
				
				<div class="form-grou">
					<button class="btn btn-primary">
						<i class="fa fa-search"></i> Search
					</button>
				</div>
			</div>
		
		</form>
	</div>
	

</div>

<table class="table mt-4">
	<thead>
		<tr>
			<th>ID</th>
			<th>Category</th>
			<th>Product</th>
			<th class="text-right">Price</th>
			<th></th>
		</tr>
		
	</thead>
	<tbody>
		
		<c:forEach items="${products}" var="p">
			
			<tr>
				<td>${p.id}</td>
				<td>${p.category.name}</td>
				<td>${p.name}</td>
				<td class="text-right">${p.price}</td>
				<td class="text-right">
					<c:url value="/add-to-cart" var="addToCart">
						<c:param name="id" value="${p.id}"></c:param>
					</c:url>
					<a href="${addToCart}">
						<i class="fa fa-cart-plus"></i>
					</a>
				</td>
			</tr>
		
		</c:forEach>
	
	</tbody>
</table>