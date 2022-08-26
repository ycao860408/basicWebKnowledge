<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/7/5
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageContext</title>
</head>
<body>
<%
    pageContext.setAttribute("req", request);
%>
<%=request.getScheme()%><br/>
protocol: ${req.scheme}<br/>
protocol: ${pageContext.request.scheme} <br/>
server ip：${pageContext.request.serverName} <br/>
server port: ${pageContext.request.serverPort} <br/>
project path: ${pageContext.request.contextPath} <br/>
request method: ${pageContext.request.method} <br/>
client ip：${pageContext.request.remoteHost} <br/>
session id：${pageContext.session.id} <br/>
</body>
</html>
