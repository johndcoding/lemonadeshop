<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="app" var="buld"/>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
    <script src="<c:url value="/static/lib/js/jquery-2.1.4.js"/>" ></script>
    <script src="<c:url value="/static/js/main.js"/>" ></script>
    <title><fmt:message key="commande.creation.titre" bundle="${buld}"/></title>
</head>
<body>
<h1><fmt:message key="commande.creation.titre" bundle="${buld}"/></h1>
<c:import url="../partial/menu.jsp"/>


<form method="post" action="creationCommande">
    <c:if test="${not empty msgError}">
        <p class="error"><c:out value="${msgError}"/></p>
    </c:if>
    <fieldset>
        <legend><fmt:message key="client.fieldset.informations" bundle="${buld}"/></legend>

        <table>
            <tbody>
            <tr>
                <td>
                    <label for="creerNouveauClient">
                        <fmt:message key="commande.creer.nouveau.client" bundle="${buld}"/>
                </td>
                <td>
                    <c:choose>
                        <c:when test="true == ${commandeForm.listClientExistant}">
                            <fmt:message key="formulaire.radio.oui" bundle="${buld}"/>
                            <input type="radio" id="creerNouveauClient"
                                   name="creerNouveauClient" value="true"
                                   checked/>
                            <fmt:message key="formulaire.radio.non" bundle="${buld}"/>
                            <input type="radio" id="creerNouveauClient"
                                   name="creerNouveauClient"
                                   value="false"/>

                        </c:when>
                        <c:otherwise>
                            <fmt:message key="formulaire.radio.oui" bundle="${buld}"/>
                            <input type="radio" id="creerNouveauClient"
                                   name="creerNouveauClient"
                                   value="true"/>
                            <fmt:message key="formulaire.radio.non" bundle="${buld}"/>
                            <input type="radio" id="creerNouveauClient"
                                   name="creerNouveauClient" value="false"
                                   checked/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><span class="error"><c:out value="${commandeForm.errors['creerNouveauClient']}"/></span></td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <select name="clientExistant">
                        <option value=""></option>
                        <c:forEach items="${commandeForm.listClientExistant}" var="item">
                            <c:choose>
                                <c:when test="${item.selected}">
                                    <option value="<c:out value="${item.value}"/>" selected><c:out
                                            value="${item.libelle}"/></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value="${item.value}" />"><c:out
                                            value="${item.libelle}"/></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td></td>
            </tr>
            </tbody>
        </table>
        <div id="formClient">
            <c:import url="../partial/creerClientForm.jsp"/>
        </div>
    </fieldset>

    <fieldset>
        <legend><fmt:message key="commande.fielset.informations" bundle="${buld}"/></legend>
        <table>
            <tbody>
            <tr>
                <td><label for="dateCommande"><fmt:message key="commande.date.creation" bundle="${buld}"/> <span
                        class="requis">*</span> </label></td>
                <td><input type="text" id="dateCommande" name="dateCommande" value="" size="20" maxlength="20"
                           disabled/></td>
                <td><span class="error"><c:out value="${commandeForm.errors['dateCommande']}"/></span></td>
            </tr>
            <tr>
                <td><label for="montantCommande"><fmt:message key="commande.montant" bundle="${buld}"/> <span
                        class="requis">*</span> </label></td>
                <td><input type="text" id="montantCommande" name="montantCommande" size="20" maxlength="20"
                           value="<c:out value="${commandeForm.montantCommande}" />"/></td>
                <td><span class="error"><c:out value="${commandeForm.errors['montantCommande']}"/></span></td>
            </tr>
            <tr>
                <td><label for="modePaiementCommande"><fmt:message key="commande.mode.paiement" bundle="${buld}"/> <span
                        class="requis">*</span> </label></td>
                <td><select id="modePaiementCommande" name="modePaiementCommande">
                    <c:forEach items="${commandeForm.listModePaiementCommande}" var="item">
                        <c:choose>
                            <c:when test="${item.selected}">
                                <option value="<c:out value="${item.value}"/>" selected><c:out
                                        value="${item.libelle}"/></option>
                            </c:when>
                            <c:otherwise>
                                <option value="<c:out value="${item.value}" />"><c:out
                                        value="${item.libelle}"/></option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                </td>
                <td><span class="error"><c:out value="${commandeForm.errors['modePaiementCommande']}"/></span></td>
            </tr>
            <tr>
                <td><label for="statutPaiementCommande"><fmt:message key="commande.statut.paiement"
                                                                     bundle="${buld}"/></label></td>
                <td><input type="text" id="statutPaiementCommande" name="statutPaiementCommande" size="20"
                           maxlength="60" value="<c:out value="${commandeForm.statutPaiementCommande}" />"/></td>
                <td><span class="error"><c:out value="${commandeForm.errors['statutPaiementCommande']}"/></span></td>
            </tr>
            <tr>
                <td><label for="modeLivraisonCommande"><fmt:message key="commande.mode.livraison" bundle="${buld}"/>
                    <span class="requis">*</span> </label></td>
                <td><select id="modeLivraisonCommande" name="modeLivraisonCommande">
                    <c:forEach items="${commandeForm.listModeLivraisonCommande}" var="item">
                        <c:choose>
                            <c:when test="${item.selected}">
                                <option value="<c:out value="${item.value}"/>" selected><c:out
                                        value="${item.libelle}"/></option>
                            </c:when>
                            <c:otherwise>
                                <option value="<c:out value="${item.value}" />"><c:out
                                        value="${item.libelle}"/></option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                </td>
                <td><span class="error"><c:out value="${commandeForm.errors['modeLivraisonCommande']}"/></span></td>
            </tr>
            <tr>
                <td><label for="statutLivraisonCommande"><fmt:message key="commande.statut.livraison"
                                                                      bundle="${buld}"/></label></td>
                <td><input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" size="20"
                           maxlength="60" value="<c:out value="${commandeForm.statutLivraisonCommande}"/>"/></td>
                <td><span class="error"><c:out value="${commandeForm.errors['statutLivraisonCommande']}"/></span></td>
            </tr>
            </tbody>
        </table>
    </fieldset>

    <input type="submit" value="<fmt:message key="formulaire.valider" bundle="${buld}" />"/>
    <input type="reset" value="<fmt:message key="formulaire.raz" bundle="${buld}" />">
</form>

</body>
</html>
