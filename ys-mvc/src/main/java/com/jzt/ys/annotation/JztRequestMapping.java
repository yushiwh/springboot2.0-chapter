package com.jzt.ys.annotation;


import java.lang.annotation.*;

/**
 * 自定义RequestMapping注解
 *
 * @author yushi  2018-09-14
 */
@Target({ElementType.TYPE, ElementType.METHOD})//只能用在类和方法上面，注意要用数组，作用范围
@Retention(RetentionPolicy.RUNTIME)//在运行时通过反射获取到信息
@Documented//包含在javadoc上面
public @interface JztRequestMapping {
    //注解后面带的参数的值
    String value() default "";
}
