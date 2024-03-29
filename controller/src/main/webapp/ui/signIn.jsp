<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Вход</title>
</head>
<body>
    <h1 align="center">Вход</h1>

    <form action="${basePath}/api/login" method="post">
        <label for="login">Логин:</label>
        <input type="text" id="login" name="login"><br><br>

        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password"><br><br>

        <input type="submit" value="Войти">
    </form>

</body>
</html>
