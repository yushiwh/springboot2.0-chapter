package com.ys.service.tree;

/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: BinaryTree
 * Author:   nick
 * Date:     2019/9/11 14:14
 * Description: 定义BinaryTree 二叉树
 * History:
 */

import org.springframework.stereotype.Component;

/**
 * 〈定义BinaryTree 二叉树〉
 *
 * @author nick
 * @create 2019/9/11
 * @since 1.0.0
 */
@Component
public class BinaryTree {


    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 删除结点
     */
    public void delNode(int no) {

        if (root != null) {
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除~");
        }
    }

    /**
     * 删除结点,树叶节点
     */
    public void delNodeLeaf(int no) {
        if (root != null) {
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNodeLeaf(no);
            }
        } else {
            System.out.println("空树，不能删除~");
        }
    }


    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 前序遍历
     */
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * 中序遍历
     */
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * 后序遍历
     */
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}