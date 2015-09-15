<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="app" var="buld"/>

    <table>
        <tbody>
        <tr>
            <td><label for="nomClient"><fmt:message key="client.nom" bundle="${buld}"/> <span class="requis">*</span>
            </label></td>
            <td><input type="text" id="nomClient" name="nomClient" size="20" maxlength="20"
                       value="<c:out value="${clientForm.nomClient}" />"/></td>
            <td><span class="error"><c:out value="${clientForm.errors['nomClient']}"/></span></td>
        </tr>
        <tr>
            <td><label for="prenomClient"><fmt:message key="client.prenom" bundle="${buld}"/><span
                    class="requis">*</span> </label></td>
            <td><input type="text" id="prenomClient" name="prenomClient" size="20" maxlength="20"
                       value="<c:out value="${clientForm.prenomClient}" />"/>
            </td>
            <td><span class="error"><c:out value="${clientForm.errors['prenomClient']}"/></span></td>
        </tr>
        <tr>
            <td><label for="telephoneClient"><fmt:message key="client.telephone" bundle="${buld}"/> <span
                    class="requis">*</span> </label></td>
            <td><input type="text" id="telephoneClient" name="telephoneClient" size="20" maxlength="20"
                       value="<c:out value="${clientForm.telephoneClient}" />"/>
            </td>
            <td><span class="error"><c:out value="${clientForm.errors['telephoneClient']}"/></span></td>
        </tr>
        <tr>
            <td><label for="adresseClient"><fmt:message key="client.adresse" bundle="${buld}"/> <span
                    class="requis">*</span> </label></td>
            <td><input type="text" id="adresseClient" name="adresseClient" size="60" maxlength="60"
                       value="<c:out value="${clientForm.adresseClient}" />"/>
            </td>
            <td><span class="error"><c:out value="${clientForm.errors['adresseClient']}"/></span></td>
        </tr>
        <tr>
            <td><label for="emailClient"><fmt:message key="client.email" bundle="${buld}"/> <span
                    class="requis">*</span> </label></td>
            <td><input type="text" id="emailClient" name="emailClient" size="20" maxlength="60"
                       value="<c:out value="${clientForm.emailClient}" />"/></td>
            <td><span class="error"><c:out value="${clientForm.errors['emailClient']}"/></span></td>
        </tr>
        </tbody>
    </table>
