<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta charset="UTF-8">
    <title>Main</title>
</head>

<body>
    <h1 align="center">TaskAPI</h1>

    <form action="${basePath}/ui/signUp" method="get">
        <button type="submit">Регистрация</button>
    </form>
    <br>

    <form action="${basePath}/ui/signIn" method="get">
        <button type="submit">Вход</button>
    </form>
    <br>

    <form action="${basePath}/ui/user/message" method="get">
        <button type="submit">Отправить сообщение</button>
    </form>
    <br>

    <form action="${basePath}/ui/user/chats" method="get">
        <button type="submit">Мои сообщения</button>
    </form>
    <br>

    <form action="${basePath}/ui/admin/statistics" method="get">
        <button type="submit">Статистика</button>
    </form>

</body>
</html>
