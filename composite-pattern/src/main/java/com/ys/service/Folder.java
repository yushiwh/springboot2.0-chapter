/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Folder
 * Author:   yushi
 * Date:     2019/4/9 9:54
 * Description: 文件夹类：容器构件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

import java.util.ArrayList;

/**
 * 〈文件夹类：容器构件〉
 * 容器构件类Folder的killVirus()方法中将递归调用其成员对象的killVirus()方法，从而实现对整个树形结构的遍历。
 *
 * @author yushi
 * @create 2019/4/9
 * @since 1.0.0
 */
public class Folder extends AbstractFile {
    //定义集合fileList，用于存储AbstractFile类型的成员
    private ArrayList<AbstractFile> fileList = new ArrayList<AbstractFile>();
    private String name;

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        fileList.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        fileList.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {
        return (AbstractFile) fileList.get(i);
    }

    @Override
    public void killVirus() {
        //模拟杀毒
        System.out.println("****对文件夹'" + name + "'进行杀毒");

        //递归调用成员构件的killVirus()方法
        for (Object obj : fileList) {
            ((AbstractFile) obj).killVirus();
        }

    }
}