<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client</title>
</head>
<body>

<h1>Nouveau client</h1>

<p class="info">${ message }</p>

<fieldset>
    <legend>Informations client</legend>
    <table>
        <tbody>
        <tr>
            <td>Nom</td>
            <td>${clientForm.nomClient}</td>
        </tr>
        <tr>
            <td>Prénom</td>
            <td>${clientForm.prenomClient}</td>
        </tr>
        <tr>
            <td>Tél</td>
            <td>${clientForm.telephoneClient}</td>
        </tr>
        <tr>
            <td>Adresse</td>
            <td>${clientForm.adresseClient}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td> ${clientForm.emailClient} </td>
        </tr>
        </tbody>
    </table>
</fieldset>

</body>
</html>
