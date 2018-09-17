#手写springMVC框架
##1、首先定义自定义注解  annotation  注意运行的范围
##2、按照正常业务逻辑编写service和实现类
##3、编写controller层，注解用自己定义的注解
    @JztController、
    @JztRequestMapping("/jzt")、 
    @JztAutowired("JztMvcServiceImpl")、
    @JztRequestMapping("/query")、  
    @JztRequestParam("name")
    注意@JztAutowired后面带上的JztMvcServiceImpl实际上就是实现类名字，到时候作为key值
   
##4、编写   DispatchServlet  ，继承HttpServlet
   `注意要在web.xml文件中注入这个类进去，保证开始容器加载的时候可以进行初始化`
   
    <servlet>
         <servlet-name>DispatchServlet</servlet-name>
         <servlet-class>com.jzt.ys.servlet.DispatchServlet</servlet-class>
         <load-on-startup>0</load-on-startup>
     </servlet>
   
      	
   	<servlet-mapping> 
   		<servlet-name>DispatchServlet</servlet-name>
   		<url-pattern>/*</url-pattern>
   	</servlet-mapping>
   	
   	
 ##5、DispatchServlet中init主要有4个方法
      `doScan("com.jzt");  // 扫描com.jzt下面所有的包下面文件，可能出现文件或者文件夹      
      doInstance();// 得到 com/jzt/ys/controller/OrdersService.class-->进行实例化newInstance()   	
   	  doAutowired();// 注入对象 IOC控制反转
   	  urlMapping();// 路径和方法的对应，将方法和对应的路径进行关联`