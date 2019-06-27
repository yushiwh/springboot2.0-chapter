/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: HeroNode
 * Author:   nick
 * Date:     2019/6/26 9:59
 * Description: 头结点
 * History:
 */
package com.ys.service.list.singlelinkedlist;

/**
 * 〈头结点〉
 * 英雄的类
 * //定义HeroNode ， 每个HeroNode 对象就是一个节点
 *
 * @author nick
 * @create 2019/6/26
 * @since 1.0.0
 */
public class HeroNode {
    /**
     * 数据部分，包括三个属性
     */
    public int no;
    public String name;
    public String nickname;
    /**
     * 指向下一个节点，指向下一个部分
     */
    public HeroNode next;


    /**
     * //构造器
     *
     * @param no
     * @param name
     * @param nickname
     */
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    /**
     * 为了显示方便，我们重新toString
     */
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}