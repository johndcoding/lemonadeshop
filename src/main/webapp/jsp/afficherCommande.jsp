<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
    <title>Commande</title>
</head>
<body>


<h1>Commande</h1>
<c:import url="../partial/menu.jsp"/>
<c:choose>
    <c:when test="${commandeForm.validated}">
        <p class="info">Le nouveau client est créé.</p>
    </c:when>
    <c:otherwise>
        <p class="info">Un champ obligatoire n'a pas été saisie.</p>
    </c:otherwise>
</c:choose>

<fieldset>
    <legend>Informations client</legend>
    <table>
        <tbody>
        <tr>
            <td>Nom</td>
            <td><c:out value="${clientForm.nomClient}" /></td>
        </tr>
        <tr>
            <td>Prénom</td>
            <td><c:out value="${clientForm.prenomClient}" /></td>
        </tr>
        <tr>
            <td>Tél</td>
            <td><c:out value="${clientForm.telephoneClient}" /></td>
        </tr>
        <tr>
            <td>Adresse</td>
            <td><c:out value="${clientForm.adresseClient}" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td> <c:out value="${clientForm.emailClient}" /> </td>
        </tr>
        </tbody>
    </table>
</fieldset>

<fieldset>
    <legend>Commande</legend>
    <table>
        <tbody>
        <tr>
            <td>Date</td>
            <td><c:out value="${commandeForm.dateCommande}" /></td>
        </tr>
        <tr>
            <td>Montant</td>
            <td><c:out value="${commandeForm.montantCommande}" /></td>
        </tr>
        <tr>
            <td>Mode de paiement</td>
            <td><c:out value="${commandeForm.modePaiementCommande}" /></td>
        </tr>
        <tr>
            <td>Statut du paiement</td>
            <td><c:out value="${commandeForm.statutPaiementCommande}" /></td>
        </tr>
        <tr>
            <td>Mode de livraison</td>
            <td><c:out value="${commandeForm.modeLivraisonCommande}" /></td>
        </tr>
        <tr>
            <td>Statut de la livraison</td>
            <td><c:out value="${commandeForm.statutLivraisonCommande}" /></td>
        </tr>
        </tbody>
    </table>
</fieldset>

</body>
</html>
