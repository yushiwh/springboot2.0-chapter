/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: WeeklyLog
 * Author:   yushi
 * Date:     2019/4/2 14:35
 * Description: /工作周报WeeklyLog：具体原型类，考虑到代码的可读性和易理解性，只列出部分与模式相关的核心代码
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

import lombok.Data;

/**
 * 〈/工作周报WeeklyLog：具体原型类，考虑到代码的可读性和易理解性，只列出部分与模式相关的核心代码〉
 *
 * @author yushi
 * @create 2019/4/2
 * @since 1.0.0
 */
@Data
public class WeeklyLog implements Cloneable {
    private String name;
    private String date;
    private String content;
    //克隆方法clone()，此处使用Java语言提供的克隆机制
    @Override
    public WeeklyLog clone() {
        Object obj = null;
        try {
            obj = super.clone();
            return (WeeklyLog) obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制！");
            return null;
        }
    }
}