<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Từ điển</h1>
<h3>Tra chữ "cat", "dog", "iskiet"</h3>
<form action="/mainpage" method="post">
    <input name="word" type="text" value="${input}">
    <button type="submit">Tra cứu</button>
</form>
<h3>Kết quả : ${result}</h3>

</body>
</html>