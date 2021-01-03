<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模拟退出</title>
</head>
<body>
    模拟退出,从session中删除数据
    <%
        session.removeAttribute("name");
    %>
</body>
</html>
