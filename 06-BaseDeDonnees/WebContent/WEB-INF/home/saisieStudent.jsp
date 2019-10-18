<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div
		class="container col-md-10 col-xs-12 col-sm-12s col-md-offset-1 spacer">
		<div class="panel panel-primary">
			<div class="panel-heading">Saisie un etudiant</div>
			<div class="panel-body">
				<!-- Quand je valide mon formulaire j'appel l'action saveProduit.do -->
				<form action="saveStudent.fr" method="post">
					<div class="form-group">
						<label class="control-label">Nom : </label> <input
							type="text" name=name class="form-control"
							value="${student.name}" required /> <span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Age : </label> <input type="text"
							name=age class="form-control" value="${student.age}" /> <span></span>
					</div>
					<div class="form-group">
						<label class="control-label">faculty: </label> <input type="text"
							name=faculty class="form-control" value="${student.faculty}" />
						<span></span>
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>