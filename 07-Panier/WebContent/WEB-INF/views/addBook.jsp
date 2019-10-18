<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" href="css/account_create.css" rel="stylesheet">
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
<script src="https://unpkg.com/ionicons@4.4.4/dist/ionicons.js"></script>


                <script>
                /**
                 * Test if keypress isn' t alphabetic character but numeric or dot character
                 */
                function isNumeric(event){
                    var not_numeric = ((event.which < 48 || event.which > 57) && event.which != 46);
                    if(not_numeric) {
                        event.returnValue = false;
                        return false;
                    }
                }
                </script>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<!-- Chargement de la feuille de style (CSS) -->
<style>
	<%@include file="../css/styles.css" %>
</style>



<style>
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
    td,th {
        color:#ffffff;
    }
</style>





<div class="container-fluid" style="margin:10px;background:#FFE4E1"><!-- background:#FFE4E1 !//-->
    <div class="fh5co-about col-lg-4 col-md-4 animate-box">
        <h2 style="margin:0;padding:0;line-height: 20pt;margin-top:15px">Formulaire d'ajout</h2>
        <small style="font-size:9pt">Entrer les informations d'un livre</small>

        <br /><br />
        <form method="post" class="form-group-lg" action="addBook" enctype="multipart/form-data" accept-charset="utf-8" charset="utf-8">
            <div class="form-group">
                <label for="titre">Titre</label>
                <input value="<c:out value='${titre}' />"  type="titre" placeholder="Titre du library" name="titre" id="titre" style="background:#ffffff" class="form-control">
                <input type="hidden" id="description" name="description" />
            </div>
            <p style="color:#ff4500"><c:out value="${msgTitre}" /></p>
            <div class="form-group">
                <label for="auteur">Auteur</label>
                <input value="<c:out value='${auteur}' />"  id="auteur" type="text" name="auteur" placeholder="Auteur du library" style="background:#ffffff" class="form-control">
            </div>

            <div class="form-group">
                <label for="prix">Prix</label>                
                <input onkeypress="isNumeric(event)" type="number" value="<c:out value='${prix}' />"  id="prix" type="number" step=".01" name="prix" placeholder="Prix (en &euro;)" style="background:#ffffff;width:150px" class="form-control">
            </div>
            <p style="color:#ff4500"><c:out value="${msgPrix}" /></p>

            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>

            <script>

                $(function () {
                    $("#prix").keydown(function () {
                        if (!$(this).val() || (parseInt($(this).val()) <= 5001 && parseInt($(this).val()) >= 0))
                            $(this).data("old", $(this).val());
                    });
                    $("#prix").keyup(function () {
                        if (!$(this).val() || (parseInt($(this).val()) <= 5001 && parseInt($(this).val()) >= 0));
                        else {
                            $(this).val($(this).data("old"));
                            alert("Prix maximal : 5000 &eacute;ro" )
                        }
                    });
                });
            </script>


            <p style="color:#ff4500"><c:out value="${msgAuteur}" /></p>
            <div class="form-group">
                <label for="annee">Année de sortie</label>

                <c:choose>
                    <c:when test="${empty annee}">
                        <select class="form-control" id="annee" style="background:#ffffff" name="annee" type="checkbox">
                            <c:forEach var = "i" begin = "1000" end = "2019">
                                <option value="<c:out value = "${i}"/>" <c:if test="${i eq 1985}"> selected="selected " </c:if> ><c:out value = "${i}"/></option>
                            </c:forEach>
                        </select>
                    </c:when>
                    <c:otherwise>
                        <select class="form-control" id="annee" style="background:#ffffff" name="annee" type="checkbox">
                            <c:forEach var = "i" begin = "1000" end = "2019">
                                <option value="<c:out value = "${i}"/>" <c:if test="${i eq annee}"> selected="selected " </c:if> ><c:out value = "${i}"/></option>
                            </c:forEach>
                        </select>
                    </c:otherwise>
                </c:choose>
            </div>
            
            
            <div class="form-group">
                <label for="langue">Langue</label>
                <select class="form-control" id="langue" name="langue"style="background:#ffffff"  type="checkbox">


                    <c:choose>
                        <c:when test="${empty langue}">
                            <c:forEach items="${requestLangue}" var="liste_langue">
                                <option value="<c:out value = "${liste_langue}"/>" <c:if test="${liste_langue eq 'Français'}"> selected="selected " </c:if> ><c:out value = "${liste_langue}"/></option>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${requestLangue}" var="liste_langue">
                                <option value="<c:out value = "${liste_langue}"/>" <c:if test="${liste_langue eq langue}"> selected="selected " </c:if> ><c:out value = "${liste_langue}"/></option>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>


                </select>


            </div>

            <div class="form-group">
                <label for="isbn">ISBN</label>
                <input value="${isbn}" id="isbn" type="text" style="background:#ffffff" name="isbn" placeholder="{978-1-2345-6789-7|2-8765-4301-X}" class="form-control">
            </div>



            <c:choose>
            <c:when test="${empty request_dateAchat}">
                <div class="form-group">
                    <label>Date d'achat</label>
                    <input style="background:#ffffff"  value="${now}" type="date" name="date_achat" class="form-control">
                </div>
            </c:when>
                <c:otherwise>
                    <div class="form-group">
                        <label>Date d'achat</label>
                        <input style="background:#ffffff"  value="${request_dateAchat}" type="date" name="date_achat" class="form-control">
                    </div>
                </c:otherwise>
            </c:choose>

            <div class="form-group">
                <label for="button">Description</label><br />
                <input id="filename" accept="image/png, image/jpeg" onchange="readURL(this)" style="background:#ffffff;display:none"  type="file" name="file"  class="form-control" />
                <input type="hidden" name="MAX_FILE_SIZE" value="12345" />
                <button id="button" type="button"  onclick="document.getElementById('filename').click()"  class="btn btn-primary">Ajouter une photo</button>
            </div>



            <div id="conteneur_image" style="background:#FFE4E1;width:100%">
                <img src="<c:out value='${description}' />" style='max-width:100%' id='blah' <c:if test="${description eq ''}"> style='display:none' </c:if> />
                <c:out value="description" />
            </div>




            <div id="taille" style="display:none">
                Taille maximale : 64Mo
            </div>
            <div id="depassement_capacite" style="font-weight:bold;font-size:13pt;color:#dd0000;display:none"></div>
            <br id="tailleBr" style="display:none" />
            <br id="tailleBr1" style="display:none" />



            <div class="form-group">
                <label for="synopsis">Synopsis</label>
                <textarea  style="background:#ffffff" name="synopsis" id="synopsis" placeholder="Récit très bref qui constitue un schéma de scénario."  alt="Vous pouvez ajouter des liens (adresses Internet) dans votre texte, par exemple : https://www.google.com." title="Vous pouvez ajouter des liens (adresses Internet) dans votre texte, par exemple : https://www.google.com." class="form-control" id="le_texte" rows="7"><c:out value = "${synopsis}" /></textarea>
            </div>




            <div class="form-group switch1 demo1 col-xs-12 col-sm-12 col-lg-12 col-md-12" style="margin-top:5px;margin-bottom:0;margin-left:-15px">
                <div class="onoffswitch ">
                    
                    <input type="checkbox" class="form-check-input" name="disponibilite" <c:if test="${msgDisponible != 'Library indisponible !'}"> checked </c:if>>
    				<label class="form-check-label" for="exampleCheck1">Disponibilité</label>
    				
                </div>
            </div>

			<br /><br />
            <p style="color:#ff4500"><c:out value="${msgDisponible}" /></p>


            <div class="form-group">
                <label for="domaine">Genre</label>
                <select class="form-control" id="domaine" name="genre"style="background:#ffffff"  type="checkbox">
                    <c:choose>
                        <c:when test="${empty request_genre}">
                            <c:forEach items="${genres}" var="domaine">
                                <option value="<c:out value = "${domaine}"/>" <c:if test="${domaine eq 'Policier'}"> selected="selected " </c:if> ><c:out value = "${domaine}"/></option>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${genres}" var="domaine">
                                <option value="<c:out value = "${domaine}"/>" <c:if test="${domaine eq request_genre}"> selected="selected " </c:if> ><c:out value = "${domaine}"/></option>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>


            <div class="form-group">
                <label for="submit">Image</label><br />
                <button id="submit" type="submit"  class="btn btn-primary"><span style="font-weight:bold:;color:#ffffff">+&nbsp;</span> Ajouter le livre</button>
            </div>

        </form>



    </div>
    <div class="fh5co-about hidden-xs hidden-sm col-lg-4 col-md-4 animate-box">
    <table border="1" style="margin-top:20px"  class="table table-dark">
        <tr>
            <th class="header">ID</th>
            <th class="header">Titre</th>
            <th class="header">Auteur</th>
            <th class="header">Image</th>
            <th class="header" style="text-align: center">Prix</th>
            <th class="header" colspan="3" style="text-align:center">Actions</th>
        </tr>
        <tbody>

        <c:forEach items="${liste}" var="lister">
            <tr>
                <form method="get" action="">
                    <script src='js/jquery183.js'></script>
                    <script src='js/jqueryelevateZoom2.5.5min.js'></script>

                    <td>
                        <img class="zoom_01" height="40" <c:if test="${lister.description != ''}"> src="images/descriptions/id_<c:out value="${lister.id}"/>_<c:out value="${lister.description}"/>" data-zoom-image="images/descriptions/id_<c:out value="${lister.id}"/>_<c:out value="${lister.description}"/>"</c:if> />
                    </td>


                <td width="50">
                    <input value="<c:out value = "${lister.titre}"/>" name="titre" style="background:#353B41;border:0 none">
                </td>
                <td width="50">
                    <input value="<c:out value = "${lister.auteur}"/>" name="auteur" style="background:#353B41;border:0 none" />
                </td>

                    <td>
                        <input name="action" value="addBook" type="hidden" />
                        <input name="plus" value="modifier" type="hidden" />
                        <c:out value = "${lister.id}"/>
                    </td>


                <td>
                    <input value="<c:out value = "${lister.prix}"></c:out>" id="prix1" type="number" step=".01" name="prix" placeholder="Prix" style="background:#353B41;border:0;width:100px;color:#ffffff" class="form-control">
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
                    <input type="hidden" value="${lister.id}" name="id"/>

                    <input type="hidden" value="${page}" name="page" />

                    <button type="submit" class="btn btn-warning btn-xs" title="Modifier ${lister.titre}" ><ion-icon name="construct"  style="margin-top:5px;color:#ffffff"></ion-icon></button>
                </td>
                </form>
                <td style="text-align:center">
                    <a class="btn btn-danger btn-xs" title="Supprimer ${lister.titre}" id="${lister.id}"  onclick='confirmer("<c:out value='${lister.id}' />", "<c:out value='${lister.titre}' />")'><ion-icon name="trash" style="margin-top:5px;color:#ffffff"></ion-icon></a>
                </td>
                <td style="text-align:center">
                    <a class="btn btn btn-info btn-xs" title="Voir ${lister.titre}"  href="?action=viewProduct&product=${lister.id}"><ion-icon name="glasses" style="margin-top:5px;color:#ffffff"></ion-icon></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

        <script>
            function confirmer(id, titre){
                var choice = confirm( "Voulez-vous supprimer le livre "+ titre + " (id " + id+ ")" + "\r\n" + "URL = " + "?action=addBook&plus=supprimer&id=" + id);
                
                
                
                if(choice) {
                	
                    //$( '#' + id ).attr('href', "?action=addBook&plus=supprimer&id=" + id);
                    document.getElementById( id ).href= "?action=addBook&plus=supprimer&id=" + id ;
                    
                }
            }
        </script>

        <div class="container">
            <c:if test="${page>1}">
                <a class="btn btn-info" href="?action=addBook&page=${page-1}&length=${length}">Précédent</a>
            </c:if>

            <button class="btn btn-dark" type="button">${page}</button>

            <c:if test="${suivExist}">
                <a class="btn btn-success" href="?action=addBook&page=${page+1}&length=${length}">Suivant</a>
            </c:if>
        </div>

    </div>

</div>

<br />

<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            $( '#conteneur_image' ).css('display', 'block');
            var reader = new FileReader();

            reader.onload = function(e) {
                $( '#blah' ).css('display', 'block');
                $('#blah').attr('src', e.target.result);




                sessionStorage.setItem('description', document.getElementById("blah").src);
                var data = sessionStorage.getItem('description');
                document.getElementById("description").value = data;




                $( "#conteneur_image" ).after( "<br class='urldl' />" );
            }
            image_size = input.files[0].size;

            reader.readAsDataURL(input.files[0]);
            taille_totale();
        }
    }
</script>
<script>
    function ucfirst (str) {


        str += ''
        var f = str.charAt(0)
            .toUpperCase()
        return f + str.substr(1)
    }
</script>


<script>
    function taille_totale(){
        if(video_size + image_size + document_size > 0){
            if($('.documentdl')) $('.tailldl').remove();
            document.getElementById('taille').style.display = 'inline';
            document.getElementById('tailleBr').style.display = 'block';
            //document.getElementById('tailleBr1').style.display = 'block';


            if( parseInt(video_size + image_size + document_size, 10) > 1048576  ) /** 1Mo **/
            document.getElementById('taille').innerHTML = 'Taille totale uploads : ' + parseInt((video_size + image_size + document_size) /  (1024 * 1000)) + ' Mo';
            else
                document.getElementById('taille').innerHTML = 'Taille totale uploads : ' + (video_size + image_size + document_size)  + ' octets';

            $( "#taille" ).after( "<br class='tailldl' /><br class='tailldl' />" );
        } else {
            document.getElementById('taille').style.display = 'none';
            document.getElementById('tailleBr').style.display = 'none';
        }

        if( parseInt(video_size + image_size + document_size, 10) > 67108864  )  { // 67108864 (64Mo) 2097152 (2Mo) 10485760 (10Mo)
            document.getElementById('depassement_capacite').style.display ='block';
            document.getElementById('depassement_capacite').innerHTML = 'Dépassement de capacité (64Mo max.)';
            document.getElementById('btnvalide').style.visibility = 'hidden';
        } else {
            document.getElementById('depassement_capacite').style.display ='hidden';
            document.getElementById('depassement_capacite').innerHTML = '';
            document.getElementById('btnvalide').style.visibility = 'visible';
        }
    }
</script>

<script>
    $('.zoom_01').elevateZoom();
</script>