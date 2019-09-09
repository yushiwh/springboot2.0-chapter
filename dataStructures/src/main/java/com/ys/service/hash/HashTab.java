/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: HashTab
 * Author:   nick
 * Date:     2019/9/6 15:30
 * Description: hash算法
 * History:
 */
package com.ys.service.hash;

import org.springframework.stereotype.Component;

/**
 * 〈hash算法〉
 *
 * @author nick
 * @create 2019/9/6
 * @since 1.0.0
 */
@Component
public class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    /**
     * //表示有多少条链表
     */
    private int size;

    /**
     * //构造器
     *
     * @param size
     */
    public HashTab(int size) {
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //？留一个坑, 这时不要分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    /**
     * //添加雇员
     *
     * @param emp
     */
    public void add(Emp emp) {
        //根据员工的id ,得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp 添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);

    }

    /**
     * //删除雇员
     *
     * @param emp
     */
    public void del(Emp emp) {
        //根据员工的id ,得到该员工应当到哪条链表进行删除
        int empLinkedListNO = hashFun(emp.id);
        //将emp 进行删除
        empLinkedListArray[empLinkedListNO].del(emp);

    }


    /**
     * //遍历所有的链表,遍历hashtab
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    /**
     * 根据输入的id,查找雇员
     */
    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if (emp != null) {
            //找到
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (empLinkedListNO + 1), id);
        } else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

    /**
     * 编写散列函数, 使用一个简单取模法
     */
    public int hashFun(int id) {
        return id % size;
    }

}