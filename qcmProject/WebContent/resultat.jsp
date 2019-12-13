<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Exo QCM</title>
	<!--  chemin qui préfixera l'ensemble des URLs -->
	<base href="<%=request.getScheme()+"://"
				+ request.getServerName() + ":"
				+ request.getServerPort() 
				+ request.getContextPath()
				+"/"%>" />
</head>
<body>
	<h3>Votre score = ${sessionScope.test.score}</h3>
</body>
</html>


