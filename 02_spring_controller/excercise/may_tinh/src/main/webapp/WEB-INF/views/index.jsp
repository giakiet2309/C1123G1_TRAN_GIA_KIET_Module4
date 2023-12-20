<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Máy tính</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculator" method="post">
    <input name="number1" type="number" value="${number1}">
    <input name="number2" type="number" value="${number2}">
    <button type="submit" id="submit" style="display: none"></button>
    <input id="action" name="action" type="hidden">
    <br>
</form>
<button type="button" onclick="calculator(1)">Addition(+)</button>
<button type="button" onclick="calculator(2)">Subtraction(-)</button>
<button type="button" onclick="calculator(3)">Multiplication(X)</button>
<button type="button" onclick="calculator(4)">Division(/)</button>
<h3>${result}</h3>
</body>
<script>
    function calculator(action){
        switch (action){
            case 1:
                document.getElementById("action").value = 1;
                break;
            case 2:
                document.getElementById("action").value = 2;
                break;
            case 3:
                document.getElementById("action").value = 3;
                break;
            case 4:
                document.getElementById("action").value = 4;
                break;
        }
        document.getElementById("submit").click();
    }
</script>
</html>