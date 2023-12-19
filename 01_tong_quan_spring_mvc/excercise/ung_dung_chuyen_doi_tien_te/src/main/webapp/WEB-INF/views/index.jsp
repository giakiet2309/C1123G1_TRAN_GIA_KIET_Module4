<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
</head>
<body>
<form action="mainpage" method="post">
    <select name="changeTo">
        <option ${"VND to USD".equals(change) ? "selected" : ""}>VND to USD</option>
        <option ${"USD to VND".equals(change) ? "selected" : ""}>USD to VND</option>
    </select>
    <input name="currency" type="number" value="${input}">
    <button type="submit">change</button>

    <h3>Kết quả : ${result}</h3>
</form>
</body>
</html>