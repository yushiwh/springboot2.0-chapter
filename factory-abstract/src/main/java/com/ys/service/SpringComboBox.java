/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: SpringComboBox
 * Author:   yushi
 * Date:     2019/3/30 11:23
 * Description: Spring组合框类：具体的产品
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈Spring组合框类：具体的产品〉
 *
 * @author yushi
 * @create 2019/3/30
 * @since 1.0.0
 */
public class SpringComboBox implements ComboBox {

    @Override
    public String display() {
        System.out.println("SpringComboBox中显示绿色边框组合框。");
        return "SpringComboBox中显示绿色边框组合框。";
    }
}