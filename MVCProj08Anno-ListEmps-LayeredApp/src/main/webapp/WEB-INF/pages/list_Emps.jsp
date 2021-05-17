<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>

<h1 style="color: red;text-align: center;">WELCOME TO LAYERED APPLICATION</h1>
<h1 style="color: red;text-align: center;">EMPLOYEE DETAILS</h1>

<c:choose>
	<c:when test="${!empty listDTO}">
		<table class="table table-bordered">
			<tr>
				<th>Serial No</th><th>ID</th><th>Name</th><th>Designation</th><th>Salary</th>
			</tr>
			<c:forEach var="dto" items="${listDTO}">
				<tr>
					<td>${dto.sno}</td>
					<td>${dto.empno}</td>
					<td>${dto.ename}</td>
					<td>${dto.job}</td>
					<td>${dto.sal}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red;text-align: center;">No Records Found</h1>
	</c:otherwise>
</c:choose>
<br>
<br>
<h2 style="color: green;text-align: center;"><a href="welcome">Home</a></h2>
