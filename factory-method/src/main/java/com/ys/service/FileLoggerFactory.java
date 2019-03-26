/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: FileLoggerFactory
 * Author:   yushi
 * Date:     2019/3/26 11:09
 * Description: 文件日志记录器工厂类：具体工厂
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈文件日志记录器工厂类：具体工厂〉
 *
 * @author yushi
 * @create 2019/3/26
 * @since 1.0.0
 */
public class FileLoggerFactory implements LoggerFactory {

    @Override
    public Logger createLogger() {
        //创建文件日志记录器对象
        Logger logger = new FileLogger();
        //创建文件，代码省略
        return logger;
    }
}