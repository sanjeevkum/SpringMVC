<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<body>
	<div class="container">
		
		<form action="${pageContext.request.contextPath}/EmployeeController" method="POST">
			Enter Name: <input type="text" name="name" value="${employee.name}"  /><br /> 
			Enter Date of Birth: <input type="date" name="dob" value="${employee.dob}" /><br />
			Enter Department: <input type="text" name="department" value="${employee.department}" /><br />
			<input type = "hidden" name ="id" value = "${employee.id}">
		<button class="btn btn-primary" type="submit">Save Employee</button>
		</form>
	</div>
</body>
</html>