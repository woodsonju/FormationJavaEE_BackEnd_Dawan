<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!--  Chemin qui préfixera l'ensemble des URLs 
		  Ex : http://localhost:8080/projet2JEE/	
	-->
	<base href="<%=request.getScheme() + "://" + 
				   request.getServerName() + ":" + 
				   request.getServerPort() + 
				   request.getContextPath() + "/"%>" 
	/>
</head>
	
<body>
<!-- 	<h2>Authentification</h2>
	<form method="post" action="">
	</form> -->
	<h1>Formation Servlet/JSP</h1>
	<a href="users?action=login">Authentification</a>
	<br />
	<p>
		Nombre de visiteurs : ${applicationScope.nbVisiteurs }
	</p>
</body>
</html>