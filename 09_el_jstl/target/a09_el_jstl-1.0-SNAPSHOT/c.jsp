<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/7/5
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${12== 12} 或者 ${12 eq 12} <br/>
${12 != 12} 或者 ${12 ne 12} <br/>
${12 > 12} 或者 ${12 gt 12} <br/>
${12 < 12} 或者 ${12 lt 12} <br/>
${12 <= 12} 或者 ${12 le 12} <br/>
${12 >= 12} 或者 ${12 ge 12} <br/>
<hr/>
${12 == 12 && 12 > 11} 或者 ${12 eq 12 and 12 gt 11}<br/>
${12 == 12 || 12 > 11} 或者 ${12 eq 12 or 12 gt 11}<br/>
${12 != 12 && 12 > 11} 或者 ${12 ne 12 and 12 gt 11}<br/>
<hr/>
${12 + 12}<br/>
${12 - 12} <br/>
${12 * 12} <br/>
${12 / 12} <br/>
${12 % 12} <br/>
<hr/>
<%
    request.setAttribute("emptyNull", null);
    request.setAttribute("emptyStr", "");
    request.setAttribute("emptyArr", new String[0]);
    request.setAttribute("emptyList", new ArrayList<Object>());
    request.setAttribute("emptyMap", new HashMap<String, Object>());
%>
${empty emptyNull}<br/>
${empty emptyStr}<br/>
${empty emptyArr}<br/>
${empty emptyList}<br/>
${empty emptyMap}<br/>
<hr/>
${12 == 12 ? "this is a good boy" : "this is not a good boy"}
<hr/>
<%
    Map<String, Integer> map = new HashMap<>();
    map.put("a.b.c",1);
    map.put("a+b+c", 2);
    map.put("a*b*c", 3);
    request.setAttribute("map", map);
%>

${map["a.b.c"]} <br/>
${map["a+b+c"]} <br/>
${map["a*b*c"]} <br/>
</body>
</html>
