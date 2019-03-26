/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ChartFactory
 * Author:   yushi
 * Date:     2019/3/26 9:33
 * Description: 图表的工厂类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈图表的工厂类〉
 *
 * @author yushi
 * @create 2019/3/26
 * @since 1.0.0
 */
public class ChartFactory {
    //静态工厂方法
    public static Chart getChart(String type) {
        Chart chart = null;
        if (type.equalsIgnoreCase("histogram")) {
            chart = new HistogramChart();
            System.out.println("初始化设置柱状图！");
        } else if (type.equalsIgnoreCase("pie")) {
            chart = new PieChart();
            System.out.println("初始化设置饼状图！");
        } else if (type.equalsIgnoreCase("line")) {
            chart = new LineChart();
            System.out.println("初始化设置折线图！");
        }
        return chart;
    }
}