<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 02.09.2020
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Czy na pewno chcesz skasować ${author.fullName}</p>
<a href="/author/all">Anuluj</a>&nbsp;<a href="/author/delete/${author.id}">Kasuj</a>
</body>
</html>
