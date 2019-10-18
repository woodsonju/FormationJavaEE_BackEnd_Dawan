<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>

	<h2>Recherche d'un étudiant</h2>
	<form method="post" action="">
		Saisir le nom d'un étudiant : <input type="text" name="name" /> <input
			type="hidden" name="action" value="find" /> <br /> 
			<button type="submit" class="btn btn-primary">Chercher</button>
	</form>
	<br />
	<br />
	<div class="panel panel-primary container col-md-6 col-xs-12 col-sm-6">
		<table class="table table-striped">
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Faculty</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${studentsList}" var="s">
				<tr>
					<td>${s.name}</td>
					<td>${s.age}</td>
					<td>${s.faculty}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div
		class="container col-md-6 col-xs-12 col-sm-6 col-md-offset-1 spacer">
		<div class="panel panel-primary">
			<div class="panel-heading">Saisie un etudiant</div>
			<div class="panel-body">
				<form action="" method="post">
					<input type="hidden" name="action" value="add">

					<!-- Quand je valide mon formulaire j'appel l'action saveProduit.do -->
					<div class="form-group">
						<label class="control-label">Nom : </label> <input type="text"
							name=name class="form-control" value="${name}" required /> <span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Age : </label> <input type="text"
							name=age class="form-control" value="${age}" /> <span></span>
					</div>
					<div class="form-group">
						<label class="control-label">faculty: </label> <input type="text"
							name=faculty class="form-control" value="${faculty}" /> <span></span>
					</div>
					<div>
						<input type="hidden" name="id" value="{modificationId}" />
						<c:choose>
							<c:when test="${empty modificationId}">
								<input type="hidden" name="action" value="add">
								<button type="submit" class="btn btn-success">Ajouter</button>
							</c:when>
							<c:otherwise>
								<input type="hidden" name="action" value="update" />
								<td><input type="submit" class="btn btn-primary"
									value="Modifier" /></td>
							</c:otherwise>
						</c:choose>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container col-md-8 col-xs-12 col-sm-8 col-md-offset-1">
		<table class="table table-striped">

			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Faculty</th>
				<th>Actions</th>
			</tr>
			<!-- Dans le modèle on recupère la liste des produits 
						et chaque itération on met la valeur d'un produit dans p-->
			<c:forEach items="${students}" var="s">
				<tr>
					<td>${s.name}</td>
					<td>${s.age}</td>
					<td>${s.faculty}</td>
					<td>
						<!--  Bouton modifier -->
						<form method="post" action="">
							<input type= "hidden" name="action" value="modify">
							<input type="hidden" name="id" value="${s.id}">
							<input type="submit" value="Modifier" />
						</form>
						
						<!-- Bouton supprimer -->
						<form  method="post" action="">
							<input type= "hidden" name="action" value="delete">
							<input type="hidden" name="id" value="${s.id}">
							
 							<input type="button" id="btn" value="Supprimer" onclick="modifierBouton()"/>
 							
							<script>
								function modifierBouton() {
									var v = confirm("vous voulez suprimer?");
									if (v == true) {
										document.getElementById("btn").type = "submit";

									} else {
										alert("On va pas supprimer");
									}
								}
							</script>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	   <br />
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