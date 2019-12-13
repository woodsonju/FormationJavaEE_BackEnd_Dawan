<%@page import="entities.Utilisateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
    prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formation Servlet/JSP</title>
<!--  chemin qui préfixera l'ensemble des URLs -->
<base
	href="<%=request.getScheme()+"://"
                                + request.getServerName() + ":"
                                + request.getServerPort() 
                                + request.getContextPath()
                                +"/"%>" />
</head>
<body>
	<p>Bienvenue ${sessionScope.userName}</p>
	<a href="users?action=logout"> Se déconnecter </a>

	<h1>Gestion des utilisateurs</h1>
	
	<h2>Ajout/Modifier</h2>
	<form action="users" method="post">
		<label for="text">Nom:</label>
		<input type = "text" name="nom" id="nom" value="${user.nom}"/>
		<br />
		<label for="email">Email:</label>
		<input type = "text" name="email" id="email" value="${user.email}"/>
		<br />
		<label for="pwd">Password:</label>
		<input type = "password" name="pwd" id="pwd" value="${user.pwd}"/>
		<br />
		<input type = "hidden" name="id" value="${user.id}"/>
		<br />
		<input type = "hidden" name="action" value="sauvegarder" /> <!-- C'est pour pouvoir l'utiliser dans le controller -->
		<input type = "submit" value="Sauvegarder" />
	</form>
	<p>${msg}</p>
	
	<table border="1">
		<tr>
			<th>Nom</th>
			<th>Email</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="u" items="${usersList}">
			<tr>
				<td>${fn:toUpperCase(u.nom)}</td>
				<td>${u.email}</td>
				<td><a href="users?action=modifier&id=${u.id}">Modifier</a></td>
				<td><a href="users?action=supprimer&id=${u.id}">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>

	<p>
		<c:if test="${page > 1}">
			<a href="users?page=${page-1}&max=${max}">Précédent</a>
		</c:if>

		<span> ${page} </span>

		<c:if test="${suivExist}">
			<a href="users?page=${page+1}&max=${max}">Suivant</a>
		</c:if>

	</p>



</body>
</html>



