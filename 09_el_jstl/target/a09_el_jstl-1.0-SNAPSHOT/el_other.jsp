<%--
  Created by IntelliJ IDEA.
  User: tiger
  Date: 2022/7/5
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el_other</title>
</head>
<body>
username: ${param.username} <br/>
password: ${param.password} <br/>
hobby[0]: ${paramValues.hobby[0]} <br/>
hobby[1]: ${paramValues.hobby[1]} <br/>

<hr/>
Accept in the Header: ${header.accept} <br/>
User-Agent in the Header: ${header["user-Agent"]} <br/>
Host in the Header: ${headerValues.host[0]} <br/>

<hr/>

Cookie's value: ${cookie.JSESSIONID.value} <br/>
Context_Param: ${initParam.username} <br/>
Context_Param: ${initParam.password} <br/>
</body>
</html>
