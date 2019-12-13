<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Exo QCM</title>
	<!--  chemin qui préfixera l'ensemble des URLs -->
	<base href="<%=request.getScheme()+"://"
				+ request.getServerName() + ":"
				+ request.getServerPort() 
				+ request.getContextPath()
				+"/"%>" />
</head>
<body>
	<h3>Qcm ${sessionScope.sujetQcm}</h3>
	
	<p>Q${sessionScope.numQst}) ${qst.enonce}</p>
	<form method="post" action="qcm">
		<c:choose>
			<c:when test="${qst.multiple}">
				<c:forEach var="rep" items="${lRep}">
					<input name="repSel" type="checkbox" value="${rep.idReponse}" />
					<span>${rep.texte}</span>
					<br />
				</c:forEach>	
			</c:when>
			<c:otherwise>
				<c:forEach var="rep" items="${lRep}">
					<input name="repSel" type="radio" value="${rep.idReponse}" />
					<span>${rep.texte}</span>
					<br />
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<input type="hidden" name="action" value="suivant" />
		<input type="submit" value="Suivant" /> 
	</form>
	
	
	
</body>
</html>


