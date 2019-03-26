/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Client
 * Author:   yushi
 * Date:     2019/3/26 9:34
 * Description: 客户端调用方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.controller;

import com.ys.service.Logger;
import com.ys.service.LoggerFactory;
import com.ys.service.FactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈客户端调用方法〉
 *
 * @author yushi
 * @create 2019/3/26
 * @since 1.0.0
 */
@RestController
public class Client {

    @Autowired
    private FactoryUtil factoryUtil;



    @GetMapping(value = "/getlogger")
    public String getProduct() {
        LoggerFactory factory;
        Logger logger;
        /**
         * 可引入配置文件实现
         */
   //     factory = new FileLoggerFactory();
        /**
         * 用反射实例化
         * getBean()的返回类型为Object，需要进行强制类型转换
         * 只需要修改配置文件即可
         */
        factory = (LoggerFactory)factoryUtil.getBean();
        logger = factory.createLogger();
        logger.writeLog();

        return logger.writeLog();
    }

}