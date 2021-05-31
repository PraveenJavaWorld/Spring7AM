<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color: red;text-align: center;">WELCOME TO CRUD OPERATIONS WEB APPLICATION</h1>
<br>
<h2 style="color: blue;text-align: center;">Add Below Details To Register Employee</h2>

<form:form action="addEmp" method="POST" modelAttribute="emp">
	<table border="1" bgcolor="pink" align="center">
		<tr>
			<td>Employee Name :: </td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Employee Address :: </td>
			<td><form:input path="address"/></td>
		</tr>
		<tr>
			<td>Employee Salary :: </td>
			<td><form:input path="salary"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Register"></td>
		</tr>
	</table>
</form:form>
