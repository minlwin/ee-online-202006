<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Order List -->
<div class="fluid card">
	
	<div class="card-body">
		<h4 class="card-title"><i class="fa fa-shopping-cart"></i> Sale Details <span class="float-right">${cart.total}</span></h4>
		
		<table class="table table-md">
			<thead>
				<tr>
					<th>Product</th>
					<th>Price</th>
					<th>Qty</th>
					<th>Total</th>
				</tr>
			</thead>
			
			<tbody>
			
				<!-- Sale Details -->
				<c:forEach items="${cart.details}" var="item">
					
					<tr>
						<td>${item.product.name}</td>
						<td>${item.product.price}</td>
						<td>${item.quentity}</td>
						<td>${item.product.price * item.quentity}</td>
					</tr>
				
				</c:forEach>
				
				<tr class="table-primary">
					<td colspan="3">Sub Total</td>
					<td>${cart.subTotal}</td>
				</tr>
				<tr>
					<td colspan="3">Tax</td>
					<td>${cart.tax}</td>
				</tr>
				<tr class="table-primary">
					<td colspan="3">Total</td>
					<td>${cart.total}</td>
				</tr>
			</tbody>
			
		</table>
		
		<div class="form-row">
			
			<div class="col">
				<button class="btn btn-block btn-primary">Clear</button>
			</div>
		
			<div class="col">
				<button class="btn btn-block btn-danger">Paid</button>
			</div>
		</div>
	
	</div>
	
</div>