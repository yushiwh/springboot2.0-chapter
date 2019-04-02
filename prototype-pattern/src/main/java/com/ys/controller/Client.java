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

import com.ys.service.Attachment;
import com.ys.service.WeeklyLog;
import com.ys.service.WeeklyLogDeep;
import com.ys.service.WeeklyLogShallowClone;
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
    public String getWeeklyLog() {
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

    /**
     * 浅克隆
     *
     * @return
     */
    @GetMapping(value = "/getWeeklyLogShallowClone")
    public String getWeeklyLogShallowClone() {
        WeeklyLogShallowClone log_previous, log_new;
        //创建原型对象
        log_previous = new WeeklyLogShallowClone();
        //创建附件对象
        Attachment attachment = new Attachment();
        //将附件添加到周报中
        log_previous.setAttachment(attachment);
        //调用克隆方法创建克隆对象
        log_new = log_previous.clone();
        //比较周报
        logger.info("周报是否相同？ " + (log_previous == log_new));
        //比较附件
        logger.info("附件是否相同？ " + (log_previous.getAttachment() == log_new.getAttachment()));
        return "浅克隆调用成功";
    }


    /**
     * 深克隆
     * 深克隆技术实现了原型对象和克隆对象的完全独立，对任意克隆对象的修改都不会给其他对象产生影响，是一种更为理想的克隆实现方式。
     *
     * @return
     */
    @GetMapping(value = "/getWeeklyLogDeep")
    public String getWeeklyLogDeep() {
        WeeklyLogDeep log_previous, log_new = null;
        //创建原型对象
        log_previous = new WeeklyLogDeep();
        //创建附件对象
        Attachment attachment = new Attachment();
        //将附件添加到周报中
        log_previous.setAttachment(attachment);
        try {
            //调用深克隆方法创建克隆对象  
            log_new = log_previous.deepClone();
        } catch (Exception e) {
            logger.error("克隆失败！");
        }
        //比较周报
        logger.info("周报是否相同？ " + (log_previous == log_new));
        //比较附件
        logger.info("附件是否相同？ " + (log_previous.getAttachment() == log_new.getAttachment()));
        return "深克隆调用成功";
    }


}