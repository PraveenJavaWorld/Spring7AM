<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color: red;text-align: center;">WELCOME TO WEB APPLICATION</h1>

<h2 style="color: green;text-align: center;">Enter the Student Details</h2>

<form:form action="save" method="POST" modelAttribute="stud">
	<table align="center" bgcolor = "cyan">
		<tr>
			<td>Student Number :: </td>
			<td><form:input path="sno"/></td>
		</tr>
		<tr>
			<td>Student Name :: </td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Student Address :: </td>
			<td><form:input path="address"/></td>
		</tr>
		<tr>
			<td>Student Average :: </td>
			<td><form:input path="average"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Save" bgcolor="green" color="white"></td>
		</tr>
	</table>
</form:form>