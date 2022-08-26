<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/7/11
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="loginServlet" method="get">
    <input type="hidden" name="action" value="login">
  username: <input type="text" name="username" value="${cookie.username.value}"/><br/>
  password: <input type="password" name="password"/><br/>
  <input type="submit" value="提交">
</form>
</body>
</html>
