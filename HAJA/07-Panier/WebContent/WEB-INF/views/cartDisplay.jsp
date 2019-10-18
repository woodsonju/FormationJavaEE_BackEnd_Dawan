
<%@page import="fr.dawan.cart.bean.Library"%>
<%@ page import="java.util.HashMap" %>

<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %><%--
  Created by IntelliJ IDEA.
  User: admin
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
	<title>Votre panier</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<html>
<head>
    <style>
		td {
			text-align: center;
		}    
    
    	.black {
    		color:#000;
    	}
    
        /* Firefox */
        input[type=number] {
            -moz-appearance: textfield;
        }

        /* Chrome */
        input::-webkit-inner-spin-button,
        input::-webkit-outer-spin-button {
            -webkit-appearance: none;
            margin:0;
        }

        /* Opéra*/
        input::-o-inner-spin-button,
        input::-o-outer-spin-button {
            -o-appearance: none;
            margin:0
        }
        .myP {
            text-align:left;
            left:0;
        }
        th {
            background:#000;
    		color: #fff;
    		font-weight: bold;
    		text-align: center
        }
    </style>
</head>
<body>

<%
    HashMap<Library, Integer> cartContent = (HashMap) request.getSession().getAttribute("cart");
%>


<%
String contextPath = request.getContextPath();
%>
<c:set value="<%=contextPath %>" var="actualPage" /> 




				
<c:set var="map" value="<%=cartContent %>" />
<div class="fh5co-about col-sm-12 col-lg-12 col-md-12 col-xs-12 animate-box" style="margin-top:0">
    <h2>Votre panier</h2>
    <table border="1" style="margin-top:20px"  class="table table-dark">
        <tr>

            <th scope="col">Titre</th>
            <th scope="col">Auteur</th>
            <th scope="col">Image</th>
            <th scope="col" style="text-align: center">Prix</th>
            <th scope="col">Quantité</th>
            <th scope="col" colspan="2" style="text-align:center">Actions</th>
        </tr>
        <tbody>

        <c:forEach var="lister" items="${sessionScope.cart}">
            <tr>
                <form method="get" action="<c:out value='${actualPage}' />/cart">
                    <td class="black">
                        <c:out value = "${lister.key.titre}"/>
                    </td>
                    <td class="black">
                        <c:out value = "${lister.key.auteur}"/>
                    </td>


                    <td style="text-align: center">
                        <img height="40" <c:if test="${lister.key.description != ''}"> src="images/descriptions/id_<c:out value="${lister.key.id}"/>_<c:out value="${lister.key.description}"/>"</c:if> />
                    </td>


                    <td style="text-align: center;" class="black">
                        <c:out value = "${lister.key.prix}"></c:out>
                    </td>

                    <td style="text-align: center">
                        <input type="hidden" name="update" value="modify" />
                        <select class="form-control" id="quantity1" onchange="change(this.value)" style="margin-top:-8px;height:40px;vertical-align:center;font-size:11pt;color:#ffffff;width:100px;background:#353B41" name="quantity" type="checkbox">
                            <c:forEach var = "i" begin = "1" end = "100">
                                <option style="color:#aaaaaa" value="<c:out value = "${i}"/>" <c:if test="${i eq lister.value}"> selected="selected " </c:if> ><c:out value = "${i}"/></option>
                            </c:forEach>
                        </select>
                    </td>

                    <script>
                        $(function () {
                            $("#prix1").keydown(function () {
                                if (!$(this).val() || (parseInt($(this).val()) <= 5001 && parseInt($(this).val()) >= 0))
                                    $(this).data("old", $(this).val());
                            });
                            $("#prix1").keyup(function () {
                                if (!$(this).val() || (parseInt($(this).val()) <= 5001 && parseInt($(this).val()) >= 0));
                                else {
                                    $(this).val($(this).data("old"));
                                    alert("Prix maximal : 5000 &eacute;ro" )
                                }
                            });
                        });
                    </script>

                    <td style="text-align:center">
                        <input type="hidden" value="${lister.key.id}" name="id" id="id"/>
                        <input type="hidden" value="${page}" name="page" />
                        <!-- btn-xs -->
                        <button type="submit" class="btn btn-warning" title="Modifier ${lister.key.titre}" >
							Modifier
						</button>
                </form>
                    </td>


				
				


                <form method="get" action="<c:out value='${actualPage}' />/cart">
                    <input id="i1" type="hidden" name="id"  value="${lister.key.id}"  />
                    <input id="i2" type="hidden" name="quantity" value="${lister.value}" />
                    <input type="hidden" name="update" value="delete" />

                    <script>
                        function change(value){
                            document.getElementById('i2').value = value;
                        }
                    </script>


                <td style="text-align:center"><!-- btn-xs -->
                    <button title="<c:out value='${actualPage}' />/cart" type="button" class="btn btn-danger" title="Supprimer ${lister.key.titre}" id="${lister.key.id}"  onclick='confirmer("<c:out value='${lister.key.id}' />", "<c:out value='${lister.key.titre}' />")'>
                    	Supprimer
                    </button>
                </td>

                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

    <script>
        function confirmer(id, titre){
            var choice = confirm( "Voulez-vous supprimer l'ouvrage "+ titre + " (id " + id+ ")");
            if(choice) {
                document.getElementById("id").value=id;
                $( '#' + id ).attr('type', 'submit');
            }
        }
    </script>
<div>
    <div class="hidden-xs hidden-sm col-lg-6 col-md-6">
        &nbsp;
    </div>
    <div class="col-xs-12 col-sm-12 col-lg-6 col-md-6 text-right animate-box" style="font-size: 11pt">
        <p style="border-bottom:2px solid #000000;font-weight: bold"  class="lead">TOTAL</p>
        <p>
            <div class="col-xs-6 col-sm-6 col-lg-6 col-md-6" style="font-weight:bold;">Sous-total H.T.</div>
        <div class="col-xs-6 col-sm-6 col-lg-6 col-md-6" style="text-align:right;color:#f00"><span style="font-weight: bold;color:#ff4500"><%= NumberFormat.getInstance(Locale.FRENCH).format((double)request.getSession().getAttribute("amount") * 1.0) %></span> &euro;</div>
        </p>
        <p>
        <div class="col-xs-6 col-sm-6 col-lg-6 col-md-6" style="font-weight:bold;">TVA (20%)</div>
        <div class="col-xs-6 col-sm-6 col-lg-6 col-md-6" style="text-align:right;color:#f00"><span style="font-weight: bold;color:#ff4500"><%= NumberFormat.getInstance(Locale.FRENCH).format((double)request.getSession().getAttribute("amount") * 0.2) %></span> &euro;</div>
        </p>
        <p>
        <div class="col-xs-6 col-sm-6 col-lg-6 col-md-6" style="font-weight:bold;">Livraison</div>
        <div class="col-xs-6 col-sm-6 col-lg-6 col-md-6" style="text-align:right;color:#f00"><span style="font-weight: bold;color:#ff4500">0</span> &euro;</div>
        </p>
        <p>
        <div class="col-xs-6 col-sm-6 col-lg-6 col-md-6" style="font-weight:bold;border-top:2px solid #000000">TOTAL (TTC)</div>
        <div class="col-xs-6 col-sm-6 col-lg-6 col-md-6" style="text-align:right;color:#f00;border-top:2px solid #000000"><span id="ttc" style="font-weight: bold;color:#ff4500"><%= NumberFormat.getInstance(Locale.FRENCH).format((double)request.getSession().getAttribute("amount") * 1.2) %></span> &euro;</div>
        </p>

        <small>
            <small style="color:red">*</small> Livraison standard en point relais
        </small><br /><br />
        <p>
        
        
       
		<c:set value="<%=contextPath %>" var="actualPage" />
        
            <a href="<c:out value='${actualPage}' />" type="button" class="btn btn-info" onmouseover="this.style.border='1px solid #337ab7';this.style.background='#337ab7'" style="color:#eeeeee;background:#337ab7;border:none 0">CONTINUER ACHAT</a>
            <button onclick="validCart()" type="button" class="btn btn-info" onmouseover="this.style.border='1px solid #337ab7';this.style.background='#337ab7'" style="color:#eeeeee;background:#337ab7;border:none 0">VALIDER LE PANIER</button>
        </p>
    </div>

    <script>
        function validCart(){
            var validation = window.confirm("Voulez-vous vraiement valider cet achat de " + document.getElementById( 'ttc' ).innerHTML + "€ ?")
            if(validation) {
                alert("Félicifation !\r\nVotre commande de " + document.getElementById( 'ttc' ).innerHTML + "€ a été validée.\r\n\r\nVous allez recevoir un e-mail de confirmation d'ici quelques minutes")
                window.open("/cart?action=removeCartCookie", "_self");

            }
        }
    </script>

</div>

<div>&nbsp;</div>

</body>
</html>
