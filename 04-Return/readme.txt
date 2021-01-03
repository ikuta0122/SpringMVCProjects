5.处理器方法的返回值
	5.1	ModelAndView[数据和视图]
		1)适用场景:既资源跳转,又传递数据
		2)注意:
			只资源跳转而不传递数据,则Model多余
			只传递数据而不资源跳转,则View多余
	
	5.2	String[视图]
		1)适用场景:资源跳转
		2)返回值及其使用方式
			*逻辑视图名称--->需要配置视图解析器
			*完整视图路径--->不能配置视图解析器
		3)可以通过手动添加数据到request作用域,实现传递数据
	
	5.3	void
		1)适用场景:处理AJAX
		2)注意:
			后端控制器通过HttpServletReponse输出数据,响应AJAX请求
			AJAX请求服务器端放回的就是数据,和视图无关
	
	5.4	Object对象[数据]
		1)适用场景:传递数据
		2)实现步骤:加入依赖--->声明注解驱动--->加入 @ResponseBody注解

	5.5	注意事项:处理器方法的返回值类型为String
		1)使用 @ResponseBody 注解,返回值为数据
			*默认
		2)没有 @ResponseBody 注解,返回值为视图
	
6.	@ResponseBody
	6.1	作用:将JSON格式的字符串通过HttpServletResponse接口响应给浏览器
			PrintWriter out  = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
	6.2	位置:处理器方法的上面

7.使用JSON响应AJAX的实现步骤
	7.1	在pom.xml中,加入JSON工具库的依赖[SpringMVC默认使用的jackson]
	7.2	在SpringMVC配置文件中,声明<mvc:annotation-driven>注解驱动
			String json = "";
			json  = om.writeValueAsString(student);
	7.3	在处理器方法上加入 @ResponseBody注解
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out  = response.getWriter();
			out.println(json);

8.SpringMVC框架返回对象的处理过程
	8.1	SpringMVC框架调用ArrayList<HttpMessageConverter>中每一个实现类的canWrite()方法
			*检查能够处理[该引用类型数据]的[HttpMessageConverter接口的实现类]
	
	8.2	SpringMVC框架调用步骤1得到的HttpMessageConverter接口的实现类的Write()方法
			*将该引用类型数据转换为[JSON格式的字符串]
			*contentType: application/json;charset=utf-8
	
	8.3	SpringMVC框架调用 @ResponseBody注解
			*将[JSON格式的字符串]响应给浏览器,完成AJAX请求

	   springmvc处理器方法返回Object， 可以转为json输出到浏览器，响应ajax的内部原理

9.关于<mvc:annotation-driven> 注解驱动
	9.1	功能:将JAVA对象转换为json,xml,text,二进制等数据格式
	9.2	原理
			1)声明注解驱动后,SpringMVC框架自动创建HttpMessageConverter接口的7个实现类对象
			2)通过调用实现类对象的canWrite()方法和write()方法,完成数据格式的转换