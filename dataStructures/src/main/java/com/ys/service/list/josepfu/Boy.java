/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Boy
 * Author:   nick
 * Date:     2019/6/27 16:50
 * Description: Boy类，代表一个节点
 * History:
 */
package com.ys.service.list.josepfu;

/**
 * 〈Boy类，代表一个节点〉
 *
 * @author nick
 * @create 2019/6/27
 * @since 1.0.0
 */
public class Boy {
    /**
     * // 编号
     */
    private int no;
    /**
     * // 指向下一个节点,默认null
     */
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}