/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: SummerSkinFactory
 * Author:   yushi
 * Date:     2019/3/30 11:31
 * Description: Summer皮肤工厂：具体工厂
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈Summer皮肤工厂：具体工厂〉
 *
 * @author yushi
 * @create 2019/3/30
 * @since 1.0.0
 */
public class SummerSkinFactory implements SkinFactory {

    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}