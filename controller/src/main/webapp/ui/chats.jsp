<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
    <meta charset="UTF-8">
    <title>Сообщения</title>
</head>

<body>
    <h1 align="center">Мои Сообщения</h1>

    <c:choose>
        <c:when test="${empty messages}">
            <h2 align="center">Сообщений нет</h2>
        </c:when>

        <c:otherwise>
            <table border="1" align="center">
                <tr>
                    <td>Дата:</td>
                    <td>От кого:</td>
                    <td>Сообщение:</td>
                </tr>
                <c:forEach var="message" items="${messages}">
                    <tr>
                        <td>${message.localDateTime}</td>
                        <td>${message.from}</td>
                        <td>${message.body}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</body>

</html>