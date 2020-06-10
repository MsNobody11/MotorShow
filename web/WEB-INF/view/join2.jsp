<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Join2</title>

    <style>

        <%@include file='../../Designer.css' %>
        <%@include file='../../DisJoin.css' %>
    </style>

</head>
<body>
<h2><jsp:include page="menuJoin.jsp"/></h2>
<h1>Запрос 2</h1>


<p>Информация об автомобилях, цена которых выше средней</p>

<table>
    <tr>
        <th width="70">Производство</th>
        <th width="70">Марка</th>
        <th width="70">Модель</th>
        <th width="70">Тип кузова</th>
        <th width="70">Тип двигателя</th>
        <th width="70">Расположение двигателя</th>
        <th width="70">Объём двигателя</th>
        <th width="70">Тип коробки</th>
        <th width="70">Привод</th>
        <th width="70">Комплектация</th>
        <th width="70">Стоимость</th>
    </tr>
    <c:forEach items="${zapros2}" var="auto">
        <tbody>
        <tr>
            <td align="center" colspan="11">${auto}</td>
        </tr>
        </tbody>
    </c:forEach>
</table>
</body>
</html>

