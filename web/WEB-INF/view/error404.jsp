<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>

    <style>
        <%@include file='../../DisError.css' %>
    </style>
</head>

<body>
        <h1>Ошибка!</h1>

        <p>Этой страницы не существует или Вы пытаетесь ввести неверные данные!</p>

        <input type="button" class="butn" onclick="history.back();" value="Назад"/>
</body>
</html>