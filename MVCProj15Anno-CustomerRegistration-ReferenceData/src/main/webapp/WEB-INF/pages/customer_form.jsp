<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script language="JavaScript" src='<c:url value="/myresources/js/validate.js"></c:url>'></script>

<noscript>
	<h1 style="color: red; text-align: center;">Enable JavaScript</h1>
</noscript>

<style>
	span{
		color: blue;
	}
</style>

<h1 style="color: red;text-align: center;">CUSTOMER REGISTRATION FORM</h1>

<form:form action="customer" method="POST" modelAttribute="cust" onsubmit="return validate(this)">

<%-- <p style="color: red;text-align: center;"><form:errors path="*"/></p> --%>

	<table border="1" align="center" bgcolor="cyan">
		<tr>
			<td>Customer Name :: </td>
			<td><form:input path="name"/><span id="nameErr"></span><form:errors cssStyle="color:red" path="name"/></td>
		</tr>
		<tr>
			<td>Customer Address :: </td>
			<td><form:input path="address"/><span id="addressErr"></span><form:errors cssStyle="color:red" path="address"/></td>
		</tr>
		<tr>
			<td>Bill Amount :: </td>
			<td><form:input path="billAmount"/><span id="billErr"></span><form:errors cssStyle="color:red" path="billAmount"/></td>
		</tr>
		<tr>
			<td>Gender :: </td>
			<td><form:radiobuttons path="gender" items="${gendersList}"/></td>
		</tr>
		<tr>
			<td>Hobbies :: </td>
			<td><form:checkboxes items="${hobbiesList}" path="hobbies"/></td>
		</tr>
		<tr>
			<td>Country :: </td>
			<td><form:select path="country">
				<form:options items="${countriesList}"/>
			</form:select></td>
		</tr>
		<tr>
			<td>Languages Known :: </td>
			<td><form:select path="languages" multiple="multiple">
				<form:options items="${languagesList}"/>
			</form:select></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Register"></td>
		</tr>
	</table>
	<form:hidden path="vflag"/>
</form:form>
