<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>QCM</title>
	<!-- http://localhost:8080/qcmProject/"  -->
	<base href="<%=request.getScheme() + "://" + 
					   request.getServerName() + ":" + 
					   request.getServerPort() + 
					   request.getContextPath() + "/"%>" 
		/>
</head>
<body>
	<%@include file="qcms.jsp"%>
	<%@include file="question.jsp"%>
</body>
</html>