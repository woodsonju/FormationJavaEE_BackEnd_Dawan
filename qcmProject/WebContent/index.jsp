<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>QCM</title>
	<!-- http://localhost:8080/qcmProject/"  
		chemin qui préfixera l'ensemble des URLs
	-->
	<base href="<%=request.getScheme() + "://" + 
					   request.getServerName() + ":" + 
					   request.getServerPort() + 
					   request.getContextPath() + "/"%>" 
		/>
</head>
<body>
	<h1>Exo 2</h1>
	<a href="qcm?action=choix">Exo QCM</a>
</body>
</html>