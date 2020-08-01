<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/home" var="home" ></c:url>
<c:url value="/products" var="products" ></c:url>
<c:url value="/products/edit" var="editProduct" ></c:url>
<c:url value="/sales" var="sales" ></c:url>

<div class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
	
	<div class="container-fluid">
		<a href="${home}" class="navbar-brand"><i class="fa fa-home"></i> POS</a>
		
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a href="${products}" class="nav-link ${menu eq 'products' ? 'active' : ''}"><i class="fa fa-gift"></i> Products</a></li>
			<li class="nav-item"><a href="${editProduct}" class="nav-link ${menu eq 'product-edit' ? 'active' : ''}"><i class="fa fa-plus"></i> Add Product</a></li>
			<li class="nav-item"><a href="${sales}" class="nav-link ${menu eq 'sales' ? 'active' : ''}"><i class="fa fa-calendar"></i> Sale History</a></li>
		</ul>
	
	</div>
</div>