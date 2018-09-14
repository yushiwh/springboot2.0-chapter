/**
 * Copyright (C), 2018-2020, 998电商集团 FileName: JztMvcServiceImpl Author: yushi Date: 2018/9/14 9:10 Description: 实现类
 * History: <author> <time> <version> <desc> 作者姓名 修改时间 版本号 描述
 */
package com.jzt.ys.service;

import com.jzt.ys.annotation.JztService;

/**
 * 〈一句话功能简述〉<br>
 * 〈实现类〉
 *
 * @author yushi
 * @create 2018/9/14
 * @since 1.0.0
 */
@JztService("JztMvcServiceImpl")
public class JztMvcServiceImpl implements JztMvcService {

    public String query(String name, String age) {
        return "name:" + name + "--->" + "age:" + age;
    }

}
