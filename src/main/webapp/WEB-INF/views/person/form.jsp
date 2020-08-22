<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="inpu" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 22.08.2020
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <form method="post">--%>
<%--        Login: <input type="text" name="login"><br>--%>
<%--        Hasło: <input type="password" name="password"><br>--%>
<%--        Email: <input type="text" name="email"><br>--%>
<%--        <input type="submit" value="Wyślij">--%>
<%--    </form>--%>

    <form:form method="post" modelAttribute="person">
        Login: <form:input path="login"/><br>
        Hasło: <form:password path="password"/><br>
        Email: <form:input path="email"/><br>
        <input type="submit" value="Wyślij"/>
    </form:form>
</body>
</html>
