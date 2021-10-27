<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 10/27/2021
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich Condiments</title>
  </head>
  <body>
  <h1>Please Choose Sandwich Condiments</h1>
  <form action="/sandwich" >
    <input type="checkbox" name="condiment" value="lettuce">Lettuce
    <input type="checkbox" name="condiment" value="tomato">Mustard
    <input type="checkbox" name="condiment" value="mustard">Tomato
    <input type="checkbox" name="condiment" value="sprouts">Sprouts
    <input type="submit" name="submit" value="save">
  </form>
  </body>
</html>
