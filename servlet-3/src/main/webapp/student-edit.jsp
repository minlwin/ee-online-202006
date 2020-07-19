<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />

<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h1 class="mt-4">Add New Student</h1>
		
		<div class="row">
			
			<div class="col-6">

				<form action="student-save" method="post">
				
					<!-- Name -->
					<div class="form-group">
						<label>Name</label>
						<input required="required" name="name" type="text" class="form-control" placeholder="Enter Student Name" />
					</div>
					
					<!-- Phone -->
					<div class="form-group">
						<label>Phone</label>
						<input required="required" name="phone" type="tel" class="form-control" placeholder="Enter Phone" />
					</div>
					
					<!-- Email -->
					<div class="form-group">
						<label>Email</label>
						<input required="required" name="email" type="email" class="form-control" placeholder="Enter Email" />
					</div>
					
					<!-- Address -->
					<div class="form-group">
						<label>Address</label>
						<input name="address" type="text" class="form-control" placeholder="Enter Address" />
					</div>
					
					<div class="form-group">
						<button type="reset" class="btn btn-primary">Clear</button>
						<button type="submit" class="btn btn-danger">Save</button>
					</div>
				
				</form>
			
			</div>
		
		</div>
	
	</div>
		
	
</body>
</html>