/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ArrBinaryTreeTest
 * Author:   nick
 * Date:     2019/9/17 9:12
 * Description: 测试顺序存储二叉树的遍历
 * History:
 */
package com.ys.tree;

import com.ys.Tester;
import com.ys.service.tree.ArrBinaryTree;
import org.junit.Test;

/**
 * 〈测试顺序存储二叉树的遍历〉
 *
 * @author nick
 * @create 2019/9/17
 * @since 1.0.0
 */
public class ArrBinaryTreeTest extends Tester {

    @Test
    public void testArrBinaryTree() throws Exception {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        /**
         *             1
         *           /   \
         *          2     3
         *        /   \  /  \
         *       4    5 6    7
         */

        //创建一个 ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("~~~前序遍历~~~");
        arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
        System.out.println("");
        System.out.println("~~~中序遍历~~~");
        arrBinaryTree.infixOrder(); // 4,2,5,1,6,3,7
        System.out.println("");
        System.out.println("~~~后序遍历~~~");
        arrBinaryTree.postOrder(); // 4,5,2,6,7,3,1
    }
}