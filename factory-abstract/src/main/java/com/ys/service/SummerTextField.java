/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: SummerTextField
 * Author:   yushi
 * Date:     2019/3/30 11:22
 * Description: Summer文本框类：具体的产品
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈Summer文本框类：具体的产品〉
 *
 * @author yushi
 * @create 2019/3/30
 * @since 1.0.0
 */
public class SummerTextField implements TextField {

    @Override
    public String display() {
        System.out.println("SummerTextField中显示蓝色边框文本框。");
        return "SummerTextField中显示蓝色边框文本框。";
    }
}