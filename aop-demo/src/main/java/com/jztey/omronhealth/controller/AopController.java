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

import com.jztey.omronhealth.service.ArithmeticCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yushi
 * @create 2018/9/28
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api")
public class AopController {

    @Autowired
    private ArithmeticCalculator arithmeticCalculator;

    @RequestMapping(value = "/aop", method = RequestMethod.GET)
    public Map test() {

        System.out.println("和--->" + arithmeticCalculator.add(3, 5));

        System.out.println("差--->" + arithmeticCalculator.sub(10, 5));

        Map map = new HashMap();
        map.put("和", arithmeticCalculator.add(3, 5));
        map.put("差", arithmeticCalculator.sub(10, 5));
        return map;
    }
}