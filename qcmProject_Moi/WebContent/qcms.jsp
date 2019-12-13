<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
    prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Choisir le QCM</h3>

	<table border="1">
		<tr>
			<th>Sujet</th>
		</tr>
		<c:forEach var="q" items="${qcmsList}">
			<tr>
				<td><a href="qcms?action=qcmsLists&id=${q.id}">${fn:toUpperCase(q.sujet)}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>