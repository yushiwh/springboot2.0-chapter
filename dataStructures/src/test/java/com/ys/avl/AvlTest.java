/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: AvlTest
 * Author:   nick
 * Date:     2019/12/4 10:59
 * Description: avl
 * History:
 */
package com.ys.avl;

import com.ys.Tester;
import com.ys.service.avl.AvlTree;
import com.ys.service.avl.Node;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈avl〉
 *
 * @author nick
 * @create 2019/12/4
 * @since 1.0.0
 */
public class AvlTest extends Tester {


    @Test
    public void avl() throws Exception {
        AvlTree avlTreeOld = new AvlTree();
        AvlTree avlTree = new AvlTree();
        //  int[] arr = {4, 3, 6, 5, 7, 8};//左旋转
        //   int[] arr = { 10, 12, 8, 9, 7, 6 };//右旋转
        int[] arr = {10, 11, 7, 6, 8, 9};//左右双旋转
        //添加结点
        for (int i = 0; i < arr.length; i++) {
            // 添加以前的平衡二叉树节点
            avlTreeOld.addOld(new Node(arr[i]));
            //添加节点时进行判断并且将树进行旋转，自动判断是左旋转、右旋转
            avlTree.add(new Node(arr[i]));
        }

        //遍历
        System.out.println("~~~~~~~平衡处理前~~~~~~");
        System.out.println("中序遍历");
        avlTreeOld.infixOrder();
        System.out.println("树的高度=" + avlTreeOld.getRoot().height()); //4
        System.out.println("树的左子树高度=" + avlTreeOld.getRoot().leftHeight()); // 1
        System.out.println("树的右子树高度=" + avlTreeOld.getRoot().rightHeight()); // 3
        System.out.println("当前的根结点=" + avlTreeOld.getRoot());//4


        System.out.println("~~~~~~~平衡处理后~~~~~~");
        System.out.println("中序遍历");
        avlTree.infixOrder();
        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());//6
    }
}