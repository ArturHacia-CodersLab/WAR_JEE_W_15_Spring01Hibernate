<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 23.08.2020
  Time: 08:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Czy na pewno chcesz skasować ${book.title}</p>
    <a href="/book/all">Anuluj</a>&nbsp;<a href="/book/delete/${book.id}">Kasuj</a>
</body>
</html>
