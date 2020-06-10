<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Клиенты</title>

    <style>
        <%@include file='../../Designer.css' %>
        <%@include file='../../DisAll.css' %>
    </style>
</head>

<body>
<h2><jsp:include page="menu.jsp"/></h2>
<h1>Клиенты</h1>



<c:url var="addAction" value="/add"></c:url>

<%--@elvariable id="selling" type="com.Salon.Selling"--%>
<form:form action="${addAction}" modelAttribute="selling" form="">
    <table>
        <c:if test="${selling.id!=0}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="Id"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" size="11" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="pasport">
                    <spring:message text="Паспорт"/>
                </form:label></td>
            <td><form:input path="pasport" required = "required" pattern ="[0-9]{4}-[0-9]{6}" placeholder="1234-567890" /></td>
        </tr>
        <tr>
            <td>
                <form:label path="FIO"><spring:message text="ФИО"/></form:label>
            </td>
            <td><form:input path="FIO" type = "text" required = "required" pattern = "[A-Za-zА-Яа-яЁё\s]+$" placeholder="Иванов Иван Иванович"/></td>

        </tr>
        <tr>
            <td>
                <form:label path="DateOfBirth"><spring:message text="Дата рождения"/></form:label>
            </td>
            <td><form:input path="dateOfBirth" required = "required" pattern="[0-9]{2}\.[0-9]{2}\.[0-9]{4}" placeholder="01.01.2000" /></td>

        </tr>
        <tr>
            <td>
                <form:label path="address"><spring:message text="Адрес"/></form:label>
            </td>
            <td><form:input path="address" required = "required" placeholder="г.Москва, ул.Лубянка, 8"/></td>

        </tr>
        <tr>
            <td>
                <form:label path="telef"><spring:message text="Телефон"/></form:label></td>
            <td><form:input path="telef" required = "required"  pattern = "[0-9]{8,11}" placeholder="81234567890" /></td>

        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty selling.id}">
                <input type="submit" class="buttonAdd" value="Сохранить"> </td>
            </c:if>
        </tr>
    </table>
</form:form>

<c:if test="${!empty listSelling}">

    <table class="tg">
    <tr>
        <th width="50">ID</th>
        <th width="100">Паспорт</th>
        <th width="120">ФИО</th>
        <th width="120">Дата рождения</th>
        <th width="100">Адрес</th>
        <th width="100">Телефон</th>
        <th width="120">Редактировать</th>
        <th width="100">Удалить</th>
    </tr>
    <c:forEach items="${listSelling}" var="selling">
        <tr>
            <td width="50">${selling.id}</td>
            <td  width="100">${selling.pasport}</td>
            <td  width="120">${selling.FIO}</td>
            <td  width="100">${selling.dateOfBirth}</td>
            <td  width="100">${selling.address}</td>
            <td  width="100">${selling.telef}</td>
            <td  width="120"><a href="/edit/${selling.id}">Редактировать</a></td>
            <td  width="100"><a href="/delete/${selling.id}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
</c:if>

</body>
</html>