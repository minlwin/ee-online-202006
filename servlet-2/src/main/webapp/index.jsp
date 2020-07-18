<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>

	<h1>Hello JSP</h1>
	
	<ul>
		<li>
			<a href="include">Include Servlet</a>
		</li>
		<li>
			<a href="forward">Forward Servlet</a>
		</li>
		<li>
			<a href="forward-jsp">Forward to JSP</a>
		</li>
	</ul>
	
	<hr />
	
	<h2>Post Informations</h2>
	
	<form method="post" action="forward-jsp">
		<table>
			<tr>
				<td>Name</td>
				<td>
					<input type="text" placeholder="Enter Name" name="name" />
				</td>
			</tr>
			<tr>
				<td>Subject</td>
				<td>
					<select name="subject" >
						<option value="Java SE">Java SE</option>
						<option value="Java EE">Java EE</option>
						<option value="Spring">Spring</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<label for="male">
						<input type="radio" name="gender" id="male" value="Male" />
						Male
					</label>
					<label for="female">
						<input type="radio" name="gender" id="female" value="Female" />
						Female
					</label>
				</td>
			</tr>
			<tr>
				<td>Interest</td>
				<td>
					<label for="desktop">
						<input type="checkbox" name="interest" id="desktop" value="Desktop" />
						Desktop
					</label>
					<label for="web">
						<input type="checkbox" name="interest" id="web" value="Web Application" />
						Web Application
					</label>
					<label for="mobile">
						<input type="checkbox" name="interest" id="mobile" value="Mobile" />
						Mobile
					</label>
					
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<button type="submit">Send</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>