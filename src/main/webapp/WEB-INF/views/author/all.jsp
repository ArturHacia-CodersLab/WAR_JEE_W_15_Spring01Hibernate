<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 23.08.2020
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Lista autorów</h1>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Imię</td>
        <td>Nazwisko</td>
        <td>PESEL</td>
        <td>Email</td>
        <td>Książki</td>
        <td></td>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>${author.pesel}</td>
            <td>${author.email}</td>
            <td>${author.books}</td>
            <td>
                <a href="/author/edit/${author.id}">Edycja</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
