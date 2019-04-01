/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: LazySingleton
 * Author:   yushi
 * Date:     2019/4/1 15:28
 * Description: 懒汉式单例额和线程锁定
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈懒汉式单例额和线程锁定〉
 * <p>
 * <p>
 * 懒汉式单例在第一次调用getInstance()方法时实例化，在类加载时并不自行实例化，这种技术又称为延迟加载 (Lazy Load)技术，即需要的时候再加载实例，
 * 为了避免多个线程同时调用getInstance()方法，我们可以使用关键字synchronized。
 * 该方法不是很推荐（虽然解决了线程安全问题，但是每次调用getInstance()时都需要进行线程锁定判断，在多线程高并发访问环境中，将会导致系统性能大大降低）。
 *
 *
 * - 优点：在第一次使用时创建，无须一直占用系统资源，实现了延迟加载。
 * - 缺点：必须处理好多个线程同时访问的问题，特别是当单例类作为资源控制器，在实例化时必然涉及资源初始化，而资源初始化很有可能耗费大量时间，
 *        这意味着出现多线程同时首次引用此类的机率变得较大，需要通过双重检查锁定等机制进行控制，这将导致系统性能受到一定影响。
 *
 * @author yushi
 * @create 2019/4/1
 * @since 1.0.0
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {
    }

    /**
     * 懒汉式（分布式中会出现问题，一样会创建N个实例）
     *
     * @return
     */
    synchronized public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 懒汉式改进代码，添加锁
     *
     *  假如在某一瞬间线程A和线程B都在调用getInstance()方法，此时instance对象为null值，均能通过instance == null的判断。
     *  由于实现了synchronized加锁机制，线程A进入synchronized锁定的代码中执行实例创建代码，线程B处于排队等待状态，
     *  必须等待线程A执行完毕后才可以进入synchronized锁定代码。
     *  但当A执行完毕时，线程B并不知道实例已经创建，将继续创建新的实例，导致产生多个单例对象。
     *
     * @return
     */
//    public static LazySingleton getInstance() {
//        if (instance == null) {
//            //只需要锁住new LazySingleton();代码
//            synchronized (LazySingleton.class) {
//                instance = new LazySingleton();
//            }
//        }
//        return instance;
//    }


    /**
     * 加上双重锁检查
     * 在synchronized中再进行一次(instance == null)判断，这种方式称为双重检查锁定(Double-Check Locking)
     *
     * @return
     */
//    public static LazySingleton getInstance() {
//        //第一重判断
//        if (instance == null) {
//            //锁定代码块
//            synchronized (LazySingleton.class) {
//                //第二重判断
//                if (instance == null) {
//                    instance = new LazySingleton(); //创建单例实例
//                }
//            }
//        }
//        return instance;
//    }


}