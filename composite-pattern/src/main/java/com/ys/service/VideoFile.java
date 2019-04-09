/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: VideoFile
 * Author:   yushi
 * Date:     2019/4/9 9:53
 * Description:  //视频文件类：叶子构件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈 //视频文件类：叶子构件〉
 *
 * @author yushi
 * @create 2019/4/9
 * @since 1.0.0
 */
public class VideoFile extends AbstractFile {
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("对不起，不支持该方法！");
        return null;
    }

    @Override
    public void killVirus() {
        //模拟杀毒
        System.out.println("----对视频文件'" + name + "'进行杀毒");
    }

}