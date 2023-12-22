<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Show Setup Email</title>
</head>
<body>
<table>
    <tr>
        <td>Languages:</td>
        <td>${setup.language}</td>
    </tr>
    <tr>
        <td>Page Size:</td>
        <td>${setup.pageSize} email / page</td>
    </tr>
    <tr>
        <td>Enable spams filter:</td>
        <td>${setup.enableSpamsFilter ? "Yes" : "No"}</td>
    </tr>
    <tr>
        <td>Signature</td>
        <td>${setup.signature}</td>
    </tr>
</table>
<a href="/edit">Edit</a>
</body>
</html>