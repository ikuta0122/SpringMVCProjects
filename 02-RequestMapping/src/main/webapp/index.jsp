<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>@RequestMapping的使用</title>
</head>
<body>
    <p><a href="/user/some.do.do">发起some.do的get请求</a></p>
    <br/>
    <form action="user/other.do" method="post">
        <input type="submit" value="发起other.do的post请求">
    </form>
</body>
</html>
