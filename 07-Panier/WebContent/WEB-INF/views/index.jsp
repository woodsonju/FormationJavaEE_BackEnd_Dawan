<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    

<!--  Inclusion de bibliothèques de taglibs EL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    
<!DOCTYPE html>
<html>
<head>


<link rel="icon" type="image/x-icon" href="images/favicon.ico" />


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<!-- Encodage de caractères de la page -->
<meta charset="utf-8">

<!--  Texte affiché sur la barre de titres du navigateur -->

<c:choose>
	<c:when test="${sessionScope.panier != '' &&  sessionScope.panier ne null }">
		<title>(<c:out value="${sessionScope.panier}" />) - Votre panier</title>
	</c:when>
	<c:otherwise>
		<title>&copy; Dawan 2019 - Exos Panier</title>
	</c:otherwise>
</c:choose>


<!-- Chargement des polices conçues par les équipes de Google -->
<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">


<!--  Le viewport désigne schématiquement la surface du navigateur (hauteur * largeur) -->
<meta name="viewport" content="width=device-width, user-scalable=no">

<!-- Chargement de la feuille de style (CSS) -->
<style>
	<%@include file="../css/styles.css" %>
</style>
</head>


<body>
	<%@include file="header.jsp" %>
	<%@include file="body.jsp" %>
	<%@include file="footer.jsp" %>
</body>

</html>