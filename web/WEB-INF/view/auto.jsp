<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>����������</title>

    <style>

        <%@include file='../../Designer.css' %>
        <%@include file='../../DisAuto.css' %>
    </style>
</head>
<body>
<h2><jsp:include page="menu.jsp"/></h2>
<h1>����������</h1>

<%--@elvariable id="auto" type="com.Salon.Auto"--%>

<c:url var="addA" value="/add_auto"></c:url>

<form:form action="${addA}" modelAttribute="auto" form="">
    <table>
        <c:if test="${!empty auto.id_auto}">
            <tr>
                <td>
                    <form:label path="id_auto">
                        <spring:message text="Id"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id_auto"  size="11" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="manufacturer">
                    <spring:message text="������-�������������"/>
                </form:label>
            </td>
            <td>
                <form:input path="manufacturer" type = "text" required = "required" pattern="^[�-��-���\s]+$" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="marka">
                    <spring:message text="�����"/>
                </form:label>
            </td>
            <td>
                <form:input path="marka" type = "text" required = "required" pattern="^[A-Za-z�-��-���\s]+$" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="model">
                    <spring:message text="������"/>
                </form:label>
            </td>
            <td>
                <form:input path="model" type = "text" required = "required" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="typeBody">
                    <spring:message text="��� ������"/>
                </form:label>
            </td>
            <td>
                <form:input path="typeBody" type = "text" required = "required" pattern="^[�-��-���\s]+$" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="typeDvigatel">
                    <spring:message text="��� ���������"/>
                </form:label>
            </td>
            <td>
                <form:input path="typeDvigatel" type = "text" required = "required" pattern="^[�-��-���\s]+$" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="raspDvig">
                    <spring:message text="������������ ���������"/>
                </form:label>
            </td>
            <td>
                <form:input path="raspDvig" type = "text" required = "required" pattern="^[�-��-���\s]+$" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="obDvig">
                    <spring:message text="����� ���������"/>
                </form:label>
            </td>
            <td><form:input path="obDvig" type = "text" required = "required" pattern="\d+(,\d)?"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="typeBox">
                    <spring:message text="��� ������� �������"/>
                </form:label>
            </td>
            <td>
                <form:input path="typeBox" type = "text" required = "required" pattern="^[�-��-���]+$" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="typePrivod">
                    <spring:message text="��� �������"/>
                </form:label>
            </td>
            <td>
                <form:input path="typePrivod" type = "text" required = "required" pattern="^[�-��-���]+$" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="compl">
                    <spring:message text="������������"/>
                </form:label>
            </td>
            <td>
                <form:input path="compl" required = "required" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="���������" />
                </form:label>
            </td>
            <td>
                <form:input path="price" type = "text" required = "required" pattern="[0-9]{6,10}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${auto.id_auto!=0}">
                    <input type="submit" class="buttonAdd" value="���������"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>



<%--@elvariable id="listAuto" type="com.DAO.AutoDAO"--%>

<table class="tg">
    <tr>
        <th width="50">Id</th>
        <th width="100">������-�������������</th>
        <th width="80">�����</th>
        <th width="80">������</th>
        <th width="100">��� ������</th>
        <th width="100">��� ���������</th>
        <th width="110">������������ ���������</th>
        <th width="130">����� ���������</th>
        <th width="90">��� ������� �������</th>
        <th width="100">��� �������</th>
        <th width="100">������������</th>
        <th width="100">���������</th>
        <th width="120">�������������</th>
        <th width="100">�������</th>
    </tr>

    <c:forEach items="${listAuto}" var="auto">
        <tr>
            <td>${auto.id_auto}</td>
            <td>${auto.manufacturer}</td>
            <td>${auto.marka}</td>
            <td>${auto.model}</td>
            <td>${auto.typeBody}</td>
            <td>${auto.typeDvigatel}</td>
            <td>${auto.raspDvig}</td>
            <td>${auto.obDvig}</td>
            <td>${auto.typeBox}</td>
            <td>${auto.typePrivod}</td>
            <td>${auto.compl}</td>
            <td>${auto.price}</td>
            <td><a href="/edit_auto/${auto.id_auto}">�������������</a></td>
            <td><a href="/delete_auto/${auto.id_auto}">�������</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>