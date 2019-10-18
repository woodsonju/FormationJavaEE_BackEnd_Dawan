<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<style>
	<%@include file="../../css/styles.css" %>
</style>
<script>
/**
 * Test if keypress isn' t alphabetic character but numeric or dot character
 */
 function preventAlphabeticsChars(event) {
	    const not_numeric = ((event.which < 48 || event.which > 57) && event.which !== 46);
	    if (not_numeric) {
	    	alert("que de caractères numériques !");
	      	event.returnValue = false;
	      	return false;
	    }
	  }
</script>


<title>Les bases de données</title>
</head>
<body>
	<h2>Recherche d'un étudiant</h2>
	<form method="post" action="">
		Saisir le nom d'un étudiant : <input type="text" name="name" /> <input
			type="hidden" name="action" value="find" /> <br /> <input
			type="submit" value="Chercher" />
	</form>
	<br /><br />
	<c:if test="${std ne null}">
		<c:set var="foundStudent" value="${std}" />
		<c:if test="${foundStudent.name ne 'Toto'}" >	
			Nom : <c:out value="${foundStudent.name}" />
			<br />
			&Acirc;ge : <c:out value="${foundStudent.age}" />
			<br />
			Universit&eacute; : <c:out value="${foundStudent.faculty}" />
		</c:if>
		<c:if test="${foundStudent.name eq 'Toto'}" >
			Non trouvé
		</c:if>
	</c:if>
	
	<br /><hr />
	<h2>Ajout d'un étudiant</h2>

	<form method="post" action="">
		<table>
			<tr>
				<td>Nom :</td>
				<td><input type="text" name="name" value="<c:out value='${name}'/>" size="30" /></td>
			</tr>
			<tr>
				<td>&Acirc;ge :</td>
				<td><input onkeypress="preventAlphabeticsChars(event)"
					type="number" name="age" size="5" id="age" value="<c:out value='${age}'/>" /></td>
			</tr>
			<tr>
				<td>Universit&eacute; :</td>
				<td><input type="text" name="faculty" size="25" value="<c:out value='${faculty}'/>" /></td>
			</tr>
			<tr>
				<input type="hidden" name="id" value="${modificationId}" />
				<c:choose>
					<c:when test="${empty name}">
						<input type="hidden" name="action" value="add" />
						<td colspan="2"><input type="submit" value="Ajouter" /></td>
					</c:when>
					<c:when test="${empty name ne null}">
						<input type="hidden" name="action" value="update" />
						<td colspan="2"><input class="btn btn-dark"  type="submit" value="Modifier"/></td>
					</c:when>
				</c:choose>
				
				
				
			</tr>
		</table>
	</form>
	
	<p class="error">
		<c:out value="${error}" />
	</p>
	
	<hr />
	<h2>
		Liste des étudiants
	</h2>
	
	<table border="1" cellspacing="0" cellpadding="0">
		<tr>
			<td>Nom</td>
			<td>&Acirc;ge</td>
			<td>Universit&eacute;</td>
			<td>Actions</td>
		</tr>
		<c:forEach items="${studentList}" var="student">
			<tr>
				<td><c:out value="${student.name}" /></td>
				<td><c:out value="${student.age}" /></td>
				<td><c:out value="${student.faculty}" /></td>
				<td>
					<form method="post" action="">
						<input type="hidden" name="action" value="modify" />
						<input type="hidden" name="id" value="<c:out value='${student.id}' />" />
						<input type="submit" value="Modifier" onclick="modifyAddTitle()" />
					</form>
					
					<form method="post" action="">
						<input type="hidden" name="action" value="delete" />
						<input type="hidden" name="id" value="<c:out value='${student.id}' />" />
						<input type="submit" value="Supprimer" />
					</form>
				</td>
			</tr>
		</c:forEach>
	
	</table>
	
	
	
	
	<div class="container">
        <c:if test="${page>1}">
            <a class="btn btn-info" href="?page=${page-1}&length=${length}">Précédent</a>
        </c:if>

        <button class="btn btn-dark" type="button">${page}</button>

        <c:if test="${suivExist}">
            <a class="btn btn-danger" href="?page=${page+1}&length=${length}">Suivant</a>
        </c:if>
     </div>
	


</body>
</html>