<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POS</title>
	
<c:import url="/common/resources.jsp"></c:import>

</head>
<body>

	<c:import url="/common/menu.jsp"></c:import>
	
	<div class="container-fluid">
		
		<div class="row">
			
			<div class="col-8">
				<c:import url="/common/product-search.jsp"></c:import>
			</div>
			
			<div class="col-4">
				<c:import url="/common/sale-details.jsp"></c:import>
			</div>
		
		</div>
	
	</div>

	
</body>
</html>