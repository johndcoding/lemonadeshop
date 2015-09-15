<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="app" var="buld"/>
<!DOCTYPE html>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <title>index</title>
</head>
<body>
<h1><fmt:message key="site.titre" bundle="${buld}"/></h1>

<p><fmt:message key="site.presentation" bundle="${buld}"/></p>
<ul>
    <li><a href="<c:url value="/creationClient"/>"><fmt:message key="menu.nouveau.client" bundle="${buld}"/></a></li>
    <li><a href="<c:url value="/creationCommande"/>"><fmt:message key="menu.nouveau.commande" bundle="${buld}"/></a>
    </li>
    <li><a href="<c:url value="/listerClients"/>"><fmt:message key="menu.lister.clients" bundle="${buld}"/></a>
    </li>
    <li><a href="<c:url value="/listerCommandes"/>"><fmt:message key="menu.lister.commandes" bundle="${buld}"/></a>
    </li>
</ul>
</body>
</html>
