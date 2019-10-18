<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Cours JSTL</title>
	<style>
		<%@include file="../css/styles.css" %>
	</style>
</head>
<script>
		function modifierTitreDuSubmit( valeur, event ){
			document.getElementById( 'bouton1' ).value = valeur + "!";
			if( document.getElementById('nombre').value > 23 ) {
				alert(document.getElementById('nombre').value + " est trop grand!" );
				document.getElementById('nombre').value = "";
				document.getElementById( 'bouton1' ).value = "!";
			}
			
			var not_numeric = ((event.which < 48 || event.which > 57) && event.which != 46);
		    if(not_numeric) {
		        event.returnValue = false;
		        return false;
		    }
			
		}
	</script>
<body>
<%@include file="header.jsp" %>

	
	
1 ${exemple} 3 4 5 6 7

<br />
<p>
<h3>Tag d'affichage</h3>
<c:out value="${exemple }" />
<h3>Définition d'une variable</h3>
<!-- set  -->
<c:set value="${exemple }" var="toto" />
<br />toto = <c:out value="${toto }" />
</p>
<h3>foreach</h3>

<c:set var="listeDEtudiants" value="${studentsList}" />

<c:forEach items="${ listeDEtudiants }" var="student">
	<c:out value="${ student.name }" /><br />
</c:forEach>


<c:if test="${not empty tata}" >
	Tata = <b><c:out value="${tata}" /></b>
</c:if>

<p>
<h3>Switch en JSTL (Variante de &lt;c:if&gt;&lt;/c:if&gt;)</h3>
<c:choose>
	<c:when test="${unNombre gt 0 }">
		Nombre positif
	</c:when>
	<c:when test="${unNombre lt 0 }">
		Nombre négatif
	</c:when>
	<c:otherwise>
		Nombre nul
	</c:otherwise>
</c:choose>

</p>


<p>
<c:choose>
	<c:when test="${laDate eq 'lun' }">
		Lundi
	</c:when>
	<c:when test="${laDate eq 'mar' }">
		Mardi
	</c:when>
	<c:when test="${laDate eq 'mer' }">
		Mercredi
	</c:when>
	<c:otherwise>
		Ce n'est pas une date !!!
	</c:otherwise>
</c:choose>

</p>


<p>
<h3>Déclaration de méthodes et de variables</h3>
<%!  
// ! obligatoire pour déclarer une méthode.
int minimum(int val1, int val2) { 
   if (val1 < val2) return val1;
   else return val2;
} 
%> 
<% int petit = minimum(5,3);%> <!-- ! facultatif -->
<p>Le plus petit de 5 et 3 est <%= petit %></p>


<%!
long factoriel(int x) {
	long P = 1L;
	for(int i=1 ; i<=x ; i++) {
		P *= i;
	}
	return P;
}
%>
<p>
	6! = <%=factoriel(5) %>
</p>



<hr />
<h2>
	Introduction à JavaScript, utilisation de GET dans un formulaire.
</h2>
<form method="get" action="">
	<input type="hidden" name="action_a_faire" value="calcul_factoriel" />
	<input id="nombre" onkeyup="modifierTitreDuSubmit(this.value, Event)" type="number" name="nombre" size="5" placeholder="De 1 à 23" />
	<input id="bouton1" type="submit" value="!" />
	
	
	
</form>

<p>
	<c:if test="${not empty fact}">
		${nombre}! = ${fact}
	</c:if>
</p>

</p>


<!-- LANGAGES EL : CALCULS :  -->








<%@include file="footer.jsp" %>
</body>
</html>