<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <title>Sign In</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>SignIn</h2>

<form action="/signIn" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="email" name="email" placeholder="Email">
    <input type="password" name="password" placeholder="Password">
    <label>
        <input type="checkbox" name="rememberMe"> Запомни меня
    </label>
    <input type="submit" value="Sign In">
</form>
</body>
</html>