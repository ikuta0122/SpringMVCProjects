<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理器方法的返回值</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn01").click(function () {
                $.ajax({
                    url: "returnVoid-ajax.do",
                    data: {
                        name: "zhangsan",
                        age: 20
                    },
                    type: "post",
                    dataType: "json",
                    //第一步:从服务器端返回的是JSON格式的字符串
                    //第二步:JQuery会把字符串转换为JSON对象
                    //第三步:JSON对象赋值给resp
                    success: function (resp) {
                        alert(resp.name + "," + resp.age);
                    }
                })
            })
            $("#btn02").click(function () {
                $.ajax({
                    url: "returnStudentJson.do",
                    data: {
                        name: "zhangsan",
                        age: 20
                    },
                    type: "post",
                    dataType: "json",
                    success: function (resp) {
                        alert(resp.name + "," + resp.age);
                    }
                })
            })
            $("#btn03").click(function () {
                $.ajax({
                    url: "returnListJson.do",
                    data: {
                        name: "zhangsan",
                        age: 20
                    },
                    type: "post",
                    dataType: "json",
                    success: function (resp) {
                        $.each(resp, function (i, n) {
                            alert(n.name + "," + n.age);
                        })
                    }
                })
            })
            $("#btn04").click(function () {
                $.ajax({
                    url: "returnString.do",
                    data: {
                        name: "zhangsan",
                        age: 20
                    },
                    type: "post",
                    dataType: "text",
                    success: function (resp) {
                        alert("文本信息:" + resp);
                    }
                })
            })
        })
    </script>
</head>
<body>
<p>处理器方法返回String表示视图名称,需要配置视图解析器</p>
<form action="returnString-view1.do" method="post">
    姓名：<input type="text" name="name"> <br/>
    年龄：<input type="text" name="age"> <br/>
    <input type="submit" value="提交参数">
</form>

<br/>
<p>处理器方法返回String表示视图完整路径,不能配置视图解析器</p>
<form action="returnString-view2.do" method="post">
    姓名：<input type="text" name="name"> <br/>
    年龄：<input type="text" name="age"> <br/>
    <input type="submit" value="提交参数">
</form>
<br/>
<button id="btn01">处理器方法返回void-发起ajax请求</button>
<br/>
<button id="btn02">处理器方法返回Object[引用类型]-发起ajax请求</button>
<br/>
<button id="btn03">处理器方法返回Object[集合数组]-发起ajax请求</button>
<br/>
<button id="btn04">处理器方法返回String-发起ajax请求</button>
</body>
</html>
