<%@page import="java.util.List"%>
<%@page import="fr.dawan.firstServlet.beans.Student"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<title>Liste d'étudiants</title>
<html>
<head>
<meta charset="utf-8">
<title>POE</title>
</head>
<body>
<b><u>Liste des &eacute;tudiants enregistr&eacute;s dans la base de données : </u></b>
<br /><br />
<%
// en jaune  : pas de SuppressWarning. C'est normal.
List<Student> list = (List<Student>) request.getAttribute("studentsList");
for(Student student: list) { %>
	<%=student.getName()%>;
	<%=student.getAge()%>;
    <%=student.getFaculty()%>;
    <br />
<%
}
%>


</body>
</html>
