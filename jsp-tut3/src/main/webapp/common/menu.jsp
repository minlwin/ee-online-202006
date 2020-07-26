<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/home" var="home" ></c:url>
<c:url value="/products" var="products" ></c:url>
<c:url value="/products/edit" var="editProduct" ></c:url>
<c:url value="/cart" var="cart" ></c:url>

<div class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
	
	<div class="container">
		<a href="${home}" class="navbar-brand">Sales</a>
		
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a href="${products}" class="nav-link">Products</a></li>
			<li class="nav-item"><a href="${editProduct}" class="nav-link">Add Product</a></li>
			<li class="nav-item"><a href="${cart}" class="nav-link">My Cart</a></li>
		</ul>
	
	</div>
</div>