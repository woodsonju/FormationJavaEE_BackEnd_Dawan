<%@page import="java.util.Date"%>
<%@page import="java.util.Enumeration"%>
<div class="body">



&gt;&nbsp;<c:out value="${ action }" />
<br /><br />
<!-- Une variante de c:if... -->
<c:choose>
	<c:when test="${action == 'homePage'}">
		<c:import url="home.jsp" />
	</c:when>
	<c:when test="${action == 'jstl'}">
		<c:import url="../jstl/" />
	</c:when>
	<c:when test="${action == 'i18n'}">
		<c:import url="../i18n/" />
	</c:when>
	<c:when test="${action == 'jbdc'}">
		<c:import url="../jbdc/" />
	</c:when>
	<c:when test="${action == 'email'}">
		<c:import url="../mail/" />
	</c:when>	
	<c:otherwise>
		<c:import url="../error/error404.jsp" />
	</c:otherwise>
</c:choose>

<!--  MailController -->

<c:if test="${mailError != null}">
	<script>
		window.alert("Données manquantes. Je ne peux pas délivrer votre courriel !")
	</script>
</c:if>

<c:if test="${recipientError != null}">
	<script>
		window.alert("Adresse email du destinataire invalide !")
	</script>
</c:if>

<c:if test="${senderError != null}">
	<script>
		window.alert("Adresse email de l'expéditeur invalide !")
	</script>
</c:if>

</div>
