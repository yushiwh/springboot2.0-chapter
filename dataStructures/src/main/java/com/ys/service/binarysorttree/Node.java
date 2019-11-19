/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Node
 * Author:   nick
 * Date:     2019/11/4 11:17
 * Description: 节点数据
 * History:
 */
package com.ys.service.binarysorttree;

/**
 * 〈节点数据〉
 *
 * @author nick
 * @create 2019/11/4
 * @since 1.0.0
 */
public class Node {
    /**
     * 值
     */
    int value;
    /**
     * 左子节点
     */
    Node left;
    /**
     * 右子节点
     */
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }


    /**
     * 查找要删除的结点
     *
     * @param value 希望删除的结点的值
     * @return 如果找到返回该结点，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {
            //找到就是该结点
            return this;
        } else if (value < this.value) {
            //如果查找的值小于当前结点，向左子树递归查找
            //如果左子结点为空
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else { //如果查找的值不小于当前结点，向右子树递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }

    }

    /**
     * 查找要删除结点的父结点
     *
     * @param value 要找到的结点的值
     * @return 返回的是要删除的结点的父结点，如果没有就返回null
     */
    public Node searchParent(int value) {
        //如果当前结点就是要删除的结点的父结点，就返回
        //为了避免if里面较为复杂的条件判断，特地使用一个变量进行赋值后判断
        boolean flag = (this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value);
        if (flag) {
            //直到找到相等的值的时候
            return this;
        } else {
            //如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                //向左子树递归查找
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                //向右子树递归查找
                return this.right.searchParent(value);
            } else {
                // 没有找到父结点
                return null;
            }
        }

    }


    /**
     * //添加结点的方法
     * //递归的形式添加结点，注意需要满足二叉排序树的要求
     * <p>
     * 左子节点的值比当前节点小，右子节点的值比当前节点大。如果相同，放在左和右都是可以的。
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入的结点的值，和当前子树的根结点的值关系
        if (node.value < this.value) {
            //如果当前结点左子结点为null
            if (this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else { //添加的结点的值大于 当前结点的值
            if (this.right == null) {
                this.right = node;
            } else {
                //递归的向右子树添加
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

}