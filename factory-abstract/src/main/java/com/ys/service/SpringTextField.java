/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: SpringTextField
 * Author:   yushi
 * Date:     2019/3/30 11:21
 * Description: Spring文本框类：具体产品
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈Spring文本框类：具体产品〉
 *
 * @author yushi
 * @create 2019/3/30
 * @since 1.0.0
 */
public class SpringTextField implements TextField {

    @Override
    public String display() {
        System.out.println("SpringTextField中显示绿色边框文本框。");
        return "SpringTextField中显示绿色边框文本框。";
    }
}