/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: SummerButton
 * Author:   yushi
 * Date:     2019/3/30 11:20
 * Description:  Summer按钮类：具体产品
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈 Summer按钮类：具体产品〉
 *
 * @author yushi
 * @create 2019/3/30
 * @since 1.0.0
 */
public class SummerButton implements Button {

    @Override
    public String display() {
        System.out.println("SummerButton中显示浅蓝色按钮。");
        return "SummerButton中显示浅蓝色按钮。";
    }
}