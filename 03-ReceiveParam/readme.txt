03-ReceiveParam[接收请求参数]
接收请求参数，使用的处理器方法的形参
1.HttpServletRequest
2.HttpServletResponse
3.HttpSession
4.用户提交的请求参数
    1)逐个接收请求参数
    2)对象接收请求参数

注意1:使用get方式提交请求,中文没有乱码
注意2:使用post方式提交请求,中文有乱码,需要使用过滤器处理乱码的问题
    *过滤器可以自定义
    *过滤器可以使用使用SpringMVC框架提供的CharacterEncodingFilter