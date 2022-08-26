<%@ page import="java.util.ArrayList" %>
<%@ page import="com.atguigu.jsp.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 7/4/2022
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test2</title>
    <style type="text/css">
        table {
            width:750px;
            border: 1px solid red;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid red;
        }
    </style>
</head>
<body>
    <%
        List<Student> sts = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            sts.add(new Student(i + 1, "name" + i, "134phone" + i, Math.random() > 0.5 ? 1 : 0));
        }
    %>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>PhoneNumber</th>
        <th>Gender</th>
        <th>Operations</th>
    </tr>
    <% for (int i = 0; i < sts.size(); i++) {
        Student cur = sts.get(i);
    %>
    <tr>
        <td><%=cur.getId()%></td>
        <td><%=cur.getName()%></td>
        <td><%=cur.getPhoneNumber()%></td>
        <td><%=cur.getGender()==1 ? "Male" : "Female"%></td>
        <td>Delete/Update</td>
    </tr>
    <%}%>
</table>
</body>
</html>
