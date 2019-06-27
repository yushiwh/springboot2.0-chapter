/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: DoubleLinkedList
 * Author:   nick
 * Date:     2019/6/27 10:48
 * Description: 双向链表
 * History:
 */
package com.ys.service.list.doublelinklist;

import com.ys.service.list.singlelinkedlist.HeroNode;

/**
 * 〈双向链表〉
 *
 * @author nick
 * @create 2019/6/27
 * @since 1.0.0
 */
public class DoubleLinkedList {
    // 先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    // 返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    // 遍历双向链表的方法
    // 显示链表[遍历]
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
            // 判断是否到链表最后
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将temp后移， 一定小心
            temp = temp.next;
        }
    }

    // 添加一个节点到双向链表的最后.
    public void add(HeroNode2 heroNode) {

        // 因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode2 temp = head;
        // 遍历链表，找到最后
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }


    //

    /**
     * 双向链表的指定位置添加节点
     *
     * @param preNode  前一个节点
     * @param nextNode 后一个节点
     */
    public void addBySite(HeroNode2 preNode, HeroNode2 nextNode, HeroNode2 insertNode) {
        //判断一下是否开始节点是最后一个
        if (preNode.next == null && nextNode == null) {
            //加入到最后
            preNode.next = insertNode;
            insertNode.pre = preNode;
        }
        //判断是否是开头
        else if (preNode.pre.pre == null && nextNode == null) {
            // 因为head节点不能动，因此我们需要一个辅助遍历 temp
            HeroNode2 temp = head;
            //加入到最开始
            temp.next = insertNode;
            insertNode.next = preNode;

            //反向，注意反向的pre指向开始的节点
            preNode.pre = insertNode;
            insertNode.pre = temp;
        } else if (preNode != null && preNode != null) {
            //正向链
            //插入的下一个节点指向原来上一个节点的下一个节点
            //5（insertNode）应当对的是3（preNode）的下一个节点preNode.next
            insertNode.next = preNode.next;
            //然后3（preNode）指向插入进来的insertNode
            preNode.next = insertNode;

            //反向链
            //5（insertNode）的pre 应当对的是4（nextNode）的上一个节点nextNode.pre
            insertNode.pre = nextNode.pre;
            //然后5（nextNode）的前面链指向插入进来的insertNode
            nextNode.pre = insertNode;
        }
    }

    // 修改一个节点的内容, 可以看到双向链表的节点内容修改和单向链表一样
    // 只是 节点类型改成 HeroNode2
    public void update(HeroNode2 newHeroNode) {
        // 判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        // 找到需要修改的节点, 根据no编号
        // 定义一个辅助变量
        HeroNode2 temp = head.next;
        // 表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break; // 已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else { // 没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    // 从双向链表中删除一个节点,
    // 说明
    // 1 对于双向链表，我们可以直接找到要删除的这个节点
    // 2 找到后，自我删除即可
    public void del(int no) {

        // 判断当前链表是否为空
        // 空链表
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        // 辅助变量(指针)
        HeroNode2 temp = head.next;
        // 标志是否找到待删除节点的
        boolean flag = false;
        while (true) {
            // 已经到链表的最后
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                // 找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            // temp后移，遍历
            temp = temp.next;
        }
        // 判断flag
        // 找到
        if (flag) {
            // 可以删除
            // temp.next = temp.next.next;[单向链表]
            temp.pre.next = temp.next;
            // 这里我们的代码有问题?
            // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }
}