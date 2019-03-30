/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: SpringButton
 * Author:   yushi
 * Date:     2019/3/30 11:18
 * Description: Spring按钮类：具体产品
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈Spring按钮类：具体产品〉
 *
 * @author yushi
 * @create 2019/3/30
 * @since 1.0.0
 */
public class SpringButton implements Button {

    @Override
    public String display() {
        System.out.println("SpringButton中显示浅绿色按钮。");
        return "SpringButton中显示浅绿色按钮。";
    }
}