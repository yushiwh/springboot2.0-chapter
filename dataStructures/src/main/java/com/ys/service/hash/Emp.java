/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Emp
 * Author:   nick
 * Date:     2019/9/6 15:32
 * Description: 表示一个雇员
 * History:
 */
package com.ys.service.hash;

/**
 * 〈表示一个雇员〉
 *
 * @author nick
 * @create 2019/9/6
 * @since 1.0.0
 */
public class Emp {
    public int id;
    public String name;
    //next 默认为 null
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}