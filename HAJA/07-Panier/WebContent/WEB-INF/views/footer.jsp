<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<hr />
<p style="font-family: verdana; font-size: 11pt">
	&copy; Dawan 2019 - 
	<c:if test="${applicationScope.nbVisitors > 1}">
		Visiteurs en ligne = <b>${applicationScope.nbVisitors}</b>
	</c:if>
	<c:if test="${applicationScope.nbVisitors <= 1}">
		Visiteur en ligne = <b>${applicationScope.nbVisitors}</b>
	</c:if>
</p>
