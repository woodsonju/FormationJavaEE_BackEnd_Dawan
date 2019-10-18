<%@page import="com.wj.book.beans.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livre</title>
</head>
<body>
		<p>! -- SAUTE UNE LIGNE ET CREE UN NOUVEAU PARAGRAPHE -- <br /> <br />
	<%
		List<Book> list = (List<Book>) request.getAttribute("books");
		for(Book books : list) { 	
	%>
			<%= books.getTitle()%> 
			<%= books.getAuteur()%> 
			<%= books.getYear()%>
			<br /> <br />
			
		<%}%>
	</p>
</body>
</html>