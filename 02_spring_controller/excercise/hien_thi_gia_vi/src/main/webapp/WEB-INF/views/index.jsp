<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="save" method="post">
    <input id="lettuce" type="checkbox" name="Lettuce" ${Lettuce.equals("have") ? "checked" : ""}>
    <label for="lettuce">Lettuce</label>
    <br>

    <input id="tomato" type="checkbox" name="Tomato" ${Tomato.equals("have") ? "checked" : ""}>
    <label for="tomato">Tomato</label>
    <br>

    <input id="mustard" type="checkbox" name="Mustard" ${Mustard.equals("have") ? "checked" : ""}>
    <label for="mustard">Mustard</label>
    <br>

    <input id="sprouts" type="checkbox" name="Sprouts" ${Sprouts.equals("have") ? "checked" : ""}>
    <label for="sprouts">Sprouts</label>
    <br>

    <button type="submit">save</button>
</form>
<h3>${result}</h3>
</body>
</html>