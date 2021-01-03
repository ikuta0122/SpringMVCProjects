12-Interceptor-Permission[登陆验证拦截器]
使用拦截器检查登录的用户是不是能访问系统

实现步骤：
1.新建maven
2.修改web.xml注册中央调度器
3.新建index.jsp发起请求
4.创建MyController处理请求
5.创建结果show.jsp
6.创建login.jsp模拟登录系统[将用户信息放入session]
  创建logout.jsp模拟退出系统[从session中删除用户信息]
  注意:通过浏览login.jsp和logout.jsp来模拟登录登出
7.创建拦截器，从session中获取用户的登录数据，验证能否访问系统
8.创建一个验证的jsp，如果验证视图，给出提示
9.创建SpringMVC配置文件
  声明组件扫描器
  声明拦截器