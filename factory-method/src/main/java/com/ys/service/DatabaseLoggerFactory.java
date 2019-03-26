/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: DatabaseLoggerFactory
 * Author:   yushi
 * Date:     2019/3/26 11:08
 * Description: 数据库日志记录器工厂类：具体工厂
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈数据库日志记录器工厂类：具体工厂〉
 *
 * @author yushi
 * @create 2019/3/26
 * @since 1.0.0
 */
public class DatabaseLoggerFactory implements LoggerFactory {

    @Override
    public Logger createLogger() {
        //连接数据库，代码省略
        //创建数据库日志记录器对象
        Logger logger = new DatabaseLogger();
        //初始化数据库日志记录器，代码省略
        return logger;
    }
}