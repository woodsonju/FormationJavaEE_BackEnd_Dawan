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
	<h2>Authentification</h2>
	<form method="post" action="users">
		<label for="email">Email:</label>
		<input type = "text" name="email" id="email" />
		<br />
		<label for="pwd">Password:</label>
		<input type = "password" name="pwd" id="pwd" />
		<br />
		<input type = "submit" value="Se connecter" />
	</form> 
	<p>${msg}</p>

</body>
</html>