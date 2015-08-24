<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <title>creer client</title>
</head>
<body>
<h1>Nouveau client</h1>

<form method="post" action="creationClient">
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
    <input type="submit" value="valider"/>
    <input type="reset" value="RAZ">
</form>

</body>
</html>
