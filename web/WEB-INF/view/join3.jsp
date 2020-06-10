<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Join3</title>

    <style>

        <%@include file='../../Designer.css' %>
        <%@include file='../../DisJoin.css' %>
    </style>

</head>
<body>
<h2><jsp:include page="menuJoin.jsp"/></h2>
<h1>Запрос 3</h1>

<p>Информация о клиентах и проданных им автомобилях</p>

<table>
    <tr>
        <th width="150">ФИО</th>
        <th width="100">Марка</th>
        <th width="100">Модель</th>
    </tr>
    <c:forEach items="${zapros3}" var="auto">
        <tbody>
        <tr>
            <td align="center" colspan="3">${auto}</td>
        </tr>
        </tbody>
    </c:forEach>
</table>
</body>
</html>
