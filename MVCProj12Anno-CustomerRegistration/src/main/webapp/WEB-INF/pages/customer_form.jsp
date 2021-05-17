<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color: red;text-align: center;">CUSTOMER REGISTRATION FORM</h1>
<form:form action="customer" method="POST" modelAttribute="cust">
	<table border="1" align="center" bgcolor="cyan">
		<tr>
			<td>Customer Name :: </td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Customer Address :: </td>
			<td><form:input path="address"/></td>
		</tr>
		<tr>
			<td>Bill Amount :: </td>
			<td><form:input path="billAmount"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Register"></td>
		</tr>
	</table>
</form:form>
