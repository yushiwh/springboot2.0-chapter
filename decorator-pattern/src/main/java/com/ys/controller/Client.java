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

import com.ys.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    @Autowired
    private FactoryUtil factoryUtil;

    @GetMapping(value = "/getComponent")
    public String getImage() {
        /**
         * //使用抽象构件定义
         */
        Component component, componentSB, componentBB;

        /**
         * //定义具体构件
         */
        component = (Component) factoryUtil.getBean();
        /**
         * 定义装饰后的构件
         */
        componentSB = new ScrollBarDecorator(component);

        /**
         * 第二次进行装饰
         * 将装饰了一次之后的对象继续注入到另一个装饰类中，进行第二次装饰
         */
        componentBB = new BlackBorderDecorator(componentSB);

        componentBB.display();


        return "调用构件成功";
    }

}