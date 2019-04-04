/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Image
 * Author:   yushi
 * Date:     2019/4/4 15:41
 * Description:  //抽象图像类：抽象类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈 //抽象图像类：抽象类〉
 *
 * @author yushi
 * @create 2019/4/4
 * @since 1.0.0
 */
public abstract class Image {
    protected ImageImp imp;

    public void setImageImp(ImageImp imp) {
        this.imp = imp;
    }

    public abstract void parseFile(String fileName);

}