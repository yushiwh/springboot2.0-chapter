/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: SpringSkinFactory
 * Author:   yushi
 * Date:     2019/3/30 11:30
 * Description: Spring皮肤工厂：具体工厂
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈Spring皮肤工厂：具体工厂〉
 *
 * @author yushi
 * @create 2019/3/30
 * @since 1.0.0
 */
public class SpringSkinFactory implements SkinFactory {

    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}