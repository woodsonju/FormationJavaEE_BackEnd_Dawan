<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    

<!--  Inclusion de bibliothèques de taglibs EL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    
<!DOCTYPE html>
<html>
<head>

<!-- Encodage de caractères de la page -->
<meta charset="utf-8">

<!--  Texte affiché sur la barre de titres du navigateur -->
<title>Les langages EL</title>

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