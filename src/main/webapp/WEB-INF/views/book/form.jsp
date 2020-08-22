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
</head>
<body>
    <form:form method="post" modelAttribute="book">
        Tytuł: <form:input path="title"/><br>
        Rating:<br>
        <c:forEach begin="1" end="10" var="index">
            <form:radiobutton path="rating" label="${index}" value="${index}"/>
        </c:forEach><br>
        Opis: <form:textarea path="description" rows="5" cols="20"/><br>
        Wydawca: <form:select path="publisher.id">
            <form:option value="0" label="wybierz wydawcę"/>
            <form:options items="${publishers}" itemValue="id" itemLabel="name"/>
        </form:select>
        <input type="submit" value="Wyślij">
    </form:form>
</body>
</html>
