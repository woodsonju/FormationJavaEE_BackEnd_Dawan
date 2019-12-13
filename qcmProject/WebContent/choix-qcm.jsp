<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exo QCM</title>
<!--  chemin qui préfixera l'ensemble des URLs -->
<base
	href="<%=request.getScheme()+"://"
				+ request.getServerName() + ":"
				+ request.getServerPort() 
				+ request.getContextPath()
				+"/"%>" />
</head>
<body>
	<h1>Choix du QCM</h1>

	<form method="post" action="qcm">
		<label for="choix">Choisir le qcm</label> <select name="idQcmSel"
			id="choix">
			<option value="">-- choisir --</option>
			<c:forEach var="questionnaire" items="${listeQcms}">
				<option value="${questionnaire.idQcm}">${questionnaire.sujet}</option>
			</c:forEach>
		</select> <input type="hidden" name="action" value="demarrer" /> <input
			type="submit" value="Démarrer" />
	</form>
</body>
</html>



