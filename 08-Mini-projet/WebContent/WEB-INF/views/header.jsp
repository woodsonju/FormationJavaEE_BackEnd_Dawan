<!--  Inclusion de bibliothèques de taglibs EL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>

.encercle{
 	display:inline;
 	background:#ff0000;
 	font-size: 8pt;
 	color:#ffffff;
 	width:40px;
 	height:40px;
 	-webkit-border-radius:40px;
 	-moz-border-radius:40px;
 	-ms-border-radius : 40px;
 	-o-border-radius:40px;
 	border-radius : 40px;
 	padding:5px;
 }
</style>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>




<div width="100%" id="header_title">
	<img src="images/logo.png" />
	Exo-POE Toulouse<br />
</div>

<br /><div class="menus">
	<ul>
                        <c:choose>
                            <c:when test="${action =='addBook'}">
                                <!-- <li><a href="">Shopping</a></li> -->
                                <c:if test="${sessionScope.forname ne null}"><%--${sessionScope.role eq 3--%>
                                     <li class="active"><a>Products</a></li> 
                                </c:if>
                                <c:if test="${sessionScope.panier != null && sessionScope.panier != '0'}"><li><a href="cart?action=viewCart">Panier <sup><span class='encercle'>${sessionScope.panier}</span></sup></a> </li></c:if>
                                <li><a href="admin?action=users">Users</a></li>
                            </c:when>
                            <c:when test="${action =='cart'}">
                                <!-- <li><a href="">Shopping</a></li> -->
                                <c:if test="${sessionScope.forname ne null}"><%--${sessionScope.role eq 3--%>
                                     <li><a href="/07-Panier/?action=addBook">Products</a></li> 
                                </c:if>
                                <c:if test="${sessionScope.panier != null && sessionScope.panier != '0'}"><li class="active"><a class="active">Panier <sup><span class='encercle'>${sessionScope.panier}</span></sup></a> </li></c:if>
                                <li><a href="admin?action=users">Users</a></li>
                            </c:when>
                           

                            <c:when test="${action =='users'}">
                                <!--  <li><a href="">Shopping</a></li> -->
                                <c:if test="${sessionScope.forname ne null}"><%--${sessionScope.role eq 3--%>
                                     <li><a href="/07-Panier?action=addBook">Products</a></li> 
                                </c:if>
                                <c:if test="${sessionScope.panier != null && sessionScope.panier != '0'}"> <li><a href="cart?action=viewCart">Panier <sup><span class='encercle'>${sessionScope.panier}</span></sup></a></li></c:if>
                                <li class="active"><a>Users</a></li>
                            </c:when>


                            <c:otherwise>
                                <!-- <li class="active"><a>Shopping</a></li> -->
                                <c:if test="${sessionScope.forname ne null}"><%--${sessionScope.role eq 3--%>
                                     <li class="large"><a href="/07-Panier?action=addBook">Products</a></li> 
                                </c:if>
                                <c:if test="${sessionScope.panier != null && sessionScope.panier != '0'}"><li><a href="cart?action=viewCart">Panier <sup><span id='r' class='encercle'>${sessionScope.panier}</span></sup></a> </li></c:if>
                                <li><a href="admin?action=users">Users</a></li>
                            </c:otherwise>
                        </c:choose>


                    </ul>




                    <c:if test="${sessionScope.forname eq null}">
                        <ul class="pull-right right-menu" style="margin-top:-15px">
                            <li  style="display:inline"><a href="user?action=login">Login</a></li>
                            <li style="display:inline"><a href="user?action=signUp">Sign up</a></li>
                        </ul>

                    </c:if>
                    <c:if test="${sessionScope.forname ne null}">
                        <ul class="pull-right right-menu">
                            <li><a href="user?action=deconnect">Deconnection</a></li>
                        </ul>

                    </c:if>

</div>