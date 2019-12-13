<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
    prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste de Questions</title>
</head>
<body>
	<h3>Liste de Questions</h3>
	<form action="qcms" method="get">
		<label for="text">Enoncé:</label>
		<input type="text" name="enonce" id="enonce" value="${question.enonce}" />
		<br />
	</form>
</body>
</html>