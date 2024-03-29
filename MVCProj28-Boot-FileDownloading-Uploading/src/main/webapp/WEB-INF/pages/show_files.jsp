<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${!empty filesList}">
		<table border="1" bgcolor="pink" align="center">
			<tr>
				<th>ID</th><th>Name</th><th>Qualification</th><th>Photo Location</th><th>Resume Location</th>
			</tr>
			<c:forEach var="js" items="${filesList}">
				<tr>
					<td>${js.id}</td>
					<td>${js.name}</td>
					<td>${js.qualification}</td>
					<td><a href="download?fname=${js.photoPath}">${js.photoPath}</a></td>
					<td><a href="download?fname=${js.resumePath}">${js.resumePath}</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red;text-align: center;">No Files Found</h1>
	</c:otherwise>
</c:choose>
