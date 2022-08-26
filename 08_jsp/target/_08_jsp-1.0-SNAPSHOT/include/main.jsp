<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 7/4/2022
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
顶部信息<br/>
主体信息<br/>
<%--<%@ include file="/include/foot.jsp" %>--%>

<jsp:include page="/include/foot.jsp">
    <jsp:param name="username" value="pipi"/>
    <jsp:param name="password" value="12345"/>
</jsp:include>
</body>
</html>
