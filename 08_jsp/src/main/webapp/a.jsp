<%@ page import="java.util.Map" %>
<%@ page import="com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 7/4/2022
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/error500.jsp" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
Hello World!
<%--<%
    int i = 12 / 0;
%>--%>

<%!
    int i = 1;
    static Map<String, Integer> map;
    public void abc() {
        System.out.println("This is a good boy!");
    }

    static {
        map = new HashMap<>();
        map.put("k1", 1);
        map.put("k2", 2);
        map.put("k3", 3);
    }

    public  static class  A {
        private int age;
        private String name;
        private static int classNo;
    }
%>
<br/>
<%=12.12 %>
<br/>
<%="abc.abc"%>
<br/>
<%=map%>
<br/>
<%=request.getParameter("username")%>

<%
    int i = 12;
    if (i == 12) {
        System.out.println("You are a good boy!");
    } else {
        System.out.println("You are not a good boy!");
    }

    for (int k = 0; k < 4; k++) {
        System.out.println("k = " + k + " and the user name is: " + request.getParameter("username"));
    }
%>
<%
    for (int j = 0; j < 10; j++) {
%>
    <div>This is the <%=j + 1%>th div.</div>
<%
    }
%>
</body>
</html>
