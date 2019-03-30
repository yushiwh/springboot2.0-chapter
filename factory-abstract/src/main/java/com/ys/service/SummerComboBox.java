/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: SummerComboBox
 * Author:   yushi
 * Date:     2019/3/30 11:25
 * Description: Summer组合框类：具体产品
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈Summer组合框类：具体产品〉
 *
 * @author yushi
 * @create 2019/3/30
 * @since 1.0.0
 */
public class SummerComboBox implements ComboBox {

    @Override
    public String display() {
        System.out.println("SummerComboBox中显示蓝色边框组合框。");
        return "SummerComboBox中显示蓝色边框组合框。";
    }
}