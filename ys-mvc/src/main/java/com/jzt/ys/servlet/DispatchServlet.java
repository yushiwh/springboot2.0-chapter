/**
 * Copyright (C), 2018-2020, 998电商集团 FileName: DispatchServlet Author: yushi Date: 2018/9/14 9:34 Description: History:
 * <author> <time> <version> <desc> 作者姓名 修改时间 版本号 描述
 */
package com.jzt.ys.servlet;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzt.ys.annotation.JztAutowired;
import com.jzt.ys.annotation.JztController;
import com.jzt.ys.annotation.JztRequestMapping;
import com.jzt.ys.annotation.JztRequestParam;
import com.jzt.ys.annotation.JztService;
import com.jzt.ys.controller.JztMvcController;


/**
 * 关键的HttpServlet，配置到web容器里面，加载的时候，spring就会加载<br>
 * 〈〉
 *
 * @author yushi
 * @create 2018/9/14
 * @since 1.0.0
 */
public class DispatchServlet extends HttpServlet {

    List<String> classNames = new ArrayList<String>();

    Map<String, Object> beans = new HashMap<String, Object>();

    Map<String, Object> handerMap = new HashMap<String, Object>();

    /**
     * 初始化 tomcat启动的时候，要执行的类容 创建java map autowired等操作
     */
    @Override
    public void init(ServletConfig config) {

        // 扫描com.ys.controller类
        doScan("com.jzt");

        // 得到 com/ys/controller/OrdersService.class-->进行实例化newInstance()
        doInstance();

        doAutowired();// 注入

        urlMapping();// 路径和方法的对应

    }

    /**
     * 路径和方法对应
     */

    private void urlMapping() {
        // 将得到的bean进行循环
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Object instance = entry.getValue();// 得到map放入里面对象
            Class<?> clazz = instance.getClass();
            if (clazz.isAnnotationPresent(JztController.class)) {// 是控制层
                JztRequestMapping reqMapping = clazz.getAnnotation(JztRequestMapping.class);// 拿到类路径
                String classPath = reqMapping.value();// 得到/jzt

                Method[] methods = clazz.getMethods();// 得到所有方法
                for (Method method : methods) {
                    if (method.isAnnotationPresent(JztRequestMapping.class)) {// 是否方法上面有注解
                        JztRequestMapping reqMapp = method.getAnnotation(JztRequestMapping.class);// 拿到方法路径
                        String methodPath = reqMapp.value();// 得到/query

                        // 有效路径
                        handerMap.put(classPath + methodPath, method);/// 放入的是 jzt/query, query方法
                    } else {
                        continue;
                    }
                }

            } else {
                continue;
            }
        }
    }

    /**
     * 注入方法
     */

    private void doAutowired() {
        // 将得到的bean进行循环
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Object instance = entry.getValue();// 得到map放入里面对象
            Class<?> clazz = instance.getClass();

            if (clazz.isAnnotationPresent(JztController.class)) {// 是控制层
                Field[] fileds = clazz.getDeclaredFields();// 拿到所有的成员变量
                for (Field field : fileds) {
                    if (field.isAnnotationPresent(JztAutowired.class)) {// 判断是否是注入的注解
                        JztAutowired auto = field.getAnnotation(JztAutowired.class);// 得到JztAutowired对象
                        String key = auto.value();// 注解里面的key --》 @JztAutowired("JztMvcServiceImpl")中的JztMvcServiceImpl

                        Object value = beans.get(key);// 得到service对象，下面实例化的时候put进去的

                        field.setAccessible(true);// 因为成员变量是私有，只有重新授权

                        try {
                            field.set(instance, value);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }

            }

        }
    }

    /**
     * 实例化
     */
    private void doInstance() {
        for (String className : classNames) {
            // 去掉.class
            String cn = className.replace(".class", "");// 得到 com/ys/controller/OrdersService
            try {
                Class<?> clazz = Class.forName(cn);// 反射 得到Class类对象
                if (clazz.isAnnotationPresent(JztController.class)) {// 判断是否controller类
                    Object value = clazz.newInstance();// 实例化对象
                    // map.put(key,value);用requestMappering的路径作为key
                    JztRequestMapping reqmapping = clazz.getAnnotation(JztRequestMapping.class);
                    String key = reqmapping.value();
                    beans.put(key, value);// 其实就是放到ioc容器里面，map的对象

                } else if (clazz.isAnnotationPresent(JztService.class)) {// 判断是否是Service类
                    Object value = clazz.newInstance();// 实例化对象
                    // map.put(key,value);用requestMappering的路径作为key
                    JztService reqmapping = clazz.getAnnotation(JztService.class);
                    String key = reqmapping.value();
                    beans.put(key, value);// 其实就是放到ioc容器里面，map的对象
                } else {
                    continue;
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    /**
     * 扫描所有的类
     */
    private void doScan(String basePackage) {
        // basePackage ---> com.ys
        // 扫描编译好的所有的类路径 拼接路径，并且将.变成/ 用于判断是否是文件或者文件夹，递归准备 ---> com/ys
        URL url = this.getClass().getClassLoader().getResource("/" + basePackage.replaceAll("\\.", "/"));
        String fileStr = url.getFile();// 得到路径 --->com/jzt/ys
        File file = new File(fileStr);
        String[] filesStr = file.list();// com/jzt/ys下面所有文件夹或者.class文件
        for (String path : filesStr) {
            File filePath = new File(fileStr + path);// 得到com/jzt/ys/controller
            // 判断是文件还是文件夹
            if (filePath.isDirectory()) {
                // 路径
                doScan(basePackage + "." + filePath.getName());// 递归进行循环
            } else {
                // 文件 得到OrderService.class
                classNames.add(basePackage + "." + filePath.getName());// 得到 com/jzt/ys/controller/OrdersService.class

            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取到请求的路径 jzt/query--->method
        // ys-mvc/jzt/query....
        String uri = req.getRequestURI();
        // ys-mvc
        String context = req.getContextPath();
        // /jzt/query-->key
        String path = uri.replace(context, "");
        /// jzt/query---》method
        Method method = (Method) handerMap.get(path);
        // 从beans中拿到/jzt对应的对象
        JztMvcController instance = (JztMvcController) beans.get("/" + path.split("/")[1]);

        Object[] args = hand(req, resp, method);
        try {
            method.invoke(instance, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 转化参数方法
     */
    private static Object[] hand(HttpServletRequest request, HttpServletResponse response, Method method) {
        // 拿到当前待执行的方法有哪些参数
        Class<?>[] paramClazzs = method.getParameterTypes();
        // 根据参数的个数，new一个参数的数组，将方法里面所有的参数复制到args来

        Object[] args = new Object[paramClazzs.length];
        int args_i = 0;
        int index = 0;
        for (Class<?> paramClazz : paramClazzs) {
            if (ServletRequest.class.isAssignableFrom(paramClazz)) {
                args[args_i++] = request;
            }
            if (ServletResponse.class.isAssignableFrom(paramClazz)) {
                args[args_i++] = response;
            }
            // 从0-3判断有没有RequestParams注解，很明显paramClazz为0和1时，不是
            // 当为2和3的时候，为@RequestParam，需要进行解析
            Annotation[] paramAns = method.getParameterAnnotations()[index];
            if (paramAns.length > 0) {
                for (Annotation paramAn : paramAns) {
                    if (JztRequestParam.class.isAssignableFrom(paramAn.getClass())) {
                        JztRequestParam rp = (JztRequestParam) paramAn;
                        // 找到注解里面的name和age
                        args[args_i++] = request.getParameter(rp.value());
                    }
                }
            }
            index++;
        }
        return args;
    }

}
