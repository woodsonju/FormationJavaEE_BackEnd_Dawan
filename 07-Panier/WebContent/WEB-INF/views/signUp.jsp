<%--
  Created by IntelliJ IDEA.
  User: admin
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<head>
    <title>
    	&copy; Dawan - Inscription utilisateur
    </title>
    <style>
    	h2 {
    		padding-left:30px;
    	}
        span {
            font-size:9pt;
            color: #ff4500;
        }
        
        .no_border {
        	padding-left:30px;
        	margin:10px;
        }
    </style>
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
</head>
<body style="overflow-x: hidden;padding:20px">
<div>
<h2>Utilisateur Dawan</h2>
<table border="0" cellspacing="0" cellpadding="0">
	<form method="post" class="form-group-lg" action="?action=addUser" accept-charset="utf-8" charset="utf-8">
		<tr>
			<td class="no_border">Nom</td>
			<td class="no_border">
				<input type="hidden" name="action" value="addUser"/>
				<input class="form-control" border="0" size="60" value="<c:out value='${forename}' />"  type="text" placeholder="Login" name="forename" id="forename" >
				<br />
				<span><c:out value="${forenameMessage}" /></span>
			</td>
		</tr>
		
    	
    	<tr>
    		<td class="no_border">
    			Votre rôle
    		</td>
    		<td class="no_border">
                <select class="form-control" id="role" name="role"style="background:#ffffff"  type="checkbox">
                    <c:forEach items="${roles}" var="role">
                        <option class="form-control" size="5" value="<c:out value = "${role.key}"/>" <c:if test="${role.key eq requestRole}"> selected="selected " </c:if> >
                        	<c:out value = "${role.value}"/>
                        </option>
                    </c:forEach>
                </select>
            </td>
       </tr>

		<tr>
			<td colspan="2">
				&nbsp;
			</td>
		</tr>
      <tr>  
      	<td class="no_border">
        	Email
        </td>
        <td class="no_border">      
           <input value="<c:out value='${email}' />" size="40"  id="email" type="email" name="email" placeholder="Votre adresse e-mail" style="background:#ffffff" class="form-control">
           <br />
           <span><c:out value="${messageEmail}" /></span>
        </td>
	</tr>

            
    <tr>
    	<td class="no_border">
    		Mot de passe
    	</td>
    	<td class="no_border">
           <input value="<c:out value='${password}' />" size="30" id="password" type="password" name="password" placeholder="Mot de passe" style="background:#ffffff" class="form-control">
           <br />
           <span><c:out value="${messagePassword}" /></span>
        </td>
   </tr>    


   	<tr>
   		<td class="no_border">
   			Confirmation du mot de passe *
   		</td>
   		<td class="no_border">         
                <input value="<c:out value='${password}' />" type="tel" size="30" id="password1" type="password" name="password1" placeholder="Confirmation du mot de passe" style="background:#ffffff" class="form-control">
                <br /><span><c:out value="${messagePassword1}" /></span>
        </td>
   </tr>


   <tr>
   		<td class="no_border">
   			Numéro de téléphone
   		</td>  
   		<td class="no_border">
			<input type="tel" size="15" maxlength="10" value="<c:out value='${phoneNumber}' />"  id="phoneNumber" type="tel" name="password1" placeholder="Tél.- Facultatif" style="background:#ffffff" class="form-control">
        </td>
	</tr>

	<tr>
			<td colspan="2">
				&nbsp;
			</td>
		</tr>

	<tr>
		<td>
        </td>
		<td class="no_border">	
            <button id="submit" type="submit"  class="form-control btn btn-primary">S'inscrire à Dawan</button>
        </td>
        
    </tr>

        	</form>
        </table>
    
</div>
</body>
</html>
<script>
    $("html, body").animate({ scrollTop: $('#title1').offset().top }, 1000);
</script>
