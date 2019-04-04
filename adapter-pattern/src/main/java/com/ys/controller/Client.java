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

import com.ys.service.FactoryUtil;
import com.ys.service.ScoreOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private FactoryUtil factoryUtil;

    @GetMapping(value = "/getOperation")
    public String getOperation() {
        //针对抽象目标接口编程
        ScoreOperation operation;
        //读取配置文件，反射生成对象
        //只需要面向适配器 接口就行了
        operation = (ScoreOperation) factoryUtil.getBean();
        //定义成绩数组
        int[] scores = {84, 76, 50, 69, 90, 91, 88, 96};
        int[] result;
        int score;

        logger.info("成绩排序结果：");
        result = operation.sort(scores);

        //遍历输出成绩
        for (int i : scores) {
            logger.info(i + ",");
        }
        logger.info("");

        logger.info("查找成绩90：");
        score = operation.search(result, 90);
        if (score != -1) {
            logger.info("找到成绩90。");
        } else {
            logger.info("没有找到成绩90。");
        }

        logger.info("查找成绩92：");
        score = operation.search(result, 92);
        if (score != -1) {
            logger.info("找到成绩92。");
        } else {
            logger.info("没有找到成绩92。");
        }


        return "调用成功";
    }

}