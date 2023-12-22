<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: quoct
  Date: 9/14/2023
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Setup</title>
</head>
<body>
<form:form method="post" action="edit" modelAttribute="setup">
    <table>
        <tr>
            <td><form:label path="language">Language:</form:label></td>
            <td><form:select path="language">
                <form:option value="English">English</form:option>
                <form:option value="Vietnamese">Vietnamese</form:option>
                <form:option value="Japanese">Japanese</form:option>
                <form:option value="Chinese">Chinese</form:option>
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size:</form:label></td>
            <td><form:select path="pageSize">
                <form:option value="5">5</form:option>
                <form:option value="10">10</form:option>
                <form:option value="15">15</form:option>
                <form:option value="25">25</form:option>
                <form:option value="50">50</form:option>
                <form:option value="100">100</form:option>
            </form:select> emails per page</td>
        </tr>
        <tr>
            <td><form:label path="enableSpamsFilter">Enable spams filter:</form:label></td>
            <td><form:checkbox path="enableSpamsFilter" th:checked="${setup.enableSpamsFilter}"></form:checkbox></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:textarea path="signature" value="${setup.signature}"/></td>
        </tr>
    </table>
    <button type="submit">submit</button>
</form:form>
</body>
</html>
