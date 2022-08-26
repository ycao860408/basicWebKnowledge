<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 7/4/2022
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
pageContext => <%=pageContext.getAttribute("key")%><br/>
request => <%=request.getAttribute("key")%><br/>
session => <%=session.getAttribute("key")%><br/>
application => <%=application.getAttribute("key")%>
</body>
</html>
