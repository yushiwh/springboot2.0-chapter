/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: EagerSingleton
 * Author:   yushi
 * Date:     2019/4/1 15:25
 * Description: 饿汉式单例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈饿汉式单例〉
 * 不推荐
 *
 * @author yushi
 * @create 2019/4/1
 * @since 1.0.0
 */
public class EagerSingleton {

    /**
     * - 优点：在类被加载时就将自己实例化，它的优点在于无须考虑多线程访问问题，可以确保实例的唯一性；
     * 从调用速度和反应时间角度来讲，由于单例对象一开始就得以创建，因此要优于懒汉式单例。
     * - 缺点：无论系统在运行时是否需要使用该单例对象，由于在类加载时该对象就需要创建，因此从资源利用效率角度来讲，饿汉式单例不及懒汉式单例，
     * 而且在系统加载时由于需要创建饿汉式单例对象，加载时间可能会比较长。
     */
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

}