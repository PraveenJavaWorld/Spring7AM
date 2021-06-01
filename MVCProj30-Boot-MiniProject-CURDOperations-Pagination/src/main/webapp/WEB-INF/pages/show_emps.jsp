<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
</head>
<h1 style="color: red;text-align: center;">WELCOME TO CRUD OPERATIONS WEB APPLICATION</h1>
<br>

<c:choose>
	<c:when test="${!empty list}">
		<table border="1" bgcolor="cyan" align="center">
			<tr>
				<th>ID</th><th>NAME</th><th>ADDRESS</th><th>SALARY</th><th>OPERATIONS</th>
			</tr>
			<c:forEach var="emp" items="${list}">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.address}</td>
					<td>${emp.salary}</td>
					<td>
						<a href="edit?id=${emp.id}"><span style="font-size: 2em; color: blue;"><i class="fas fa-user-edit"></i></span></a>&nbsp;&nbsp;&nbsp;
						<a href="delete?id=${emp.id}" onclick="return confirm('Do you want to delete?')"><span style="font-size: 2em; color: red;"><i class="fas fa-trash-alt"></i></span></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red;text-align: center;">No Records Found</h1>
	</c:otherwise>
</c:choose>
<h2 style="color: green;text-align: center;">${msg}</h2>
<h2 style="color: green;text-align: center;">${editMsg}</h2>
<h2 style="color: red;text-align: center;">${deleteMsg}</h2>
<h2 style="color: blue;text-align: center;">Add Employee<a href="empForm"><span style="font-size: 2em; color: blue;"><i class="fas fa-user-plus"></i></span></a></h2>
