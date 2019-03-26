package com.ys.service;

/**
 * 日志记录器工厂接口：抽象工厂
 *
 * @author nick
 * @create 2019-03-26 11:08
 */
public interface LoggerFactory {
    public Logger createLogger();
}
