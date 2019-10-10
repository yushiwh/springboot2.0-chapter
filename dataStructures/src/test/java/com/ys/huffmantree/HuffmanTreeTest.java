/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ArrBinaryTreeTest
 * Author:   nick
 * Date:     2019/9/17 9:12
 * Description: 测试顺序存储二叉树的遍历
 * History:
 */
package com.ys.huffmantree;

import com.ys.Tester;
import com.ys.service.huffmantree.Huffmantree;
import com.ys.service.huffmantree.Node;
import com.ys.service.tree.ArrBinaryTree;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 霍夫曼树测试
 *
 * @author nick
 * @create 2019/9/17
 * @since 1.0.0
 */
public class HuffmanTreeTest extends Tester {

    @Autowired
    private Huffmantree huffmantre;

    @Test
    public void testHuffmanTree() throws Exception {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = huffmantre.createHuffmanTree(arr);

        //测试一把
        huffmantre.preOrder(root); //
    }
}