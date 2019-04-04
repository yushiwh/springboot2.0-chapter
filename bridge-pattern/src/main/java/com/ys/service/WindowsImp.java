/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: WindowsImp
 * Author:   yushi
 * Date:     2019/4/4 15:45
 * Description: Windows操作系统实现类：具体实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈Windows操作系统实现类：具体实现类〉
 *
 * @author yushi
 * @create 2019/4/4
 * @since 1.0.0
 */
public class WindowsImp implements ImageImp {

    @Override
    public void doPaint(Matrix m) {
        //调用Windows系统的绘制函数绘制像素矩阵
        System.out.print("在Windows操作系统中显示图像：");
    }
}