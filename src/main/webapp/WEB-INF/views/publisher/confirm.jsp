<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 02.09.2020
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Czy na pewno chcesz skasować ${publisher.name} wraz ze wszystkimi ksiązkami</p>
<a href="/publisher/all">Anuluj</a>&nbsp;<a href="/publisher/delete/${publisher.id}">Kasuj</a>
</body>
</html>
