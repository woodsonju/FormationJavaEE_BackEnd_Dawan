<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
</head>
<body>
	<h2>Authentification</h2>
	<form method="post" action="qcms">
		<label for="email"> Email : </label>
		<input type="text" name="email" id="email" />
		<br/>
		<label for="password"> Password : </label>
		<input type="password" name="password" id="password" />
		<br/>
		<input type = "hidden" name="action" value="seconnecter" /> <!-- C'est pour pouvoir l'utiliser dans le controller -->
		<input type = "submit" value="Se connecter" />
	</form>
</body>
</html>