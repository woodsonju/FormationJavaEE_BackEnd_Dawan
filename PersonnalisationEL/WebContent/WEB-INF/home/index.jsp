<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="../tld/ElFunctions.tld" prefix="math"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Tlds personnalisés</title>
</head>
<body>
	<p>
		Société
		<poe:HelloTag name="Dawan IT Consulting" />
	</p>

	<c:set var="x">18</c:set>
	<c:set var="y">12</c:set>

	<p>
		<c:out value="${x}" /> + <c:out value='${y}' /> = <c:out value="${math:sum(x,y)}" />
		<br />
		<c:out value="${x}" /> - <c:out value='${y}' /> = <c:out value="${math:substraction(x,y)}" />
		<br />
		<c:out value="${x}" /> * <c:out value='${y}' /> = <c:out value="${math:multiplication(x,y)}" />
		<br />
			<c:out value="${x}" /> / <c:out value='${y}' />
				<c:if test="${y eq 0}">
                     (<c:out value="Division par zéro." />)
             	</c:if>
				<c:if test="${y ne 0}">
                    = <c:out value="${math:division(x,y)}" />
				</c:if>
	</p>
	
	 <c:set var="prixHT" value="500" scope="page"></c:set>
 	Prix HT : <c:out value="${prixHT}" /> => Prix T.T.C. = ${math:prixTTC(prixHT)}
 	
</body>
</html>