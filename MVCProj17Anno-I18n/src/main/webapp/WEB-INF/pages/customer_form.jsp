<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



<h1 style="color: red;text-align: center;"><spring:message code="customer.title"/></h1>

<form:form modelAttribute="cust" >
	<table border="1" align="center" bgcolor="cyan">
		<tr>
			<td><spring:message code="customer.name"/> :: </td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td><spring:message code="customer.addresss"/> :: </td>
			<td><form:input path="address"/></td>
		</tr>
		<tr>
			<td><spring:message code="customer.billAmount"/> :: </td>
			<td><form:input path="billAmount"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="<spring:message code="customer.submit"/>"></td>
		</tr>
	</table>
</form:form>
<br>
<br>
<a href="?lang=de_DE">German</a> &nbsp;&nbsp;
<a href="?lang=hi_IN">हिंदी</a> &nbsp;&nbsp;
<a href="?lang=te_IN">తెలుగు</a> &nbsp;&nbsp;
<a href="?lang=zh_CN">Chinese</a> &nbsp;&nbsp;
<br><br>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<b>Current Locale is :: ${pageContext.response.locale}</b>
<fmt:setLocale value="${pageContext.response.locale}"/>
<fmt:formatNumber var="fsalary" value="${salary}" type="currency"/>
<h1>Salary is :: ${fsalary}</h1>
<br>
<fmt:formatDate var="fdate" value="${sysDate}" type="both"/>
<h1>System Date is :: ${fdate}</h1>





