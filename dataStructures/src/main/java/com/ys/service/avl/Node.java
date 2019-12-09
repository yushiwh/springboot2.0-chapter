/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Node
 * Author:   nick
 * Date:     2019/12/4 10:57
 * Description: 平衡二叉树的节点
 * History:
 */
package com.ys.service.avl;

/**
 * 〈平衡二叉树的节点，排序遍历的方法〉
 *
 * @author nick
 * @create 2019/12/4
 * @since 1.0.0
 */
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 返回左子树的高度
     *
     * @return
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    /**
     * 返回右子树的高度
     *
     * @return
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    /**
     * 返回 以该结点为根结点的树的高度
     *
     * @return
     */
    public int height() {
        //Max.max()比较两个相同类型的值的大小，去较大的一个
        //left == null ? 0 : left.height()  查找左子树的最大的高度，递归的方式
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 左旋转方法，一共6步
     */
    private void leftRotate() {
        //创建新的结点，以当前根结点的值
        Node newNode = new Node(value);
        //把新的结点的左子树设置成当前结点的左子树
        newNode.left = left;
        //把新的结点的右子树设置成当前结点的右子树的左子树
        newNode.right = right.left;
        //把当前结点的值替换成右子结点的值
        value = right.value;
        //把当前结点的右子树设置成当前结点右子树的右子树
        right = right.right;
        //把当前结点的左子树(左子结点)设置成新的结点
        left = newNode;
    }

    /**
     * 右旋转，一共6步
     */
    private void rightRotate() {
        //创建新的结点，以当前根结点的值
        Node newNode = new Node(value);
        //把新的结点的右子树设置成当前结点的右子树
        newNode.right = right;
        //把新的结点的左子树设置成当前结点的左子树的右子树
        newNode.left = left.right;
        //把当前结点的值替换成左子结点的值
        value = left.value;
        //把当前结点的左子树设置成当前结点左子树的左子树
        left = left.left;
        //把当前结点的右子树(右子结点)设置成新的结点
        right = newNode;
    }
    // 查找要删除的结点

    /**
     * @param value 希望删除的结点的值
     * @return 如果找到返回该结点，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {
            // 找到就是该结点
            return this;
        } else if (value < this.value) {
            // 如果查找的值小于当前结点，向左子树递归查找
            // 如果左子结点为空
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else { // 如果查找的值不小于当前结点，向右子树递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }
    // 查找要删除结点的父结点

    /**
     * @param value 要找到的结点的值
     * @return 返回的是要删除的结点的父结点，如果没有就返回null
     */
    public Node searchParent(int value) {
        // 如果当前结点就是要删除的结点的父结点，就返回
        if (this.right != null && this.right.value == value) {
            return this;
        } else if (this.left != null && this.left.value == value) {
            return this;
        } else {
            // 如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                // 向左子树递归查找
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                // 向右子树递归查找
                return this.right.searchParent(value);
            } else {
                // 没有找到父结点
                return null;
            }
        }
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    /**
     * // 添加结点的方法
     * // 递归的形式添加结点，注意需要满足二叉排序树的要求
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 判断传入的结点的值，和当前子树的根结点的值关系
        if (node.value < this.value) {
            // 如果当前结点左子结点为null
            if (this.left == null) {
                this.left = node;
            } else {
                // 递归的向左子树添加
                this.left.add(node);
            }
        } else { // 添加的结点的值大于 当前结点的值
            if (this.right == null) {
                this.right = node;
            } else {
                // 递归的向右子树添加
                this.right.add(node);
            }
        }
        //当添加完一个结点后，如果: (右子树的高度-左子树的高度) > 1 , 左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果它的右子树的左子树的高度大于它的右子树的右子树的高度（为了进行双旋转）
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //先对右子结点进行右旋转
                right.rightRotate();
                //然后在对当前结点进行左旋转
            } else {
                //直接进行左旋转即可
            }
            leftRotate(); //左旋转..
            return; //已经平衡，就必须要!!!后面就不需要重新进行判断了
        }
        //当添加完一个结点后，如果 (左子树的高度 - 右子树的高度) > 1, 右旋转
        if (leftHeight() - rightHeight() > 1) {
            //如果它的左子树的右子树高度大于它的左子树的高度（为了进行双旋转）
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //先对当前结点的左结点(左子树)->左旋转
                left.leftRotate();
                //再对当前结点进行右旋转
            } else {
                //直接进行右旋转即可
            }
            rightRotate();
            //  return ;
        }
    }


    /**
     * 未进行平衡处理,不进行左右旋转
     * 主要是为了进行对比看看旋转后的树的高度
     *
     * @param node
     */
    public void addOld(Node node) {
        if (node == null) {
            return;
        }
        // 判断传入的结点的值，和当前子树的根结点的值关系
        if (node.value < this.value) {
            // 如果当前结点左子结点为null
            if (this.left == null) {
                this.left = node;
            } else {
                // 递归的向左子树添加
                this.left.add(node);
            }
        } else { // 添加的结点的值大于 当前结点的值
            if (this.right == null) {
                this.right = node;
            } else {
                // 递归的向右子树添加
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