<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>/result.jsp从request作用域获取数据</h3>
    <h3>myname数据：${param.myname}</h3>
    <h3>相当于<%=request.getParameter("myname")%></h3>
    <h3>myage数据：${param.myage}</h3>
    <h3>相当于<%=request.getParameter("myage")%></h3>
</body>
</html>
