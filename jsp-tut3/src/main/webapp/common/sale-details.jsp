<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Order List -->
<div class="fluid card">
	
	<div class="card-body">
		<h4 class="card-title"><i class="fa fa-shopping-cart"></i> Sale Details <span class="float-right pr-2">${cart.total}</span></h4>
		
		<table class="table table-md">
			<thead>
				<tr>
					<th>Product</th>
					<th class="text-right">Price</th>
					<th class="text-right">Qty</th>
					<th class="text-right">Total</th>
				</tr>
			</thead>
			
			<tbody>
			
				<!-- Sale Details -->
				<c:forEach items="${cart.details}" var="item">
					
					<tr>
						<td>${item.product.name}</td>
						<td class="text-right">${item.product.price}</td>
						<td class="text-right">${item.quentity}</td>
						<td class="text-right">${item.product.price * item.quentity}</td>
					</tr>
				
				</c:forEach>
				
				<tr class="table-primary">
					<td colspan="3">Sub Total</td>
					<td class="text-right">${cart.subTotal}</td>
				</tr>
				<tr>
					<td colspan="3">Tax</td>
					<td class="text-right">${cart.tax}</td>
				</tr>
				<tr class="table-primary">
					<td colspan="3">Total</td>
					<td class="text-right">${cart.total}</td>
				</tr>
			</tbody>
			
		</table>
		
		<c:url value="/home" var="cartAction"></c:url>
		<form action="${cartAction}" method="post">
			<div class="form-row">
				
				<div class="col">
					<input class="btn btn-block btn-primary" type="submit" name="action" value="Clear">
				</div>
			
				<div class="col">
					<input class="btn btn-block btn-danger" type="submit" name="action" value="Paid">
				</div>
			</div>
		
		</form>
	
	</div>
	
</div>