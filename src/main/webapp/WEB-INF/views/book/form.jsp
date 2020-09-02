<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 22.08.2020
  Time: 15:28
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
    <form:form method="post" modelAttribute="book">
<%--        <form:errors path="*"/><br>--%>
        <form:hidden path="id"/>
        Tytuł: <form:input path="title"/><br>
        <form:errors path="title" cssClass="error"/><br>
        Rating:<br>
        <c:forEach begin="1" end="10" var="index">
            <form:radiobutton path="rating" label="${index}" value="${index}"/>
        </c:forEach><br>
        <form:errors path="rating" cssClass="error"/><br>
        Opis: <form:textarea path="description" rows="5" cols="20"/><br>
        <form:errors path="description" cssClass="error"/><br>
        Wydawca: <form:select path="publisher">
            <form:option value="0" label="wybierz wydawcę"/>
            <form:options items="${publishers}" itemValue="id" itemLabel="name"/>
        </form:select><br>
        <form:errors path="publisher" cssClass="error"/><br>
        Autorzy:<br>
        <form:select path="authors" items="${authors}" itemValue="id" itemLabel="fullName" multiple="true"/><br>
        <form:errors path="authors" cssClass="error"/><br>
        Strony: <form:input path="pages"/><br>
        <form:errors path="pages" cssClass="error"/><br>
        <input type="submit" value="Wyślij">
    </form:form>
</body>
</html>
