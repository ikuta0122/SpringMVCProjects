<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理器方法的参数</title>
</head>
<body>
    <p>提交参数给Controller</p>
    <form action="receiveproperty.do" method="post">
        姓名：<input type="text" name="name"> <br/>
        年龄：<input type="text" name="age"> <br/>
        <input type="submit" value="提交参数">
    </form>

    <br/>
    <p>处理器方法形参名和请求参数名不一致</p>
    <form action="receiveparam.do" method="post">
        姓名：<input type="text" name="othername"> <br/>
        年龄：<input type="text" name="otherage"> <br/>
        <input type="submit" value="提交参数">
    </form>

    <br/>
    <p>使用java对象接收请求参数</p>
    <form action="receiveobject.do" method="post">
        姓名：<input type="text" name="name"> <br/>
        年龄：<input type="text" name="age"> <br/>
        <input type="submit" value="提交参数">
    </form>
</body>
</html>
