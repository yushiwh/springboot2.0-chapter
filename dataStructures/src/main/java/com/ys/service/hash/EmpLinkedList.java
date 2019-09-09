/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: EmpLinkedList
 * Author:   nick
 * Date:     2019/9/6 15:33
 * Description: 创建EmpLinkedList ,表示链表
 * History:
 */
package com.ys.service.hash;

/**
 * 〈创建EmpLinkedList ,表示链表〉
 *
 * @author nick
 * @create 2019/9/6
 * @since 1.0.0
 */
public class EmpLinkedList {
    /**
     * 头指针，执行第一个Emp,因此我们这个链表的head 是直接指向第一个Emp
     * //默认null
     */
    private Emp head;

    //添加雇员到链表
    //说明
    //1. 假定，当添加雇员时，id 是自增长，即id的分配总是从小到大
    //   因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;
        while ( true ) {
            //说明到链表最后
            if (curEmp.next == null) {
                break;
            }
            //后移
            curEmp = curEmp.next;
        }
        //退出时直接将emp 加入链表
        curEmp.next = emp;
    }


    /**
     * 删除节点
     *
     * @param
     */
    public void del(Emp emp) {
        Emp t = null;
        for (Emp x = head; x != null; x = x.next) {
            if (x.id == emp.id) {
                if (t != null) {
                    t.next = x.next;
                } else {
                    head = x.next;
                }
            }
            t = x;
        }
    }


    /**
     * 遍历链表的雇员信息
     */
    public void list(int no) {
        if (head == null) {
            //说明链表为空
            System.out.println("第 " + (no + 1) + " 链表为空");
            return;
        }
        System.out.print("第 " + (no + 1) + " 链表的信息为");
        //辅助指针
        Emp curEmp = head;
        while ( true ) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            //说明curEmp已经是最后结点
            if (curEmp.next == null) {
                break;
            }
            //后移，遍历
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    //根据id查找雇员
    //如果查找到，就返回Emp, 如果没有找到，就返回null
    public Emp findEmpById(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while ( true ) {
            //找到
            if (curEmp.id == id) {
                //这时curEmp就指向要查找的雇员
                break;
            }
            //退出
            //说明遍历当前链表没有找到该雇员
            if (curEmp.next == null) {
                curEmp = null;
                break;
            }
            //以后
            curEmp = curEmp.next;
        }

        return curEmp;
    }
}