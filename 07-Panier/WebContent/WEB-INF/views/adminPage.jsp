<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="utf-8" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<!-- ****** NECESSAIRES POUR DATATABLES *******//-->
<link rel="stylesheet" type="text/css" href="bootstrap/dist/css/bootstrap.css" />
<script type="text/javascript" src="media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="media/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" href="styles/datatable.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css" />
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" />
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.2.1/css/select.dataTables.min.css" />
<link rel="stylesheet" type="text/css" href="https://editor.datatables.net/extensions/Editor/css/editor.dataTables.min.css" />
<!-- ****** NECESSAIRES POUR DATATABLES *******//-->

<style>
	td {
		padding: 5px;
	}
</style>

<div class="container-fluid">
    <div class="fh5co-about  animate-box">
    <table cellspacing="3" cellpadding="3" id="userList" border='1' class="pretty" width="100%">
        <thead>
        <tr>
            <td width="300"><b>Nom</b></td>
            <td><b>Email</b></td>
            <td><b>Rôle</b></td>
            <td width="200"><b>Inscription</b></td>
            <td colspan="2"><b>Actions</b></td>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <form method="post" action="/admin" class="form-group-lg">

                        <td>
                            <c:out value="${user.foreName}" />
                        </td>
                        <td>
                            <c:out value="${user.email}" />
                        </td>
                        <td style="color:#000000">
                            <input type="hidden" name="id" value="${user.id}" />
                            <select name="role" class="form-control">
                                <c:forEach items="${rolesList}" var="role">
                                    <option <c:if test="${role.key == user.role}"> selected </c:if> value="<c:out value="${role.key}"  />"><c:out value="${role.value}" /></option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <fmt:setLocale value="fr_FR" />
                            <fmt:formatDate value="${date}" pattern="E dd MMMM yyyy"/>
                        </td>
                        <td width="100">
                                <input type="hidden" name="action" value="modification" />
                                <input type="hidden" name="value" value="modifyUser" />
                                <input type="hidden" value="${user.id}" name="id"/>
                                <button type="submit" class="btn btn-warning" title="Modifier les privilèges de ${user.foreName}" >
                                	Modifier
                                </button>
                            </form>
                        <td width="100">
                            <a class="btn btn-danger" title="Supprimer ${user.foreName}"  id="${user.id}"  onclick='confirmer("<c:out value='${user.id}' />", "<c:out value='${user.foreName}' />", "date d`inscription : <c:out value='${user.date}' />")'>
                            	Supprimer
                            </a>
                                <script>
                                    function confirmer(id, forName, email){
                                        var choice = confirm( "Vous êtes sur le point de supprimer "+ forName + " (id " + id+ "-" + email + ") de la base de données ???\r\n\r\nCette action est irréversible !");
                                        if(choice) {
                                            $( '#' + id ).attr('href', "?action1=deleteUser&id=" + id);
                                        }
                                    }
                                </script>
                        </td>


                </tr>
            </c:forEach>
        </tbody>
    </table>
        <script>
            <!--
            $( document ).ready(function() {
                $('#userList').dataTable( {
                    "sPaginationType": "full_numbers"
                } );
            });
            //-->
        </script>
</div>
</div>
<br />
</section>

