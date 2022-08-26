<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/7/5
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();
    person.setId(2);
    person.setPhones(new String[]{"12345", "13456", "1987232"});
    List<String> cities = new ArrayList<>();
    cities.add("Boston");
    cities.add("New York");
    cities.add("Chicago");
    person.setCities(cities);
    Map<String, Object> map = new HashMap<>();

    map.put("k1", "v1");
    map.put("k2", "v2");
    map.put("k3", "v3");

    person.setMap(map);
    request.setAttribute("p", person);
%>
输出person对象: ${p} <br/>
输出person.id的值：${p.id} <br/>
输出person.phones的值: ${p.phones} <br/>
输出person.phones[0]的值： ${p.phones[0]}<br/>
输出person.phones[1]的值： ${p.phones[1]}<br/>
输出person.phones[2]的值： ${p.phones[2]}<br/>
输出person.city的值： ${p.cities} <br/>
输出person.city[0]的值： ${p.cities[0]}<br/>
输出person.city[1]的值： ${p.cities[1]}<br/>
输出person.city[2]的值： ${p.cities[2]}<br/>
输出person.map的值： ${p.map} <br/>
输出person.map.k1的值：${p.map.k1} <br/>
输出person.map.k2的值：${p.map.k2} <br/>
输出person.map.k3的值：${p.map.k3} <br/>


</body>
</html>
