/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: josepfuTest
 * Author:   nick
 * Date:     2019/6/27 16:52
 * Description: 约瑟夫环测试
 * History:
 */
package com.ys.list;

import com.ys.Tester;
import com.ys.service.list.josepfu.CircleSingleLinkedList;
import org.junit.Test;

/**
 * 〈约瑟夫环测试〉
 *
 * @author nick
 * @create 2019/6/27
 * @since 1.0.0
 */
public class josepfuTest extends Tester {

    @Test
    public void testJosepfu() {
        // 测试一把看看构建环形链表，和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);// 加入5个小孩节点
        circleSingleLinkedList.showBoy();

        //测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(10, 20, 125); // 2->4->1->5->3
        //String str = "7*2*2-5+1-5+3-3";
    }


}