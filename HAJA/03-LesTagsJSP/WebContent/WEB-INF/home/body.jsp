<%@page import="java.util.Date"%>
<%@page import="java.util.Enumeration"%>
<%@page import="fr.dawan.taglib.beans.Student"%>

<%@page import="java.util.Enumeration"%>


<div class="body">
<p>
---- BODY
&Eacute;tude des taglibs JSP.


<br /><br />
Notre projet se trouve dans : ${pageContext.request.contextPath}, 
<br /><br />
Le fichier de style se trouve dans :
"${pageContext.request.contextPath}/css/styles.css.
</p>

<p>
	<span class="big">
		Un grand texte!
	</span>
</p>

<u>UTILISATION DES BEANS</u>
<jsp:useBean id="studentBean" class="fr.dawan.taglib.beans.Student" scope="session">
	<jsp:setProperty name="studentBean" property="*" />
</jsp:useBean>

<p>
Nom initial =
<%=studentBean.getName()%>
<!--  Valeur par défaut défini dans le java bean -->
<%
	studentBean.setName( " Alix ");
%>
<br />Nom mis à jour =
<%=studentBean.getName()%>



<%
	Student myBean = null;
	Student newBean = (Student) session.getAttribute("studentBean");
	myBean = newBean;
%>



<u><h2>Les sessions</h2></u>

	<%
		if (session.getAttribute("name") != null) {
	%>
	<h5>
		Session 'name' :
		<%=session.getAttribute("name")%>
	<%
		}
	%>
	
	<%
		if (session.getAttribute("age") != null) {
	%>
		<br />Session 'age' :
		<%=session.getAttribute("age")%>
	<%
		}
	%>
	
	
	
	<%
		if (session.getAttribute("university") != null) {
	%>
	
		<br />Session 'university' :
		<%=session.getAttribute("university")%>
	<%
		}
	%>
	
		<br />ID de la session :
		<%=session.getId()%>
	
	</h5>

<br />



<u><h2>Les cookies</h2></u>

	<%
		if (request.getCookies() != null) {
			Cookie[] cookies = request.getCookies();
			for (int i = 0; i < cookies.length; i++) {
	%>
	Cookie name:
	<%=cookies[i].getName()%>
	<br> value:
	<%=cookies[i].getValue()%><br /> Old max age in seconds:
	<%=cookies[i].getMaxAge()%><br /><br />
	<%
		cookies[i].setMaxAge(5);
	%>
	New max age in seconds:
	<%=cookies[i].getMaxAge()%><br>

	<%
		}
		}
	%>
	<%!int count = 0;
	int dcount = 0;%>
	<%
		response.addCookie(new Cookie("cookie" + count++, "valeur" + dcount++));
		response.addCookie(new Cookie("Journee", "Soirée"));
		response.addCookie(new Cookie("Soiree", "Journée"));
	%>


	<br />
	<br />
	<u><b>Liste des cookies : </b></u>
	<br />
	<br />
	<%
		Cookie[] cookies1 = request.getCookies();

		for (int i = 0; i < cookies1.length; i++) {
			String name = cookies1[i].getName();
			String value = cookies1[i].getValue();
	%>
	<%=name%>
	:
	<%=value%>
	<br /><br />
	<%
		}
	%>
</p>




<p>
	<u><h2>Transfert de cookies JSP <=> Servlet</h2></u>
</p>


	<h3>
		<%
			Enumeration flds = request.getParameterNames();
			if (!flds.hasMoreElements()) { // Pas de champ (paramètre)
		%>
	</h3>
	<form method="post" action="">
		<%
			for (int i = 0; i < 10; i++) {
		%>
		Champ<%=i%>: <input type="text" size="20" name="field<%=i%>"
			value="value<%=i%>"><br>
		<%
			}
		%>
		<br /> 
		<INPUT TYPE="submit" name="submit"
			value="Ajouter dans les cookies">
	</form>
	<%
		} else {
			%>
			<h2>Extraction des paramètes passés et Récupération de valeurs</h2>
			<%
			while (flds.hasMoreElements()) {
				String field = (String) flds.nextElement();
				String value = request.getParameter(field);
	%>
	<li><%=field%> = <%=value%></li>
	<%
		}
		}
	%>
	
	<br /><h2>jsp:setProperty</h2>
	<jsp:setProperty name="studentBean" property="age" value="50" />
	<p>Nom mis à jour = <%= studentBean.getAge() %></p> <!--  50 -->
	
	
	
<p>Date du jour : 
	<%= new Date() %>
</p>


<% for (int i=0; i<10; i++) { %> 
<%= i %> <br>
<% }%>
	