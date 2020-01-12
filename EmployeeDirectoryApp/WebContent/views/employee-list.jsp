<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Title Here</title>
</head>
<link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
	<div class = "container">
		<p>${message}</p>
		<button class="btn btn-primary" onclick="window.location.href='views/employee-add.jsp'">Add Employee</button>
		<table border="1" class="table table-striped table-bordered">
		<tr class="thead-dark">
			<th>Name</th>
			<th>Department</th>
			<th>Date of birth</th>
			<th>Action</th>
		</tr>
		<c:forEach items = "${list}" var = "employee">
			<tr>
				<td>${employee.name}</td>
				<td>${employee.department}</td>
				<td>${employee.dob}</td>
				<td>
					<a href="${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${employee.id}">Edit</a>
					|
					<a href="${pageContext.request.contextPath}/EmployeeController?action=DELETE&id=${employee.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>