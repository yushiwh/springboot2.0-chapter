/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: BinarySortTree
 * Author:   nick
 * Date:     2019/11/4 11:16
 * Description: 二叉排序树
 * History:
 */
package com.ys.service.binarysorttree;

import org.springframework.stereotype.Component;

/**
 * 〈二叉排序树〉
 *
 * @author nick
 * @create 2019/11/4
 * @since 1.0.0
 */
@Component
public class BinarySortTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    /**
     * 查找要删除的结点，封装一下节点里面的方法
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 查找父结点，封装一下节点里面的方法
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }


    /**
     * //编写方法:
     * //1. 返回的 以node 为根结点的二叉排序树的最小结点的值
     * //2. 删除node 为根结点的二叉排序树的最小结点
     *
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子节点，就会找到最小值
        while ( target.left != null ) {
            target = target.left;
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delNode(target.value);
        return target.value;
    }


    /**
     * 删除结点，要分3种情况。这里比较复杂，需要看笔记进行学习整理
     * 1、删除叶子节点
     * 2、删除只有一颗子树的节点
     * 3、删除有两颗子树的节点
     *
     * @param value
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //1.需求先去找到要删除的结点  targetNode
            Node targetNode = search(value);
            //如果没有找到要删除的结点
            if (targetNode == null) {
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //去找到targetNode的父结点
            Node parent = searchParent(value);
            //1、如果要删除的结点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                //判断targetNode 是父结点的左子结点，还是右子结点
                if (parent.left != null && parent.left.value == value) {
                    //是左子结点
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    //是右子结点
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                //2、删除有两颗子树的节点
                int minVal = delRightTreeMin(targetNode.right);
                //将最小值重新赋值给删除的节点
                targetNode.value = minVal;


            } else { //3、 删除只有一颗子树的结点a
                //如果要删除的结点有左子结点
                if (targetNode.left != null) {
                    if (parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else { //  targetNode 是 parent 的右子结点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else { //如果要删除的结点有右子结点
                    if (parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else { //如果 targetNode 是 parent 的右子结点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }

            }

        }
    }

    /**
     * 添加结点的方法
     */
    public void add(Node node) {
        if (root == null) {
            //如果root为空则直接让root指向node
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }
}