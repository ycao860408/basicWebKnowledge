<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/7/11
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/repeatSubmit/registServlet" method="post">
  用户名: <input type="text" name="username"/> <br/>
    验证码： <input type="text" name="code"/>
    <img src="http://localhost:8080/repeatSubmit/kaptcha.jpg" style="width: 80px; height: 28px"/>
  <input type="submit" value="注册"/>
</form>
</body>
</html>
