/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Node
 * Author:   nick
 * Date:     2019/10/10 10:33
 * Description: 节点
 * History:
 */
package com.ys.service.huffmantree;

/**
 * 〈节点〉
 *
 * @author nick
 * @create 2019/10/10
 * @since 1.0.0
 */

// 创建结点类
// 为了让Node 对象支持排序Collections集合排序
// 让Node 实现Comparable接口
public class Node implements Comparable<Node> {
    /**
     * 结点权值
     */

    int value;
    /**
     * //字符
     */
    char c;
    /**
     * // 指向左子结点
     */
    Node left;
    /**
     * // 指向右子结点
     */
    Node right;


    /**
     * //写一个前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        // 表示从小到大排序
        return this.value - o.value;
    }
}