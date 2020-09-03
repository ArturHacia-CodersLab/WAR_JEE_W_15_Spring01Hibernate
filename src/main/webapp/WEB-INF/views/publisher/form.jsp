<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 02.09.2020
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="publisher">
    <form:hidden path="id"/>
    Nazwa: <form:input path="name"/><br>
    <form:errors path="name" cssClass="error"/><br>
    NIP: <form:input path="nip"/><br>
    <form:errors path="nip" cssClass="error"/><br>
    REGON: <form:input path="regon"/><br>
    <form:errors path="regon" cssClass="error"/><br>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>
