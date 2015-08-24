<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Commande</title>
</head>
<body>


<h1>Commande</h1>


<p class="info">${ message }</p>

<fieldset>
    <legend>Informations client</legend>
    <table>
        <tbody>
        <tr>
            <td>Nom</td>
            <td>${commandeForm.nomClient}</td>
        </tr>
        <tr>
            <td>Prénom</td>
            <td>${commandeForm.prenomClient}</td>
        </tr>
        <tr>
            <td>Tél</td>
            <td>${commandeForm.telephoneClient}</td>
        </tr>
        <tr>
            <td>Adresse</td>
            <td>${commandeForm.adresseClient}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td> ${commandeForm.emailClient} </td>
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
            <td>${commandeForm.dateCommande}</td>
        </tr>
        <tr>
            <td>Montant</td>
            <td>${commandeForm.montantCommande}</td>
        </tr>
        <tr>
            <td>Mode de paiement</td>
            <td>${commandeForm.modePaiementCommande}</td>
        </tr>
        <tr>
            <td>Statut du paiement</td>
            <td>${commandeForm.statutPaiementCommande}</td>
        </tr>
        <tr>
            <td>Mode de livraison</td>
            <td>${commandeForm.modeLivraisonCommande}</td>
        </tr>
        <tr>
            <td>Statut de la livraison</td>
            <td>${commandeForm.statutLivraisonCommande}</td>
        </tr>
        </tbody>
    </table>
</fieldset>

</body>
</html>
