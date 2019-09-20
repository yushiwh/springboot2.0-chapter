/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ThreadedBinaryTreeTest
 * Author:   nick
 * Date:     2019/9/17 15:45
 * Description: 线索化二叉树测试
 * History:
 */
package com.ys.tree;

import com.ys.Tester;
import com.ys.service.tree.threadedbinarytree.HeroNode;
import com.ys.service.tree.threadedbinarytree.ThreadedBinaryTree;
import org.junit.Test;

/**
 * 〈线索化二叉树测试〉
 *
 * @author nick
 * @create 2019/9/17
 * @since 1.0.0
 */
public class ThreadedBinaryTreeTest extends Tester {
    @Test
    public void testPolandNotation() throws Exception {

        //测试一把中序线索二叉树的功能 以数组｛8, 3, 10, 1, 14, 6｝为例

        /**
         *          1
         *        /   \
         *       3     6
         *      / \   /
         *     8  10 14
         */

        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //*************测试中序线索化***************//

        System.out.println("==========中序线索化开始=============");
        System.out.println("｛8, 3, 10, 1, 14, 6｝");
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 =" + leftNode); //3
        System.out.println("10号结点的后继结点是=" + rightNode); //1

        //当线索化二叉树后，能在使用原来的遍历方法
        //threadedBinaryTree.infixOrder();
        System.out.println("中序使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTree.threadedList(); // 8, 3, 10, 1, 14, 6
        //********************中序结束******************//


        //******************前序*****************//
        System.out.println("==========前序线索化开始=============");
        System.out.println("{1,3,8,10,6,14}");

        //前序：{1,3,8,10,6,14}
        ThreadedBinaryTree threadedBinaryTreePre = new ThreadedBinaryTree();
        threadedBinaryTreePre.setRoot(root);
        threadedBinaryTreePre.threadedNodesPre();

        //测试: 以10号节点测试
        HeroNode leftNodePre = node4.getLeft();
        HeroNode rightNodePre = node4.getRight();
        System.out.println("8号结点的前驱结点是 =" + leftNodePre); //3
        System.out.println("8号结点的后继结点是=" + rightNodePre); //10

        HeroNode leftNodetenPre = node5.getLeft();
        HeroNode rightNodetenPre = node5.getRight();
        System.out.println("10号结点的前驱结点是 =" + leftNodetenPre); //8
        System.out.println("10号结点的后继结点是=" + rightNodetenPre); //6

        System.out.println("前序使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTreePre.threadedListPre();//{1,3,8,10,6,14}


        //******************前序结束*****************//

        //******************后序*****************//

        //如果是后序，需要创建二叉树的时候，将parent进行保存。这个是用于后续二叉树的遍历的

        node2.setParent(root);
        node3.setParent(root);
        node4.setParent(node2);
        node5.setParent(node2);
        node6.setParent(node3);


        System.out.println("==========后序线索化开始=============");
        System.out.println("{8,10,3,14,6,1}");
        //后序：{8,10,3,14,6,1}
        ThreadedBinaryTree threadedBinaryTreeAfter = new ThreadedBinaryTree();
        threadedBinaryTreeAfter.setRoot(root);
        threadedBinaryTreeAfter.threadedNodesAfter();


        HeroNode leftNodeAfter = node4.getLeft();
        HeroNode rightNodeAfter = node4.getRight();
        System.out.println("8号结点的前驱结点是 =" + leftNodeAfter); //null
        System.out.println("8号结点的后继结点是=" + rightNodeAfter); //10

        HeroNode leftNodetenAfter = node5.getLeft();
        HeroNode rightNodetenAfter = node5.getRight();
        System.out.println("10号结点的前驱结点是 =" + leftNodetenAfter); //8
        System.out.println("10号结点的后继结点是=" + rightNodetenAfter); //3

        System.out.println("后序使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTreeAfter.threadedListAfter();//{8,10,3,14,6,1}


    }
}