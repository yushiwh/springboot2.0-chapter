package com.jzt.ys.annotation;


import java.lang.annotation.*;

/**
 * 自定义Autowired 注解
 *
 * @author yushi  2018-09-14
 */
@Target(ElementType.FIELD)//只能用在成员变量上面，作用范围
@Retention(RetentionPolicy.RUNTIME)//在运行时通过反射获取到信息
@Documented//包含在javadoc上面
public @interface JztAutowired {
    //注解后面带的参数的值
    String value() default "";
}
