/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: HeroNode2
 * Author:   nick
 * Date:     2019/6/27 10:48
 * Description: 双向链表定义
 * History:
 */
package com.ys.service.list.doublelinklist;

/**
 * 〈双向链表定义〉
 *
 * @author nick
 * @create 2019/6/27
 * @since 1.0.0
 */
public class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    /**
     * // 指向下一个节点, 默认为null
     */
    public HeroNode2 next;
    /**
     * // 指向前一个节点, 默认为null
     */
    public HeroNode2 pre;
    // 构造器

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}