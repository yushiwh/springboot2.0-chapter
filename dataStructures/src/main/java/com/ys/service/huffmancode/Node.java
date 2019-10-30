/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Node
 * Author:   nick
 * Date:     2019/10/10 16:18
 * Description: 结点
 * History:
 */
package com.ys.service.huffmancode;

/**
 * 〈结点〉
 * 创建Node ,待数据和权值
 *
 * @author nick
 * @create 2019/10/10
 * @since 1.0.0
 */

public class Node implements Comparable<Node> {
    /**
     * // 存放数据(字符)本身，比如'a' => 97    ' ' => 32
     */
    Byte data;
    /**
     * //权值, 表示字符出现的次数
     */
    int weight;
    /**
     * 左节点
     */
    Node left;
    /**
     * 右节点
     */
    Node right;

    public Node(Byte data, int weight) {

        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.weight - o.weight;
    }
    @Override
    public String toString() {
        return "Node [data = " + data + " weight=" + weight + "]";
    }

    /**
     *  前序遍历
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
}