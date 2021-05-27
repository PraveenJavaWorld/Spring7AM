<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color: red;text-align: center;">WELCOME TO THE LOGIN PAGE</h1>
<br>
<h2 style="color: green;text-align: center;">Enter Your Credentials Below </h2>
<br>

<form:form method="POST" action="login" modelAttribute="userForm">
	<table bgcolor="cyan" align="center">
		<tr>
			<td>Username :: </td>
			<td><form:input path="username"/></td>
		</tr>
		<tr>
			<td>Password :: </td>
			<td><form:password path="password"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"></td>
		</tr>
	</table>
</form:form>

<c:if test="${!empty msg}">
	<h1 style="color: green;text-align: center;">Result is :: ${msg}</h1>
</c:if>
