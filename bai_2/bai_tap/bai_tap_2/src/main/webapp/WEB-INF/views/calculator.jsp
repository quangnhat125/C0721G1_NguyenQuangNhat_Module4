<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 10/28/2021
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CALCULATOR</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculator" method="post">
    <input type="text" name="number1">
    <input type="text" name="number2">
    <hr>
    <button type="submit" name="calculate" value="+">Addition(+)</button>
    <button type="submit" name="calculate" value="-">Subtraction(-)</button>
    <button type="submit" name="calculate" value="*">Multiplication(*)</button>
    <button type="submit" name="calculate" value="/">Division(/)</button>
</form>
<h2>${result}</h2>
</body>
</html>
