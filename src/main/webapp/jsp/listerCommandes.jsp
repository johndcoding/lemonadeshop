<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="app" var="buld"/>
<html>
<head>
  <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
  <title><fmt:message key="lister.commande.titre" bundle="${buld}"/></title>
</head>
<body>

<c:import url="../partial/menu.jsp" />
<h1><fmt:message key="lister.commande.titre" bundle="${buld}"/></h1>


<table class="list">
  <thead>
  <tr>
    <th><fmt:message key="commande.client" bundle="${buld}"/></th>
    <th><fmt:message key="commande.date.creation" bundle="${buld}"/></th>
    <th><fmt:message key="commande.montant" bundle="${buld}"/></th>
    <th><fmt:message key="commande.mode.paiement" bundle="${buld}"/></th>
    <th><fmt:message key="commande.statut.paiement" bundle="${buld}"/></th>
    <th><fmt:message key="commande.mode.livraison" bundle="${buld}"/></th>
    <th><fmt:message key="commande.statut.livraison" bundle="${buld}"/></th>
    <th><fmt:message key="list.action" bundle="${buld}"/></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${LIST_COMMANDE}" var="commande" varStatus="loopStatut">
    <tr class="${loopStatut.index % 2 == 0 ? 'pair' : 'impair'}">
      <td><c:out value="${commande.client.nom}" /> <c:out value="${commande.client.prenom}" /></td>
      <td><fmt:formatDate value="${commande.dateCreation}" type="both" /></td>
      <td><c:out value="${commande.montant}" /></td>
      <td><c:out value="${commande.modePaiement}" /></td>
      <td><c:out value="${commande.statutPaiement}" /></td>
      <td><c:out value="${commande.modeLivraison}" /></td>
      <td><c:out value="${commande.statutLivraison}" /></td>
      <td><a href="<c:url value="/supprimerCommande"><c:param name="ID_COMMANDE_TO_DELETE" value="${commande.dateCreation}"/> </c:url>"><fmt:message key="list.action.supprimer" bundle="${buld}"/></a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>




</body>
</html>
