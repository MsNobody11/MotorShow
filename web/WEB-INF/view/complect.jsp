<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Complect</title>
    <style>
        <%@include file='../../Designer.css' %>
        <%@include file='../../DisAll.css' %>
    </style>
</head>
<body>
<h2><jsp:include page="menu.jsp"/></h2>
<h1>Комплектация</h1>
<c:url var="addC" value="/add_compl"></c:url>

<form:form action="${addC}" modelAttribute="complect" form="">
    <table>
        <c:if test="${!empty complect.kodCompl}">
            <tr>
                <td>
                    <form:label path="kodCompl"><spring:message text="Id"/></form:label>
                </td>
                <td>
                    <form:input path="kodCompl" size="11" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name"><spring:message text="Комплектация"/></form:label></td>
            <td><form:input path="name" required = "required"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="sostav"><spring:message text="Состав"/></form:label></td>
            <td>
                <form:input path="sostav" required = "required" />
            </td>
        </tr>


        <tr>
            <td colspan="2">
                <input type="submit" class="buttonAdd" value="Сохранить"> </td>
        </tr>
    </table>
</form:form>
<c:if test="${!empty listComplect}">
    <table class="tg">
        <tr>
            <th width="50">Id</th>
            <th width="120">Комплектация</th>
            <th width="100">Состав</th>
            <th width="120">Редактировать</th>
            <th width="100">Удалить</th>
        </tr>
        <c:forEach items="${listComplect}" var="complect">
            <tr>
                <td>${complect.kodCompl}</td>
                <td>${complect.name}</td>
                <td>${complect.sostav}</td>

                <td><a href="/edit_compl/${complect.kodCompl}">Редактировать</a></td>
                <td><a href="/delete_compl/${complect.kodCompl}">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>