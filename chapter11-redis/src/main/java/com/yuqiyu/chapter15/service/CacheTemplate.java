package com.yuqiyu.chapter15.service;

import com.fasterxml.jackson.core.type.TypeReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 缓存模版
 *
 * @author ys 2018-02-08
 * @param <T>
 */
@Component
public class CacheTemplate<T> {

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static final Logger    LOGGER        = LoggerFactory.getLogger(CacheTemplate.class);

    @Autowired
    private RedisTemplate          redisTemplate;

    /**
     * 并发处理的缓存查询模板方法
     *
     * @param queryKey 查询键值
     * @param expire 缓存过期时间
     * @param unit 时间单位
     * @param typeReference 传入泛型类型的类对象
     * @param cacheLoadable 业务回调类
     * @param <T>
     * @return
     */
    public <T> T getCache(String queryKey, long expire, TimeUnit unit, TypeReference<T> typeReference,
                          CacheLoadable<T> cacheLoadable) {

        // 先从缓存中查找数据
        @SuppressWarnings("unchecked")
        T result = (T) redisTemplate.opsForValue().get(queryKey);
        // lock
        synchronized (this) {
            // 双重check
            result = (T) redisTemplate.opsForValue().get(queryKey);
            if (null == result) {
                // 从数据库中取出数据(回调函数)
                result = cacheLoadable.load();
                // 仅仅是为了看到缓存穿越的效果
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                redisTemplate.opsForValue().set(queryKey, result, expire, unit);
                LOGGER.info("=====从DB中取出数据后写入到缓存中成功=====");
            } else {
                LOGGER.info("=====query from cache=====");
            }
        }

        return result;
    }

}
