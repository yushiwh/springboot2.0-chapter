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

import com.ys.service.Chart;
import com.ys.service.ChartFactory;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${chart.name}")
    String chartName;

    @GetMapping(value = "/getProduct")
    public String getProduct() {
        Chart chart;
        /**
         * 通过静态工厂方法创建产品
         */
        //chart = ChartFactory.getChart("histogram");
        //chart = ChartFactory.getChart("pie");

        chart = ChartFactory.getChart(chartName);

        chart.display();

        return "创建的是" + chartName + "的图形";
    }

}