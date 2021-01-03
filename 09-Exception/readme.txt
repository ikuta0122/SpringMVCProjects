09-ExceptionHandler[异常处理]

异常处理步骤：
1.新建maven web项目
2.加入依赖
3.新建自定义异常类MyUserException及其子类NameException,AgeException
4.在处理器方法中抛出NameException , AgeException
5.创建一个普通类,作为全局异常处理类
  1)在类的上面加入@ControllerAdvice
  2)在类中定义方法,方法的上面加入@ExceptionHandler
6.创建处理异常的视图页面
7.创建SpringMVC的配置文件
 1)组件扫描器1:扫描@Controller注解所在的包名
 2)组件扫描器2:扫描@ControllerAdvice注解所在的包名
 3)声明注解驱动