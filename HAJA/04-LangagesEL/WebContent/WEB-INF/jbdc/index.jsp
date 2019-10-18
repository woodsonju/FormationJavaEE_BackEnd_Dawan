<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql" %>

<!-- Définir la base de données -->
<sql:setDataSource 
	driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://localhost:3306/university" 
	user="root" 
	password=""/>

<!-- Je crée une variable pour récupérer les enregistrements de la table student de la base university -->
<sql:query var="rs">  
   SELECT * from `student`;  
</sql:query>

<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td class="header">Nom</td>
		<td class="header">&Acirc;ge</td>
		<td class="header">Facult&eacute;</td>
	</tr>
	<c:forEach var="student" items="${rs.rows}">
		<tr>
			<td> 
				<c:out value="${student.name}" />
			</td>
			<td>  
				<c:out value="${student.age}" />
			</td>
			<td>  
				<c:out value="${student.faculty}" />
			</td>
		</tr>
	</c:forEach>  
</table>

