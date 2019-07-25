/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ListTest
 * Author:   nick
 * Date:     2019/6/26 10:16
 * Description: 链表的测试
 * History:
 */
package com.ys.recursive;

import com.ys.Tester;
import com.ys.service.list.singlelinkedlist.HeroNode;
import com.ys.service.list.singlelinkedlist.SingleLinkedList;
import org.junit.Test;

import java.util.Stack;

/**
 * 递归的测试
 *
 * @author nick
 * @create 2019/7/24
 * @since 1.0.0
 */
public class RecursionTest extends Tester {

    @Test
    public void createTest() throws Exception {
        //通过打印问题，回顾递归调用机制
        test(4);

        int res = factorial(3);
        System.out.println(res);
    }

    //打印问题.
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        } //else {
        System.out.println("n=" + n);
        // }
    }

    //阶乘问题
    public static int factorial(int n) {
        if (n == 1) {
            System.out.print(n + "=");
            return 1;
        } else {
            System.out.print(n + "*");
            return factorial(n - 1) * n; // 1 * 2 * 3
        }
    }

}