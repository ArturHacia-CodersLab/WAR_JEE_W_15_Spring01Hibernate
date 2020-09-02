<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 23.08.2020
  Time: 16:12
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
    <form:form method="post" modelAttribute="author">
        <form:hidden path="id"/>
        Imię: <form:input path="firstName"/><br>
        <form:errors path="firstName" cssClass="error"/><br>
        Nazwisko: <form:input path="lastName"/><br>
        <form:errors path="lastName" cssClass="error"/><br>
        PESEL: <form:input path="pesel" maxlength="11"/><br>
        <form:errors path="pesel" cssClass="error"/><br>
        Email: <form:input path="email"/><br>
        <form:errors path="email" cssClass="error"/><br>
        Rok urodzenia: <form:input path="yearOfBirth" maxlength="4"/><br>
        <form:errors path="yearOfBirth" cssClass="error"/><br>
        <input type="submit" value="Wyślij">
    </form:form>
</body>
</html>
