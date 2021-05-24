<%@ page isELIgnored="true" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 

<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true"/></title>
	</head>
	<body>
		<table border="1" width="100%" height="100%">
			<tr height="30%">
				<td colspan="2"><tiles:insertAttribute name="header"/></td>
			</tr>
			<tr height="60%">
				<td width="30%"><tiles:insertAttribute name="menu"/></td>
				<td width="70%"><tiles:insertAttribute name="body"/></td>
			</tr>
			<tr height="10%">
				<td colspan="2"><tiles:insertAttribute name="footer"/></td>
			</tr>
		</table>
	</body>
</html>