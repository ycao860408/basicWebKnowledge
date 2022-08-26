<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 7/4/2022
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>scope1</title>
</head>
<body>
<h1>scope1.jsp</h1>
<%
  pageContext.setAttribute("key", "pageContext");
  request.setAttribute("key", "request");
  session.setAttribute("key", "session");
  application.setAttribute("key", "application");
%>

pageContext => <%=pageContext.getAttribute("key")%><br/>
request => <%=request.getAttribute("key")%><br/>
session => <%=session.getAttribute("key")%><br/>
application => <%=application.getAttribute("key")%>

<%--<%
    request.getRequestDispatcher("/scope2.jsp").forward(request, response);
%>--%>

<jsp:forward page="/scope2.jsp"></jsp:forward>
</body>
</html>
