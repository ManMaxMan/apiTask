<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
</head>
<body>

    <h1 align="center">Регистрация</h1>

    <form action="${basePath}/api/user" method="post">
        <label for="fio">ФИО:</label>
        <input type="text" id="fio" name="fio"><br><br>

        <label for="birthday">Дата рождения:</label>
        <input type="date" id="birthday" name="birthday"><br><br>

        <label for="login">Логин:</label>
        <input type="text" id="login" name="login"><br><br>

        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password"><br><br>

        <input type="submit" value="Регистрация">
    </form>

</body>
</html>
