<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="app" var="buld"/>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
    <title><fmt:message key="lister.client.titre" bundle="${buld}"/></title>
</head>
<body>

  <h1><fmt:message key="lister.client.titre" bundle="${buld}"/></h1>
  <c:import url="../partial/menu.jsp"/>


    <table class="list">
        <thead>
            <tr>
                <th><fmt:message key="client.nom" bundle="${buld}"/></th>
                <th><fmt:message key="client.prenom" bundle="${buld}"/></th>
                <th><fmt:message key="client.telephone" bundle="${buld}"/></th>
                <th><fmt:message key="client.email" bundle="${buld}"/></th>
                <th><fmt:message key="client.adresse" bundle="${buld}"/></th>
                <th><fmt:message key="list.action" bundle="${buld}"/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${LIST_CLIENT}" var="client" varStatus="loopStatut">
                <tr class="${loopStatut.index % 2 == 0 ? 'pair' : 'impair'}">
                    <td><c:out value="${client.nom}"/></td>
                    <td><c:out value="${client.prenom}"/></td>
                    <td><c:out value="${client.tel}"/></td>
                    <td><c:out value="${client.email}"/></td>
                    <td><c:out value="${client.adresse}"/></td>
                    <td><a href="<c:url value="/supprimerClient"><c:param name="ID_CLIENT_TO_DELETE" value="${client.nom}"/> </c:url>"><fmt:message key="list.action.supprimer" bundle="${buld}"/></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
