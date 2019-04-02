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

import com.ys.service.WeeklyLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(Client.class);


    @GetMapping(value = "/getWeeklyLog")
    public String getServer() {
        //创建原型对象
        WeeklyLog log_previous = new WeeklyLog();
        log_previous.setName("张无忌");
        log_previous.setDate("第12周");
        log_previous.setContent("这周工作很忙，每天加班！");

        logger.info("****周报****");
        logger.info("周次：" + log_previous.getDate());
        logger.info("姓名：" + log_previous.getName());
        logger.info("内容：" + log_previous.getContent());
        logger.info("--------------------------------");

        WeeklyLog log_new;
        //调用克隆方法创建克隆对象
        log_new = log_previous.clone();
        log_new.setDate("第13周");
        logger.info("****周报****");
        logger.info("周次：" + log_new.getDate());
        logger.info("姓名：" + log_new.getName());
        logger.info("内容：" + log_new.getContent());
        return "调用成功";
    }

}