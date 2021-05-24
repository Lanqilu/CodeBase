<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h1>login</h1>
<div>
    <form action="${pageContext.request.contextPath}/login" method="post">
        username:<input type="text" name="username"><br>
        password:<input type="password" name="password"><br>
        hobbies:
        <input type="checkbox" name="hobbies" value="program">program
        <input type="checkbox" name="hobbies" value="game">game
        <input type="checkbox" name="hobbies" value="singing">singing

        <br>
        <input type="submit">
    </form>
</div>
</body>
</html>
