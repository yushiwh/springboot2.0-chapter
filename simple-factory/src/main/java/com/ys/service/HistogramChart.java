/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: HistogramChart
 * Author:   yushi
 * Date:     2019/3/26 9:30
 * Description: 柱状图类：具体的产品类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈柱状图类：具体的产品类〉
 *
 * @author yushi
 * @create 2019/3/26
 * @since 1.0.0
 */
public class HistogramChart implements Chart {

    /**
     * 构造方法
     */
    public HistogramChart() {
        System.out.println("创建柱状图！");
    }


    @Override
    public void display() {
        System.out.println("显示柱状图");
    }


}