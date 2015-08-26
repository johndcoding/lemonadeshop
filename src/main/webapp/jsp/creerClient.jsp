<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
    <title>creer client</title>
</head>
<body>
<h1>Nouveau client</h1>
<c:import url="../partial/menu.jsp"/>

<form method="post" action="creationClient">
    <c:import url="../partial/creerClientForm.jsp"/>
    <input type="submit" value="valider"/>
    <input type="reset" value="RAZ">
</form>

</body>
</html>
