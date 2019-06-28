/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: CircleSingleLinkedList
 * Author:   nick
 * Date:     2019/6/27 16:49
 * Description: 单向环形链表
 * History:
 */
package com.ys.service.list.josepfu;


/**
 * 〈单向环形链表〉
 * <p>
 * 约瑟夫环的问题
 * <p>
 * 设编号为1、2、3...n个人坐成一个圈，约定编号为k，1<=k<=n的人从1开始数数，数到m的时候的那个人出列
 * 下一个人又从1开始数，数到m的时候出列
 * 依次类推编号的序列是什么？
 * 问：出列的
 *
 * @author nick
 * @create 2019/6/27
 * @since 1.0.0
 */

public class CircleSingleLinkedList {
    /**
     * 创建一个first节点,当前没有编号
     */
    private Boy first = null;

    /**
     * 添加小孩节点，构建成一个环形的链表
     *
     * @param nums 需要添加几个小孩
     */
    public void addBoy(int nums) {
        // nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        // 辅助指针，帮助构建环形链表
        Boy curBoy = null;
        // 使用for来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号，创建小孩节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                // 构成环
                first.setNext(first);
                // 让curBoy指向第一个小孩
                curBoy = first;
            } else {
                //这里有点绕
                //先让指针指向新加的节点，这个时候的指针还在第一个节点上面
                //****这样就把原来最后指向第一个节点的环干掉了***
                curBoy.setNext(boy);
                //再让新节点的下一个指向第一个，构成环
                boy.setNext(first);
                //最后将指针指向目前节点，准备后续的
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历当前的环形链表
     */
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }
        // 因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            // 说明已经遍历完毕
            if (curBoy.getNext() == first) {
                break;
            }
            // curBoy后移
            curBoy = curBoy.getNext();
        }
    }


    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     * 需要两个指针进行操作
     * 一个指向最后一个小孩  helper
     * 一个指向helper的下一个小孩
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // 创建要给辅助指针,帮助完成小孩出圈
        Boy helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while (true) {
            // 说明helper指向最后小孩节点
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first 和  helper 移动 k - 1次
        //也就是移动到从哪个小孩开始
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
        //这里是一个循环操作，直到圈中只有一个节点
        while (true) {
            //说明圈中只有一个节点
            if (helper == first) {
                break;
            }
            //让 first 和 helper 指针同时 的移动 countNum - 1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这时将first指向的小孩节点出圈，移动first指针
            first = first.getNext();
            //真正的出圈，将链指向下一个。因为上一步中的first已经指向了下一个
            helper.setNext(first);

        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());

    }
}