<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" %>


<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>

    <style>

        <%@include file='../../DisWelcome.css' %>

    </style>

</head>
<body>
<h1>Автосалон</h1>
    <table>
        <tr>
            <td class="one">
               <a class="two" href="/selling/">Клиенты</a>
            </td>
            <td>
                <a  href="/selling_auto/">Продажи</a>
            </td>
            <td class="one">
                <a class="two" href="/auto/">Автомобили</a>
            </td>
            <td>
                <a href="/complect/">Комплектация</a>
            </td>
            <td class="one">
                <a class="two" href="/sostavcompl/">Состав комплектации</a>
            </td>
        </tr>
        <tr>
            <td>
                <a href="/join1/">Запрос 1</a>
            </td>
            <td class="one">

            </td>
            <td>
                <a  href="/join2/">Запрос 2</a>
            </td>
            <td class="one">

            </td>
            <td>
                <a  href="/join3/">Запрос 3</a>
            </td>
        </tr>
    </table>





</body>

</html>