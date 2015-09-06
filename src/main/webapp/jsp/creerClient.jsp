<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="app" var="buld"/>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
    <title><fmt:message key="client.creation.titre" bundle="${buld}"/></title>
</head>
<body>
<h1><fmt:message key="client.creation.titre" bundle="${buld}"/></h1>
<c:import url="../partial/menu.jsp"/>

<form method="post" action="creationClient">

    <c:if test="${not empty msgError}">
        <p class="error"><c:out value="${msgError}"/></p>
    </c:if>
    <c:import url="../partial/creerClientForm.jsp"/>

    <input type="submit" value="<fmt:message key="formulaire.valider" bundle="${buld}" />"/>
    <input type="reset" value="<fmt:message key="formulaire.raz" bundle="${buld}" />">
</form>

</body>
</html>
