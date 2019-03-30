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

    @Autowired
    private FactoryUtil factoryUtil;


    @GetMapping(value = "/getFactory")
    public Map<String, String> getProduct() {
        SkinFactory factory;
        Button bt;
        TextField tf;
        ComboBox cb;

        /**
         * 用反射实例化
         * getBean()的返回类型为Object，需要进行强制类型转换
         * 只需要修改配置文件即可
         */
        factory = (SkinFactory) factoryUtil.getBean();
        bt = factory.createButton();
        tf = factory.createTextField();
        cb = factory.createComboBox();
//        bt.display();
//        tf.display();
//        cb.display();

        Map<String, String> map = new HashMap<String, String>(6);
        map.put("Button",bt.display());
        map.put("TextField",tf.display());
        map.put("ComboBox",cb.display());
        return map;
    }

}