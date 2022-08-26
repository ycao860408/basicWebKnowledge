<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/7/5
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>same key</title>
</head>
<body>
<%
    pageContext.setAttribute("k", "page data");
    request.setAttribute("k", "request data");
    session.setAttribute("k", "session data");
    application.setAttribute("k", "application data");
%>
same key in four fields! <br/>
${k}
</body>
</html>
