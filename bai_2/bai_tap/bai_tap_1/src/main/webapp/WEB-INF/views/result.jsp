<%@ taglib prefix="c" uri=""%>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 10/28/2021
  Time: 12:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESULT AFTER CHOOSING</title>
</head>
<body>
<h1>Sandwich Condiments:</h1>
<%--<c:if test="${requestScope['condiment']  != null}">--%>
<%--    <c:forEach var="c" items="${condiment}">--%>
<%--        <span>${c}</span>--%>
<%--    </c:forEach>--%>
<%--</c:if>--%>
<c:if test='${condiment != null}'>
    <c:forEach var="condiment" items="${condiment}">
        <span style="font-size: xx-large;color: red"><c:out value="${condiment}"/></span>
    </c:forEach>
</c:if>
</body>
</html>
