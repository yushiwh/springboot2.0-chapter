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
import com.ys.service.Image;
import com.ys.service.ImageImp;
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

    @GetMapping(value = "/getImage")
    public String getImage() {

        Image image;
        ImageImp imp;
        //图片
        image = (Image) factoryUtil.getBean("image");
        //操作系统
        imp = (ImageImp) factoryUtil.getBean("class");

        image.setImageImp(imp);
        image.parseFile("小龙女");


        return "调用成功";
    }

}