<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>


<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<title>Les formulaires</title>
<html>
<head>
<meta charset="utf-8">
<title>Balise HTML</title>
</head>
<body>



<form method="post" action="">
	<input size="40" type="text" name="un_texte" placeholder="Saisir un texte court" />
	&nbsp;<input type=submit value="Valider" />
</form>

<% if( request.getAttribute("texte") != null) { %>
<br />
<div style="background:#ffff00;color:#ff0000;padding:3px; font-family:verdana">
<%= request.getAttribute("texte") %>
<% } %>
</div>


<br />
<a href="?action=via_link&name=RABESIAKA">Via un lien hypertexte</a>

<br /><br />
<form method="get" action="">
	<input type="hidden" name="action" value="via_get" />
	<input name="name" placeholder="Votre nom" size="30" />
	<input type="submit" value="Via méthode GET" />
</form>

<p>
	<% if( request.getAttribute("my_name") != null) { %>
		<br />
		<div style="background:#f00;color:#fff;padding:3px; font-family:verdana">
			<%= request.getAttribute("my_name") %>
	<% } %>
</div>
</p>


</body>
</html>