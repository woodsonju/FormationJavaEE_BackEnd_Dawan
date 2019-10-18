<%--
  Created by IntelliJ IDEA.
  User: admin
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<head>
    <title>Connexion</title>
    <style>
        span {
            font-size:9pt;
            color: #ff4500;
        }
    </style>


<!--  BOOTSTRAP -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body style="overflow-x: hidden;padding:20px" >
        <h2>Connexion à votre compte sur Dawan</h2>
        <table border="0" cellspacing="4" cellpadding="4" style="width:40%">
        <form method="post" action="user" action="?action=addUser" accept-charset="utf-8" charset="utf-8">
            <input type="hidden" name="action" value="login"/>
            <input type="hidden" name="idProduct" value="${idProduct}"/>
            <input type="hidden" name="referer" value="${transmis}"/>
            <tr>
            	<td>
            		E-mail
            	<td>
                	<input type="hidden" name="action" value="addUser"/>
                	<input value="<c:out value='${email}' />"  id="email" type="email" name="email" placeholder="Votre adresse e-mail" class="form-control">
                </td>
                <br /><span><c:out value="${messageEmail}" /></span>
            </tr>

			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>

            <tr>
            	<td>
            		Mot de passe
            	</td>
            	<td>
                	<input value="<c:out value='${password}' />"  id="password" type="password" name="password" placeholder="Mot de passe" style="background:#ffffff" class="form-control">
                	<br /><span><c:out value="${messagePassword}" /></span>
                </td>
            </tr>

			<tr>
				<td colspan="2"><hr /></td>
			</tr>
            
            <tr>
            	<td>
            	</td>
            	<td>
            		<button id="submit" type="submit"  style="text-align: center" class="btn btn-info form-control">&nbsp; Se connecter à Dawan</button>
                	<br /><input type="checkbox" checked>
            		&nbsp;&nbsp;&nbsp;&nbsp;
                	<label for="exampleCheck1">Rester connecté</label>
            	</td>
            </tr>


        </form>
        </table>
    </div>
    <div class="col-sm-1 col-xs-1 col-lg-4 col-md-4">

    </div>
</div>
</body>
</html>
<script>
    $("html, body").animate({ scrollTop: $('#title1').offset().top }, 1000);
</script>
