<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql" %>
<%@page import="java.util.Date"%>
<%@page import="java.util.Enumeration"%>


<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/bibliotheque" user="root" password=""/>
<sql:query var="resultat" sql="SELECT * FROM `livre` " />




<body style="padding:20px;overflow-x:hidden">

<span id="title1">&nbsp;</span>



<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<!-- Encodage de caractères de la page -->
<meta charset="utf-8">


<c:if test="${action eq ''}">
	<h3>
		Bienvenu <c:out value="${sessionScope.forname}" /> !
	</h3>
</c:if>
<c:if test="${action == 'addBook'}" >
    <c:import url="addBook.jsp" />
</c:if>

<c:if test="${action == 'viewProduct'}" >
    <c:import url="viewProduct.jsp" />
</c:if>
<c:if test="${action == 'signUp'}" >
    <c:import url="signUp.jsp" />
</c:if>
<c:if test="${action == 'login'}" >
    <c:import url="login.jsp" />
</c:if>
<c:if test="${action == 'cart'}" >
    <c:import url="cartDisplay.jsp" />
</c:if>
<c:if test="${action == 'users' && sessionScope.role == '3' }" >
    <c:import url="adminPage.jsp" />
</c:if>

<hr />
<c:forEach items="${completeList}" var="list">
	<c:if test="${list.star != true && sessionScope.role ne '3'}">
		<div classe="col-md-6 col-sm-6 col-xs-12" style="padding:20px">
			<div>
				<h3 style="border-bottom:1px solid #000">${list.titre}</h3>
				<h4>${list.auteur}</h4>
				<p style="color:#a10000;font-weight:bold;font-size:16pt;">${list.prix} &euro;</p>

				<c:if test="${!empty list.description or list.description != ''}">
					<img height="100" src="images/descriptions/id_<c:out value="${list.id}"/>_<c:out value="${list.description}"/>" />
				</c:if>
		
				<c:if test="${empty list.description or list.description == ''}">
					<p>
						<b>Description non disponible!</b>
					</p>
				</c:if>
				
				
				
				<!-- Récupération de la page actuelle -->
					<%
						String contextPath = request.getContextPath();
					%>
					<c:set value="<%=contextPath %>" var="actualPage" />
				<br /><br />
				<p>${list.synopsis}</p>
				<ul>
					<li>
						<c:choose>
							<c:when test="${sessionScope.forname != null}">
								<form action="<c:out value="${actualPage}" />/cart?action=add" method="post" stylee="border-bottom:2px solid #87cfea;">
							</c:when>
							<c:otherwise>
								<form action="<c:out value="${actualPage}" />/cart?action=connect" method="post" stylee="border-bottom:2px solid #87cfea;">
							</c:otherwise>
						</c:choose>
						<input type="hidden" name="user_id" value="${sessionScope.id}" />
						<input type="hidden" name="product_id" value="${list.id}" />
						Quantité : 
						<select id="quantity" id="quantity" style="height:40px;width:50px;" name="quantity">
							<c:forEach var = "i" begin = "1" end = "10">
								<option value="<c:out value = "${i}"/>" <c:if test="${i eq 1}"> selected="selected " </c:if> ><c:out value = "${i}"/></option>
							</c:forEach>
						</select>
						<br /><br />
						<button title="<c:out value="${actualPage}" />/carte?action=connect" type="submit" class="btn btn-secondary" title="Ajouter ${list.titre} dans votre panier">
							Ajouter <c:out value="${list.titre}" /> au panier	
						</button>
						<br /><br />
						</form>
                        </li>
					</ul>
				</div>
			</div>
		</c:if>
		<c:set var="count" value="${count + 1}" scope="page"/>
		
</c:forEach>
</div>

</body>