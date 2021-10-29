<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 10/28/2021
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Settings</title>
</head>
<body>
<h1>Settings</h1>

<form:form method="post" action="/form/update" modelAttribute="emailSettings">
    <table>
        <tr>
            <td><form:label path="languages">Languages: </form:label></td>
            <td><form:select path="languages" items="${languages}"/></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td>Show <form:select path="pageSize" items="${pageSize}"/> emails/page</td>
        </tr>
        <tr>
            <td><form:label path="spamFilter">Spam Filter: </form:label></td>
            <td><form:checkbox path="spamFilter"/> Enable spams filter </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>