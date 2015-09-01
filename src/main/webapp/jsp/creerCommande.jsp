<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
    <title>Creer commande</title>
</head>
<body>
<h1>Créer une commande</h1>
<c:import url="../partial/menu.jsp"/>

<form method="post" action="creationCommande">
    <c:if test="${not empty msgError}">
        <p class="error"><c:out value="${msgError}"/></p>
    </c:if>
    <c:import url="../partial/creerClientForm.jsp"/>


    <fieldset>
        <legend>Informations commande</legend>
        <table>
            <tbody>
            <tr>
                <td><label for="dateCommande">Date <span class="requis">*</span> </label></td>
                <td><input type="text" id="dateCommande" name="dateCommande" value="" size="20" maxlength="20"
                           disabled/></td>
                <td><span class="error"><c:out value="${commandeForm.errors['dateCommande']}"/></span></td>
            </tr>
            <tr>
                <td><label for="montantCommande">Montant <span class="requis">*</span> </label></td>
                <td><input type="text" id="montantCommande" name="montantCommande" size="20" maxlength="20"
                           value="<c:out value="${commandeForm.montantCommande}" />"/></td>
                <td><span class="error"><c:out value="${commandeForm.errors['montantCommande']}"/></span></td>
            </tr>
            <tr>
                <td><label for="modePaiementCommande">Mode de paiement <span class="requis">*</span> </label></td>
                <td><select id="modePaiementCommande" name="modePaiementCommande">
                    <c:forEach items="${commandeForm.listModePaiementCommande}" var="item">
                        <c:choose>
                            <c:when test="${item.selected}">
                                <option value="<c:out value="${item.value}"/>" selected><c:out value="${item.libelle}" /></option>
                            </c:when>
                            <c:otherwise>
                                <option value="<c:out value="${item.value}" />"><c:out value="${item.libelle}" /></option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                </td>
                <td><span class="error"><c:out value="${commandeForm.errors['modePaiementCommande']}"/></span></td>
            </tr>
            <tr>
                <td><label for="statutPaiementCommande">Statut du paiement</label></td>
                <td><input type="text" id="statutPaiementCommande" name="statutPaiementCommande" size="20"
                           maxlength="60" value="<c:out value="${commandeForm.statutPaiementCommande}" />"/></td>
                <td><span class="error"><c:out value="${commandeForm.errors['statutPaiementCommande']}"/></span></td>
            </tr>
            <tr>
                <td><label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span> </label></td>
                <td><select id="modeLivraisonCommande" name="modeLivraisonCommande">
                    <c:forEach items="${commandeForm.listModeLivraisonCommande}" var="item">
                        <c:choose>
                            <c:when test="${item.selected}">
                                <option value="<c:out value="${item.value}"/>" selected><c:out value="${item.libelle}" /></option>
                            </c:when>
                            <c:otherwise>
                                <option value="<c:out value="${item.value}" />"><c:out value="${item.libelle}" /></option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                </td>
                <td><span class="error"><c:out value="${commandeForm.errors['modeLivraisonCommande']}"/></span></td>
            </tr>
            <tr>
                <td><label for="statutLivraisonCommande">Statut de la livraison</label></td>
                <td><input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" size="20"
                           maxlength="60" value="<c:out value="${commandeForm.statutLivraisonCommande}"/>"/></td>
                <td><span class="error"><c:out value="${commandeForm.errors['statutLivraisonCommande']}"/></span></td>
            </tr>
            </tbody>
        </table>
    </fieldset>

    <input type="submit" value="valider"/>
    <input type="reset" value="RAZ">
</form>

</body>
</html>
