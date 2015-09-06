<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="app" var="buld"/>

<div id="menu">
    <ul>
        <li><a href="<c:url value="/creationClient"/>"><fmt:message key="menu.nouveau.client" bundle="${buld}"/></a>
        </li>
        <li><a href="<c:url value="/creationCommande"/>"><fmt:message key="menu.nouveau.commande" bundle="${buld}"/></a>
        </li>
    </ul>
</div>