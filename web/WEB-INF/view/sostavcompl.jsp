<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>������ ������������</title>

    <style>
        <%@include file='../../Designer.css' %>
        <%@include file='../../DisAll.css' %>
    </style>
</head>
<body>

<h2><jsp:include page="menu.jsp"/></h2>
<h1>������ ������������</h1>

<c:url var="addAction" value="/add_sostav"></c:url>

<form:form action="${addAction}" modelAttribute="sostavcompl" form="">
    <table>
        <c:if test="${!empty sostavcompl.kodElement}">
            <tr>
                <td>
                    <form:label path="kodElement">
                        <spring:message text="Id"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="kodElement" size="11" />
                </td>
        </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="nameelement"><spring:message text="�������"/></form:label></td>
            <td><form:input path="nameelement" required = "required" /></td>
        </tr>


        <tr>
            <td colspan="2">
                <input type="submit" class="buttonAdd" value="���������"> </td>

        </tr>
    </table>
</form:form>
<c:if test="${!empty listSostavCompl}">
    <table class="tg">
        <tr>
            <th width="50">ID</th>
            <th width="100">�������</th>
            <th width="120">�������������</th>
            <th width="100">�������</th>
        </tr>
        <c:forEach items="${listSostavCompl}" var="sostavcompl">
            <tr>
                <td>${sostavcompl.kodElement}</td>
                <td>${sostavcompl.nameelement}</td>

                <td><a href="/edit_sostav/${sostavcompl.kodElement}">�������������</a></td>
                <td><a href="/delete_sostav/${sostavcompl.kodElement}">�������</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>