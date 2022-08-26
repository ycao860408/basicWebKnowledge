<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/7/5
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>foreach</title>
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
<c:forEach var="i" begin="1" end="10">
    ${i}
</c:forEach>
<%
    request.setAttribute("phone", new String[]{"12345", "34567","132456","789690"});
%>
<hr/>
<c:forEach items="${requestScope.phone}" var="item">
    ${item}
</c:forEach>
<hr/>
<%
    Map<String, Object> map = new HashMap<>();
    map.put("k1", "v1");
    map.put("k2", "v2");
    map.put("k3", "v3");
    request.setAttribute("map", map);
%>
<c:forEach items="${requestScope.map}" var="entry">
    ${entry.key} <=>${entry.value}
</c:forEach>
<br/>
<%
    List<Student> sts = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
        sts.add(new Student(i, "name" + i, Math.random() > .5 ? 1 : 0, 18 + i, "phoneNum" + i));
    }
    request.setAttribute("sts", sts);
%>
<h1 align="center">Student Table</h1>
<table align="center">
    <tr>
        <th>Id</th>
        <th>name</th>
        <th>age</th>
        <th>gender</th>
        <th>phoneNumber</th>
        <th>operations</th>
    </tr>
    <c:forEach items="${requestScope.sts}" var="st">
        <tr>
            <td>${st.id}</td>
            <td>${st.name}</td>
            <td>${st.age}</td>
            <td>${st.gender== 1? "male" : "female"}</td>
            <td>${st.phoneNum}</td>
            <td>delete/update</td>
        </tr>
    </c:forEach>
</table>



</body>
</html>
