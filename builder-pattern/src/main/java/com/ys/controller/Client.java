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

import com.ys.service.Actor;
import com.ys.service.ActorBuilder;
import com.ys.service.ActorController;
import com.ys.service.FactoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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


    @GetMapping(value = "/getActorBuilder")
    public Map<String, String> getActorBuilder() {
        ActorBuilder ab; //针对抽象建造者编程
        Map<String, String> map = new HashMap<>(6);
        /**
         * 用反射实例化
         * getBean()的返回类型为Object，需要进行强制类型转换
         * 只需要修改配置文件即可
         */
        ab = (ActorBuilder) factoryUtil.getBean();
        ActorController ac = new ActorController();
        Actor actor;
        /**
         * 通过指挥者创建完整的建造者对象
         */
        actor = ac.construct(ab);
        String type = actor.getType();
        logger.info(type + "的外观：");
        logger.info("性别：" + actor.getSex());
        logger.info("面容：" + actor.getFace());
        logger.info("服装：" + actor.getCostume());
        logger.info("发型：" + actor.getHairstyle());

        map.put(type, type + "的外观：");
        map.put("性别", type + "性别：" + actor.getSex());
        map.put("面容", type + "面容：" + actor.getFace());
        map.put("服装", type + "服装：" + actor.getCostume());
        map.put("发型", type + "发型：" + actor.getHairstyle());


        return map;
    }

}