<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 22.08.2020
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Lista książek</h1>
    <a href="/book/form">Dodaj książkę</a><br>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Tytul</td>
            <td>Rating</td>
            <td>Opis</td>
            <td>Wydawca</td>
            <td>Autorzy</td>
            <td>Strony</td>
            <td></td>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.rating}</td>
                <td>${book.description}</td>
                <td>${book.publisher.name}</td>
                <td>${book.authors}</td>
                <td>${book.pages}</td>
                <td>
                    <a href="/book/edit/${book.id}">Edycja</a>&nbsp;<a href="/book/confirm/${book.id}">Kasowanie</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
