<%@page import="fr.dawan.el.beans.Student"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<br />
<!-- 
L'expression ${studentsList} remplace request.getAttribute('studientsList')
 -->
<c:forEach items="${ studentsList }" var="student">
	<c:out value="${ student.name }" /><br />
</c:forEach>
<br />
<c:if test="${not empty action and action ne '' and action eq 'jstl'}">
	JSTL
</c:if>
<br />