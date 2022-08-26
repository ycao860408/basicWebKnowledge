<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/7/5
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
before storing information: ${requestScope.abc}<br/>
<c:set scope="request" var="abc" value="123"></c:set>
after storing information: ${requestScope.abc}<br/>
<hr/>
<c:if test="${12 == 12}">
    <h1>This is a good boy!</h1>
</c:if>

<hr/>

<%
    request.setAttribute("height", 198);
%>

<c:choose>
    <c:when test="${requestScope.height > 190}">
        Giant Guy
    </c:when>
    <c:when test="${requestScope.height > 180}">
        Tall Guy
    </c:when>
    <c:when test="${requestScope.height > 170}">
        Normal Guy
    </c:when>
    <c:otherwise>
        Short Guy
    </c:otherwise>
</c:choose>
</body>
</html>
