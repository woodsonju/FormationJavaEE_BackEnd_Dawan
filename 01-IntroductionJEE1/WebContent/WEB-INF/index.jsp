<%@page import="com.wj.bean.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	Bonjour <%=request.getAttribute("myName") %>
	
	<p>! -- SAUTE UNE LIGNE ET CREE UN NOUVEAU PARAGRAPHE -- 
	<%
		List<Student> list = (List<Student>) request.getAttribute("students");
		for(Student student : list) {
	%>
			<%= student.getName()%>
			<%= student.getAge()%>
			<%= student.getFaculty()%>
			<br /> <br />
			
		<%}%>
	</p>
</body>
</html>