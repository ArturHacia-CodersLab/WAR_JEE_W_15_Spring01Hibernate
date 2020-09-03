<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 02.09.2020
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Lista wydawców</h1>
<a href="/publisher/form">Dodaj wydawcę</a><br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Nazwa</td>
        <td>NIP</td>
        <td>REGON</td>
        <td></td>
    </tr>
    <c:forEach var="publisher" items="${publishers}">
        <tr>
            <td>${publisher.id}</td>
            <td>${publisher.name}</td>
            <td>${publisher.nip}</td>
            <td>${publisher.regon}</td>
            <td>
                <a href="/publisher/edit/${publisher.id}">Edycja</a> <a href="/publisher/confirm/${publisher.id}">Kasowanie</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
