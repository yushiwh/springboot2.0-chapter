/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: JztMvcController
 * Author:   yushi
 * Date:     2018/9/14 9:08
 * Description: 控制层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jzt.ys.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzt.ys.annotation.JztAutowired;
import com.jzt.ys.annotation.JztController;
import com.jzt.ys.annotation.JztRequestMapping;
import com.jzt.ys.annotation.JztRequestParam;
import com.jzt.ys.service.JztMvcService;

/**
 * 〈一句话功能简述〉<br>
 * 〈控制层〉
 *
 * @author yushi
 * @create 2018/9/14
 * @since 1.0.0
 */
//http://localhost:8080/jzt/query?name=aaa&age=333  访问地址
@JztController
@JztRequestMapping("/jzt")
public class JztMvcController {

    @JztAutowired("JztMvcServiceImpl")
    private JztMvcService jztMvcService;


    @JztRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response,
                      @JztRequestParam("name") String name,
                      @JztRequestParam("age") String age
    ) throws IOException {

        PrintWriter ps = response.getWriter();
        String result = jztMvcService.query(name, age);
        ps.write(result);

    }


}