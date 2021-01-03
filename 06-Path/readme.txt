06-Path[相对路径和绝对路径]:解决jsp页面中的路径问题,用 "/" 还是不用
结论:前端不加,后端要加
情况1:不加"/"
    http://localhost:8080/06_Path_war_exploded/user/some.do
    服务器地址+项目访问地址+请求资源地址
    缺点: 在index.jsp页面中访问some.do时,
          访问路径为http://localhost:8080/06_Path_war_exploded/user/user/some.do
          请求路径错误导致无法正常访问
情况2:加入"/"
    http://localhost:8080/user/some.do
    服务器地址+请求资源地址
    缺点:请求路径错误导致无法正常访问

解决方法:
    1)加入EL表达式:${pageContext.request.contextPath}
        <a href="${pageContext.request.contextPath}/user/some.do">
    2)加入base标签[当前页面中访问地址的基地址]
        页面中所有不以“/”开头的地址，都以base标签中的地址做为参考地址
        <%
            String basePath = request.getScheme() + "://" +
                    request.getServerName() + ":" + request.getServerPort() +
                    request.getContextPath() + "/";
        %>