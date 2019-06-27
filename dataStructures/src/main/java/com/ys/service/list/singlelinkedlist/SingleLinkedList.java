/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: singlelinkedlist
 * Author:   nick
 * Date:     2019/6/26 10:01
 * Description: 管理英雄的链表
 * History:
 */
package com.ys.service.list.singlelinkedlist;

/**
 * 〈管理英雄的链表〉
 * 单链表的crud
 *
 * @author nick
 * @create 2019/6/26
 * @since 1.0.0
 */
public class SingleLinkedList {


    /**
     * 为了防止后面查找时候找不到链表的头，所以不要动，不存放具体的数据
     * 先初始化一个头节点, 头节点不要动, 不存放具体的数据
     */
    private HeroNode head = new HeroNode(0, "", "");


    /**
     * 返回头节点
     */
    public HeroNode getHead() {
        return head;
    }


    /**
     * //添加节点到单向链表
     * //思路，当不考虑编号顺序时
     * //1. 找到当前链表的最后节点
     * //2. 将最后这个节点的next 指向 新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {

        //因为head节点不能动，因此我们需要一个辅助变量 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
    }


    /**
     * //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
     * //(如果有这个排名，则添加失败，并给出提示)
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        // flag标志添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            //说明temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            //位置找到，就在temp的后面插入
            if (temp.next.no > heroNode.no) {
                break;
                //说明希望添加的heroNode的编号已然存在
            } else if (temp.next.no == heroNode.no) {
                //说明编号存在
                flag = true;
                break;
            }
            //后移，遍历当前链表
            temp = temp.next;
        }
        //判断flag 的值
        if (flag) {
            //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    /**
     * //修改节点的信息, 根据no编号来修改，即no编号不能改.
     * //说明
     * //1. 根据 newHeroNode 的 no 来修改即可
     *
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode) {
        //判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        //表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //已经遍历完链表
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            //没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }


    /**
     * //删除节点
     * //思路
     * //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     * //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
     *
     * @param no
     */
    public void del(int no) {
        HeroNode temp = head;
        // 标志是否找到待删除节点的
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            //temp后移，遍历
            temp = temp.next;
        }
        //判断flag
        //找到
        if (flag) {
            //可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }


    /**
     * //显示链表[遍历]
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }
}