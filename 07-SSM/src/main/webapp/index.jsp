<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>SSM整合--功能入口</title>
    <base href="<%=basePath%>"/>
</head>
<body>
<div align="center">
    <table>
        <tr>
            <td><a href="show/addStudent.jsp"> 注册学生</a></td>
        </tr>
        <tr>
            <td><a href="show/listStudent.jsp">浏览学生</a></td>
        </tr>
    </table>
</div>
</body>
</html>
