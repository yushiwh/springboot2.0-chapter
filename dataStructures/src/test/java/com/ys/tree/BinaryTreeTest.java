/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: BinaryTreeTest
 * Author:   nick
 * Date:     2019/9/11 14:38
 * Description: 树的测试
 * History:
 */
package com.ys.tree;

import com.ys.Tester;
import com.ys.service.tree.BinaryTree;
import com.ys.service.tree.HeroNode;
import org.junit.Test;


/**
 * 〈树的测试〉
 *
 * @author nick
 * @create 2019/9/11
 * @since 1.0.0
 */
public class BinaryTreeTest extends Tester {


    @Test
    public void testPolandNotation() throws Exception {
        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        HeroNode node6 = new HeroNode(6, "武松");
        HeroNode node7 = new HeroNode(7, "潘金莲");
        /** 添加的二叉树
         *              1
         *            /  \
         *           2    3
         *          / \  / \
         *         6  7 5  4
         */

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        //左子树增加两个节点
        node2.setLeft(node6);
        node2.setRight(node7);
        binaryTree.setRoot(root);

        //************测试前中后的三个遍历********************//
        //测试
//        System.out.println("前序遍历（父节点--》左子树--》右子树）");
//        binaryTree.preOrder();// 1,2,3,5,4    (1,2,6,7,3,5,4)
//
//        //测试
//        System.out.println("中序遍历（左子树--》父节点--》右子树）");
//        binaryTree.infixOrder(); // 2,1,5,3,4  (6,2,7,1,5,3,4)
//        //
//        System.out.println("后序遍历（左子树--》右子树--》父节点）");
//        binaryTree.postOrder(); // 2,5,4,3,1  (6,7,2,5,4,3,1)

        //前序遍历
        //前序遍历的次数 ：6
//		System.out.println("前序遍历方式~~~");
//		HeroNode resNode = binaryTree.preOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}

        //中序遍历查找
        //中序遍历5次
//		System.out.println("中序遍历方式~~~");
//		HeroNode resNode = binaryTree.infixOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}

        //后序遍历查找
        //后序遍历查找的次数  4次
//		System.out.println("后序遍历方式~~~");
//		HeroNode resNode = binaryTree.postOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}

        //测试一把删除结点

//        System.out.println("删除前,前序遍历");
//        binaryTree.preOrder(); //  1,2,3,5,4
//    //    binaryTree.delNode(5);
//        binaryTree.delNode(3);
//        System.out.println("删除后，前序遍历");
//        binaryTree.preOrder(); // 1,2,3,4


        System.out.println("删除前,前序遍历");
        binaryTree.preOrder(); //
        binaryTree.delNodeLeaf(2);
        // binaryTree.delNodeLeaf(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder(); //

    }
}