/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: WeeklyLogShallowClone
 * Author:   yushi
 * Date:     2019/4/2 16:45
 * Description: 浅克隆
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

import lombok.Data;

/**
 * 〈浅克隆〉
 *
 * @author yushi
 * @create 2019/4/2
 * @since 1.0.0
 */
@Data
public class WeeklyLogShallowClone implements Cloneable {
    //为了简化设计和实现，假设一份工作周报中只有一个附件对象，实际情况中可以包含多个附件，可以通过List等集合对象来实现

    private Attachment attachment;

    private String name;
    private String date;

    private String content;

    //使用clone()方法实现浅克隆
    @Override
    public WeeklyLogShallowClone clone() {
        Object obj = null;
        try {
            obj = super.clone();
            return (WeeklyLogShallowClone) obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制！");
            return null;
        }

    }

}