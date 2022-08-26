<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 7/4/2022
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test1</title>
    <style  type="text/css">
        table {
            width:750px;
            border: 0px solid red;
            border-collapse: collapse;
        }

        th, td {
            border: 0px solid red;
        }
    </style>
</head>
<body>
<h1 align="center">九九乘法表</h1>
<table align="center">
<%
    for (int i = 1; i <= 9; i++) {
%>
    <tr>
    <%
        for (int j = 1; j <= i; j++) {
    %>
        <td><%=i%> &times; <%=j%> = <%=i * j%> </td>
    <%
        }
    %>
    </tr>
<%
    }
%>
</table>
</body>
</html>
