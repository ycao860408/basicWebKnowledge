<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/7/12
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>权限错误页面</title>
  <%@ include file="/pages/commons/head.jsp"%>
  <style type="text/css">
    h1 {
      text-align: center;
      margin-top: 200px;
    }
  </style>
</head>
<body>

<div id="header">
  <img class="logo_img" alt="" src="static/img/logo.gif" >
  <span class="wel_word">权限不足</span>
</div>

<div id="main">

  <h1>您不具备访问后台的权限，欢迎您前往<a href="index.jsp" style="color: red">主页</a>继续购物</h1>
</div>
<%@ include file="/pages/commons/footer.jsp"%>
</body>
</html>