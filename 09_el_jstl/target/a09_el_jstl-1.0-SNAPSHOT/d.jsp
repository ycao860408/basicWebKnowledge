<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/7/5
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL Hidden Variables</title>
</head>
<body>
<%
    pageContext.setAttribute("k", "page data");
    request.setAttribute("k", "request data");
    session.setAttribute("k", "session data");
    application.setAttribute("k", "application data");
%>
same key in four fields! ${k} <br/>
the key in the pageContext: ${pageScope.k}<br/>
the key in the request：${requestScope.k} <br/>
the key in the session: ${sessionScope.k} <br/>
the key in the application: ${applicationScope.k} <br/>

</body>
</html>
