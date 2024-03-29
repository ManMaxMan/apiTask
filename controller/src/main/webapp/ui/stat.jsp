<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
    <meta charset="UTF-8">
    <title>Статистика</title>
</head>

<body>
    <h1 align="center">Статистика</h1>

    <c:choose>
        <c:when test="${empty statistics}">
            <h2 align="center">Приложение никому не интересно</h2>
        </c:when>

        <c:otherwise>
            <table border="1" align="center">
                <tr>
                    <td>Зарегистрировано пользователей:</td>
                    <td>${statistics.users}</td>
                </tr>
                <tr>
                     <td>Активно пользователей:</td>
                     <td>${statistics.activeUsers}</td>
                </tr>
                <tr>
                     <td>Сообщений:</td>
                     <td>${statistics.messages}</td>
                </tr>
            </table>
        </c:otherwise>
    </c:choose>
</body>

</html>