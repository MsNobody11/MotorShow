<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Продажи</title>
    <style>
        <%@include file='../../Designer.css' %>
        <%@include file='../../DisAll.css' %>
    </style>
</head>
<body>
<h2><jsp:include page="menu.jsp"/></h2>
<h1>Продажи</h1>
<c:url var="add" value="/add_sel_auto"></c:url>

<form:form action="${add}" modelAttribute="selling_auto" form="">
    <table>
        <c:if test="${selling_auto.id!=0}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="Id"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id"  size="11" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="client"><spring:message text="Клиент"/></form:label>
            </td>
            <td>
                <form:input path="client"  required = "required" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="DateOfSale"><spring:message text="Дата покупки"/></form:label>
            </td>
            <td><form:input path="dateOfSale" required = "required" pattern="[0-9]{2}\.[0-9]{2}\.[0-9]{4}" placeholder="01.01.2000" /></td>

        </tr>
        <tr>
            <td>
                <form:label path="car"><spring:message text="Автомобиль"/></form:label></td>
            <td><form:input path="car"  required = "required" /></td>
        </tr>


        <tr>
            <td colspan="2">
                <input type="submit" class="buttonAdd" value="Сохранить"> </td>
        </tr>
    </table>
</form:form>

    <table class="tg">
        <tr>
            <th width="50">Id</th>
            <th width="50">Клиент</th>
            <th width="120">Автомобиль</th>
            <th width="120">Дата продажи</th>
            <th width="120">Редактировать</th>
            <th width="100">Удалить</th>
        </tr>
        <c:forEach items="${listSelling_auto}" var="selling_auto">
            <tr>
                <td>${selling_auto.id}</td>
                <td>${selling_auto.client}</td>
                <td>${selling_auto.car}</td>
                <td>${selling_auto.dateOfSale}</td>
                <td><a href="/edit_sel_auto/${selling_auto.id}">Редактировать</a></td>
                <td><a href="/delete_sel_auto/${selling_auto.id}">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>