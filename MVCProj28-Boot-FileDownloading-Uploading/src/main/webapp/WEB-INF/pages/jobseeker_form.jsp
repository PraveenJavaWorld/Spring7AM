<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color: red;text-align: center;">WELCOME TO JOB PORTAL PAGE</h1>
<br>
<h2 style="color: green;text-align: center;">Enter Your Details Below </h2>
<br>

<form:form method="POST" action="upload" modelAttribute="jsForm" enctype="multipart/form-data">
	<table bgcolor="cyan" align="center">
		<tr>
			<td>Name :: </td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Qualification :: </td>
			<td><form:input path="qualification"/></td>
		</tr>
		<tr>
			<td>Upload Photo :: </td>
			<td><input type="file" name="photo"></td>
		</tr>
		<tr>
			<td>Upload Resume :: </td>
			<td><input type="file" name="resume"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Register"></td>
		</tr>
	</table>
</form:form>
