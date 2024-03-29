<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
    <meta charset="UTF-8">
    <title>Сообщение</title>
</head>

<body>
    <h1 align="center">Написать сообщение</h1>

    <form action="${basePath}/api/message" method="post">

        <label for="login">Кому:</label>
        <input type="text" id="login" name="login"><br><br>

        <label for="text">Сообщение:</label>
        <input type="text" id="text" name="text"><br><br>

        <input type="submit" value="Отправить сообщение">
    </form>
</body>

</html>