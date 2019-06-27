/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: DoubleLinkListTest
 * Author:   nick
 * Date:     2019/6/27 10:51
 * Description: 双向链表的测试
 * History:
 */
package com.ys.list;

import com.ys.Tester;
import com.ys.service.list.doublelinklist.DoubleLinkedList;
import com.ys.service.list.doublelinklist.HeroNode2;
import org.junit.Test;

/**
 * 〈双向链表的测试〉
 *
 * @author nick
 * @create 2019/6/27
 * @since 1.0.0
 */
public class DoubleLinkListTest extends Tester {

    @Test
    public void test() {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 修改
//        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
//        doubleLinkedList.update(newHeroNode);
//        System.out.println("修改后的链表情况");
//        doubleLinkedList.list();
//
//        // 删除
//        doubleLinkedList.del(3);
//        System.out.println("删除后的链表情况~~");
//        doubleLinkedList.list();

        //指定位置的添加节点
        HeroNode2 hero5 = new HeroNode2(5, "last", "队尾");
        HeroNode2 hero6 = new HeroNode2(6, "first", "队首");
        HeroNode2 hero7 = new HeroNode2(7, "center", "中间");
        //插入末尾
        doubleLinkedList.addBySite(hero4, null, hero5);
        System.out.println("插入末尾后情况~~");
        doubleLinkedList.list();
        //插入开始
        doubleLinkedList.addBySite(hero1, null, hero6);
        System.out.println("插入队首后情况~~");
        doubleLinkedList.list();
        //插入指定位置
        doubleLinkedList.addBySite(hero3, hero4, hero7);
        System.out.println("指定位置后的链表情况~~");
        doubleLinkedList.list();


    }

}