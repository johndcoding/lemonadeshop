<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <title>Creer commande</title>
</head>
<body>
<h1>Créer une commande</h1>

<form method="post" action="creationCommande">
    <fieldset>
        <legend>Informations client</legend>
        <table>
            <tbody>
            <tr>
                <td><label for="nomClient">Nom <span class="requis">*</span> </label></td>
                <td><input type="text" id="nomClient" name="nomClient" value="" size="20" maxlength="20"/></td>
            </tr>
            <tr>
                <td><label for="prenomClient">Prénom <span class="requis">*</span> </label></td>
                <td><input type="text" id="prenomClient" name="prenomClient" value="" size="20" maxlength="20"/></td>
            </tr>
            <tr>
                <td><label for="telephoneClient">Tél <span class="requis">*</span> </label></td>
                <td><input type="text" id="telephoneClient" name="telephoneClient" value="" size="20" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <td><label for="adresseClient">Adresse <span class="requis">*</span> </label></td>
                <td><input type="text" id="adresseClient" name="adresseClient" value="" size="60" maxlength="60"/>
                </td>
            </tr>
            <tr>
                <td><label for="emailClient">Email <span class="requis">*</span> </label></td>
                <td><input type="text" id="emailClient" name="emailClient" value="" size="20" maxlength="60"/></td>
            </tr>
            </tbody>
        </table>
    </fieldset>
    <fieldset>
        <legend>Informations commande</legend>
        <table>
            <tbody>
            <tr>
                <td><label for="dateCommande">Date <span class="requis">*</span> </label></td>
                <td><input type="text" id="dateCommande" name="dateCommande" value="" size="20" maxlength="20" disabled/></td>
            </tr>
            <tr>
                <td><label for="montantCommande">Montant <span class="requis">*</span> </label></td>
                <td><input type="text" id="montantCommande" name="montantCommande" value="" size="20" maxlength="20"/></td>
            </tr>
            <tr>
                <td><label for="modePaiementCommande">Mode de paiement <span class="requis">*</span> </label></td>
                <td><select id="modePaiementCommande" name="modePaiementCommande">
                    <option value="CB">Carte banquaire</option>
                    <option value="CHEQUE">Chèque</option>
                    <option value="PAYPAL">Paypal</option>
                </select>
                </td>
            </tr>
            <tr>
                <td><label for="statutPaiementCommande">Statut du paiement</label></td>
                <td><input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="" size="20" maxlength="60"/></td>
            </tr>
            <tr>
                <td><label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span> </label></td>
                <td><select id="modeLivraisonCommande" name="modeLivraisonCommande">
                    <option value="NORMAL">normal</option>
                    <option value="RAPIDE">rapide</option>
                </select>
                </td>
            </tr>
            <tr>
                <td><label for="statutLivraisonCommande">Statut de la livraison</label></td>
                <td><input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value="" size="20" maxlength="60"/></td>
            </tr>
            </tbody>
        </table>
    </fieldset>

    <input type="submit" value="valider"/>
    <input type="reset" value="RAZ">
</form>

</body>
</html>
