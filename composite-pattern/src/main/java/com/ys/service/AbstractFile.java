/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: AbstractFile
 * Author:   yushi
 * Date:     2019/4/8 15:54
 * Description: 抽象文件类：抽象构件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈抽象文件类：抽象构件〉
 * ，在抽象构件类中声明了所有方法，包括用于管理和访问子构件的方法
 *
 * @author yushi
 * @create 2019/4/8
 * @since 1.0.0
 */
public abstract class AbstractFile {
    public abstract void add(AbstractFile file);

    public abstract void remove(AbstractFile file);

    public abstract AbstractFile getChild(int i);

    public abstract void killVirus();
}