<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="app" var="buld"/>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
    <title><fmt:message key="commande.affichage.titre" bundle="${buld}"/></title>
</head>
<body>


<h1><fmt:message key="commande.affichage.titre" bundle="${buld}"/></h1>
<c:import url="../partial/menu.jsp"/>
<c:choose>
    <c:when test="${commandeForm.validated}">
        <p class="info"><fmt:message key="commande.creation.success" bundle="${buld}"/></p>
    </c:when>
    <c:otherwise>
        <p class="info"><fmt:message key="commande.creation.fail" bundle="${buld}"/></p>
    </c:otherwise>
</c:choose>


<fieldset>
    <legend><fmt:message key="client.fieldset.informations" bundle="${buld}"/></legend>
    <table>
        <tbody>
        <tr>
            <td><fmt:message key="client.nom" bundle="${buld}"/></td>
            <td><c:out value="${clientForm.nomClient}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="client.prenom" bundle="${buld}"/></td>
            <td><c:out value="${clientForm.prenomClient}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="client.telephone" bundle="${buld}"/></td>
            <td><c:out value="${clientForm.telephoneClient}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="client.adresse" bundle="${buld}"/></td>
            <td><c:out value="${clientForm.adresseClient}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="client.email" bundle="${buld}"/></td>
            <td><c:out value="${clientForm.emailClient}"/></td>
        </tr>
        </tbody>
    </table>
</fieldset>

<fieldset>
    <legend><fmt:message key="commande.fielset.informations" bundle="${buld}"/></legend>
    <table>
        <tbody>
        <tr>
            <td><fmt:message key="commande.date.creation" bundle="${buld}"/></td>
            <td><c:out value="${commandeForm.dateCommande}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="commande.montant" bundle="${buld}"/></td>
            <td><c:out value="${commandeForm.montantCommande}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="commande.mode.paiement" bundle="${buld}"/></td>
            <td><c:out value="${commandeForm.modePaiementCommande}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="commande.statut.paiement" bundle="${buld}"/></td>
            <td><c:out value="${commandeForm.statutPaiementCommande}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="commande.mode.livraison" bundle="${buld}"/></td>
            <td><c:out value="${commandeForm.modeLivraisonCommande}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="commande.statut.livraison" bundle="${buld}"/></td>
            <td><c:out value="${commandeForm.statutLivraisonCommande}"/></td>
        </tr>
        </tbody>
    </table>
</fieldset>

</body>
</html>
