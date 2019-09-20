/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: HeroNode
 * Author:   nick
 * Date:     2019/9/17 15:42
 * Description: 节点定义
 * History:
 */
package com.ys.service.tree.threadedbinarytree;

import lombok.Data;

/**
 * 〈节点定义〉
 *
 * @author nick
 * @create 2019/9/17
 * @since 1.0.0
 */
@Data
public class HeroNode {
    private int no;
    private String name;
    /**
     * //默认null
     */
    private HeroNode left;
    /**
     * //默认null
     */
    private HeroNode right;

    /**
     * //父节点的指针（为了后序线索化使用）
     */
    private HeroNode parent;

    /**
     * //说明
     * //1. 如果leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
     * //2. 如果rightType == 0 表示指向是右子树, 如果 1表示指向后继结点
     */
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }


}