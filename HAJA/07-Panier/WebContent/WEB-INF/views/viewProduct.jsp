<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" href="css/account_create.css" rel="stylesheet">
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
<script src="https://unpkg.com/ionicons@4.4.4/dist/ionicons.js"></script>
<body style="margin: 0">
<form method="post" action="/" style="margin:0;padding:0">
    <div class="container" style=" position:relative;margin-left: auto;margin-right: auto;">
        <small style="text-decoration: underline;">Bibliothèque &gt; Livres &gt; ${library.domaine} &gt; ${library.auteur}</small>
        <br /><br />
        <div class="container-fluid">
            <div class="col-xs-10 col-sm-12 col-lg-10 col-md-10">
                <p style="font-ramily:raleway, helvetica; font-size:18pt;border-bottom: 1px solid #919191">
                    ${library.titre}
                </p>
            </div>



            <div class="col-xs-5 col-sm-5 col-lg-5 col-md-5"  style="text-align: center;">
                <td>
                    <img style="width:50%" class="zoom_01" <c:if test="${library.description != ''}"> src="/descriptions/id_<c:out value="${library.id}"/>_<c:out value="${library.description}"/>" data-zoom-image="/descriptions/id_<c:out value="${library.id}"/>_<c:out value="${library.description}"/>"</c:if> />
                    <p style="font-size:9pt;font-family:Montserrat">
                        Année de sortie : ${library.anneeSortie}
                        <br />Disponible <input type="checkbox"  <c:if test="${disponible ne false}"> checked </c:if>/>
                    </p>
                </td>
            </div>

            <div class="col-xs-5 col-sm-5 col-lg-5 col-md-5">
                <div style="background: #f1f1f1;;margin:auto !important;padding:15px;padding-top:0;padding-bottom:0">
                    <br />
                    <table width="100%" cellpadding="0" cellspacing="0" style="border-bottom:0">
                        <td style="width:50%">
                            <h1 style="font-family:Montserrat;font-weight: bold;font-size:38pt;">
                                <fmt:formatNumber value="15" type="currency" currencySymbol="&euro;"/>
                            </h1>
                            <p style="margin-top:-30px">
                                <small style="font-family:Roboto;font-size:8pt;background:#224477;color:#ffffff;font-weight:bold;padding:5px">Vendu par MoiMême</small>
                                <br />
                                <span style="font-family:Roboto;font-size:9pt">&Eacute;tat : <b style="font-family: inherit;font-size: inherit">Neuf</b>
                                    <br />Genre : ${library.domaine}
                                    <br />Auteur : ${library.auteur}
                                    <br />Langue : ${library.langue}
                                </span>
                                <hr style="color:#717171;background: #717171" clear />
                            </p>
                        </td>
                        <td style="text-align: right;vertical-align: top;padding-left:0">
                            <small style="font-family:'Source Sans Pro';font-size:10pt;background:#ff0000;color:#ffffff;font-weight:bold;padding:5px">BON PLAN</small>
                        </td>
                    </table>
                </div>

                <br />
                <div style="color:#515151;border:1px solid #dddddd;font-family:verdana;font-size:10pt;padding:15px;">
                    <p style="font-size:9pt;font-family:Montserrat">
                        <input type="hidden" name="id" value="${library.id}" />
                        <input type="hidden" name="action" value="star" />
                        <input type="submit" class="btn btn-info" value="MARQUE COMME PRODUIT STAR" />
                        <br />ISBN : ${library.isbn}
                        <br />${library.synopsis}
                    </p>
                </div>
            </div>

        </div>

    </div>
</form>
<br /><br />
</body>