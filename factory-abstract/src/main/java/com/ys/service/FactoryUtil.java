/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: XMLUtil
 * Author:   yushi
 * Date:     2019/3/26 11:17
 * Description: 读取配置文件创建工厂
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * 〈读取配置文件创建工厂〉
 *
 * @author yushi
 * @create 2019/3/26
 * @since 1.0.0
 */
@Service
public class FactoryUtil {

    @Value("${class.name}")
    String className;

    @Bean
    public Object getBean() {
        try {
            //通过类名生成实例对象并将其返回,这里是全路径
            //  Class c = Class.forName("com.ys.service.FileLoggerFactory");
            Class c = Class.forName(className);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}