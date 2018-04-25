
package com.yuqiyu.chapter15.service;

/**
 * 回调函数接口定义
 *
 * @author yushi
 */
public interface CacheLoadable<T> {

    T load();
}
