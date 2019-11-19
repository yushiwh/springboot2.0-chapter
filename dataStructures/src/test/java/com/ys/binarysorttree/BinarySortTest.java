/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ArrBinaryTreeTest
 * Author:   nick
 * Date:     2019/9/17 9:12
 * Description: 测试顺序存储二叉树的遍历
 * History:
 */
package com.ys.binarysorttree;

import com.ys.Tester;
import com.ys.service.binarysorttree.BinarySortTree;
import com.ys.service.binarysorttree.Node;
import com.ys.service.huffmancode.HuffmanCode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 二叉排序树编码测试
 *
 * @author nick
 * @create 2019/11/04
 * @since 1.0.0
 */
public class BinarySortTest extends Tester {
    @Autowired
    private BinarySortTree binarySortTree;

    @Test
    public void binarySort() throws Exception {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加结点到二叉排序树
        for (int value : arr) {
            binarySortTree.add(new Node(value));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12

        //测试一下删除叶子结点
        binarySortTree.delNode(12);
        binarySortTree.delNode(5);
        binarySortTree.delNode(10);
        binarySortTree.delNode(2);
        binarySortTree.delNode(3);
        binarySortTree.delNode(9);
        binarySortTree.delNode(1);
        binarySortTree.delNode(7);
        System.out.println("root=" + binarySortTree.getRoot());
        System.out.println("删除结点后");
        binarySortTree.infixOrder();
    }
}