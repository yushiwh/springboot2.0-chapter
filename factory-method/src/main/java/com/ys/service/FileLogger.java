/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: FileLogger
 * Author:   yushi
 * Date:     2019/3/26 11:07
 * Description: 文件日志记录器：具体产品
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈文件日志记录器：具体产品〉
 *
 * @author yushi
 * @create 2019/3/26
 * @since 1.0.0
 */
public class FileLogger implements Logger {

    @Override
    public String writeLog() {
        System.out.println("文件日志记录。");
        return "文件日志记录。";
    }
}