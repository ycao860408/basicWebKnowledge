<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/7/5
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<form action="http://localhost:8080/09_eljstl/uploadServlet" method="post" enctype="multipart/form-data">
  username: <input type="text" name="username"/> <br/>
  headpost: <input type="file" name="photo"/> <br/>
  <input type="submit" value="上传"/>
</form>
</body>
</html>
