/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: BMPImage
 * Author:   yushi
 * Date:     2019/4/4 15:48
 * Description: BMP格式图像：扩充抽象类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈BMP格式图像：扩充抽象类〉
 *
 * @author yushi
 * @create 2019/4/4
 * @since 1.0.0
 */
public class BMPImage extends Image {

    @Override
    public void parseFile(String fileName) {
        //模拟解析BMP文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + "，格式为BMP。");
    }
}