/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ArrBinaryTree
 * Author:   nick
 * Date:     2019/9/17 9:10
 * Description: 编写一个ArrayBinaryTree, 实现顺序存储二叉树遍历
 * History:
 */
package com.ys.service.tree;


/**
 * 〈编写一个ArrayBinaryTree, 实现顺序存储二叉树遍历〉
 *
 * @author nick
 * @create 2019/9/17
 * @since 1.0.0
 */
public class ArrBinaryTree {
    /**
     * 存储数据结点的数组
     */
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 重载preOrder
     */
    public void preOrder() {
        this.preOrder(0);
    }

    /**
     * 重载preOrder
     */
    public void infixOrder() {
        this.infixOrder(0);
    }

    /**
     * 重载preOrder
     */
    public void postOrder() {
        this.postOrder(0);
    }

    /**
     * //编写一个方法，完成顺序存储二叉树的前序遍历
     * 1 (0)
     * /   \               数组编号：0 1 2 3 4 5 6
     * 2(1)   3(2)         对应数组：1 2 3 4 5 6 7
     * /   \    /  \
     * 4(3) 5(4) 6(5) 7(6)
     *
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        //如果数组为空，或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        StringBuilder sb = new StringBuilder();
        System.out.print(sb.append(arr[index]).append(","));
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    /**
     * 中序
     * 1 (0)
     * /   \            数组编号：0 1 2 3 4 5 6
     * 2(1)   3(2)         对应数组：1 2 3 4 5 6 7
     * /   \    /  \
     * 4(3) 5(4) 6(5) 7(6)
     *
     * @param index
     */
    public void infixOrder(int index) {
        //如果数组为空，或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            infixOrder(2 * index + 1);
        }
        //输出当前这个元素
        StringBuilder sb = new StringBuilder();
        System.out.print(sb.append(arr[index]).append(","));
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            infixOrder(2 * index + 2);
        }
    }

    /**
     * 后续
     * 1 (0)
     * /   \            数组编号：0 1 2 3 4 5 6
     * 2(1)   3(2)         对应数组：1 2 3 4 5 6 7
     * /   \    /  \
     * 4(3) 5(4) 6(5) 7(6)
     *
     * @param index
     */
    public void postOrder(int index) {
        //如果数组为空，或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            postOrder(2 * index + 1);
        }

        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            postOrder(2 * index + 2);
        }

        //输出当前这个元素
        StringBuilder sb = new StringBuilder();
        System.out.print(sb.append(arr[index]).append(","));

    }

}