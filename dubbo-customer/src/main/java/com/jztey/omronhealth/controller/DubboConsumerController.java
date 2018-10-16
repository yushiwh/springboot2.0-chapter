/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: AopController
 * Author:   yushi
 * Date:     2018/9/28 14:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jztey.omronhealth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jztey.omronhealth.entity.Student;
import com.jztey.omronhealth.service.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yushi
 * @create 2018/9/28
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api")
public class DubboConsumerController {

    @Reference(version = "1.0.0")
    private DubboService dubboService;

    @Autowired
    Student student;

    @RequestMapping(value = "/dubbotest", method = RequestMethod.GET)
    public String test() {
        student.setAge(10);
        student.setName("哈哈");
        String str = dubboService.testDubbo(student);
        return "ok:---->" + str;
    }
}