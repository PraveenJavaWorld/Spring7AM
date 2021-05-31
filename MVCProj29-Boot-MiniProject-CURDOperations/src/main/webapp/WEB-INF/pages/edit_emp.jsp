<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color: red;text-align: center;">WELCOME TO CRUD OPERATIONS WEB APPLICATION</h1>
<br>
<h2 style="color: blue;text-align: center;">Mention Below Details To Edit Employee</h2>

<form:form action="editEmp" method="POST" modelAttribute="empEditform">
	<table border="1" bgcolor="yellow" align="center">
		<tr>
			<td>Employee ID :: </td>
			<td><form:input path="id" readonly="true"/></td>
		</tr>
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
			<td><input type="submit" value="Edit"></td>
		</tr>
	</table>
</form:form>
