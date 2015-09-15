<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="app" var="buld"/>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
    <title><fmt:message key="client.affichage.titre" bundle="${buld}"/></title>
</head>
<body>

<h1><fmt:message key="client.affichage.titre" bundle="${buld}"/></h1>
<c:import url="../partial/menu.jsp"/>

<p class="info"><fmt:message key="client.creation.success" bundle="${buld}"/></p>

<fieldset>
    <legend><fmt:message key="client.fieldset.informations" bundle="${buld}"/></legend>
    <table>
        <tbody>
        <tr>
            <td><fmt:message key="client.nom" bundle="${buld}"/></td>
            <td><c:out value="${client.nom}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="client.prenom" bundle="${buld}"/></td>
            <td><c:out value="${client.prenom}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="client.telephone" bundle="${buld}"/></td>
            <td><c:out value="${client.tel}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="client.adresse" bundle="${buld}"/></td>
            <td><c:out value="${client.adresse}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="client.email" bundle="${buld}"/></td>
            <td><c:out value="${client.email}"/></td>
        </tr>
        </tbody>
    </table>
</fieldset>

</body>
</html>
