<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>@RequestMapping的使用</title>
    <base href="<%=basePath%>" />
</head>
<body>
    <p><a href="user/some.do">发起user/some.do的get请求</a></p>
</body>
</html>
