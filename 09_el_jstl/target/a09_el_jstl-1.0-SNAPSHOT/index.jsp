<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%request.setAttribute("abc", "requestData");%>
<br/>
jsp expression: <br/>
<%=request.getAttribute("abc1")%><br/>
EL Expression: <br/>
${abc1}<br/>
</body>
</html>