/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: HeroNode
 * Author:   nick
 * Date:     2019/9/11 14:15
 * Description: 创建HeroNode 结点
 * History:
 */
package com.ys.service.tree;


import lombok.Data;

/**
 * 〈创建HeroNode 结点〉
 *
 * @author nick
 * @create 2019/9/11
 * @since 1.0.0
 */
@Data
public class HeroNode {
    private int no;
    private String name;
    /**
     * 左节点，默认为null
     */
    private HeroNode left;
    /**
     * 右节点，默认为null
     */
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }


    /**
     * 删除非根节点的叶子节点
     * 将数的右节点进行接上去
     * <p>
     * 如
     * 1
     * /  \
     * 2    3
     * / \  / \
     * 6  7 5  4
     * <p>
     * 删除3后，变成
     * 1
     * /  \
     * 2    4
     * / \
     * 6  7
     *
     * @param no
     */
    public void delNodeLeaf(int no) {

        //判断左子树
        if (this.left != null && this.left.no == no) {
            //此处进行赋值
            //进行判断，如果右边有就把右边接上，右边没有就接左边。左边没有就职位null
            if (null != this.left.right) {
                this.left = this.left.right;
            } else if (null != this.left.left) {
                this.left = this.left.left;
            } else {
                this.left = null;
            }

            return;
        }
        //3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        //判断右子树
        if (this.right != null && this.right.no == no) {
            //此处进行赋值

            //进行判断，如果右边有就把右边接上，右边没有就接左边。左边没有就职位null
            if (null != this.right.right) {
                this.right = this.right.right;
            } else if (null != this.right.left) {
                this.right = this.right.left;
            } else {
                this.right = null;
            }
            return;
        }

        //上面的左子树和右子树节点都不能删除，就开始进行递归处理
        //4.我们就需要向左子树进行递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
        //5.则应当向右子树进行递归删除
        if (this.right != null) {
            this.right.delNode(no);
        }
    }


    /**
     * //递归删除结点
     * //1.如果删除的节点是叶子节点，则删除该节点
     * //2.如果删除的节点是非叶子节点，则删除该子树
     *
     * @param no
     */
    public void delNode(int no) {

        //思路
        /**
         * 首先要处理是否是一个空树
         *
         * 1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
         * 2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
         * 3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
         * 4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
         * 5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.
         *
         * 	2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
         */

        //判断左子树
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        //判断右子树
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        //上面的左子树和右子树节点都不能删除，就开始进行递归处理
        //4.我们就需要向左子树进行递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
        //5.则应当向右子树进行递归删除
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    /**
     * 编写前序遍历的方法，用递归的方法进行遍历
     * 父节点--》左子树--》右子树
     */
    public void preOrder() {
        //先输出父结点
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历，用递归进行处理
     * 左子树--》父节点--》右子树
     */
    public void infixOrder() {

        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父结点
        System.out.println(this);
        //递归向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历，用递归进行处理
     * 左子树--》右子树--》父节点
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }


    /**
     * //前序遍历查找
     *
     * @param no 查找no
     * @return 如果找到就返回该Node ,如果没有找到返回 null
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        //比较当前结点是不是
        if (this.no == no) {
            return this;
        }
        //1.则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到结点，则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            //说明我们左子树找到
            return resNode;
        }
        //1.左递归前序查找，找到结点，则返回，否继续判断，
        //2.当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 中序遍历查找
     */
    public HeroNode infixOrderSearch(int no) {
        //判断当前结点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入中序查找");
        //如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
        if (this.no == no) {
            return this;
        }
        //否则继续进行右递归的中序查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;

    }

    /**
     * 后序遍历查找
     */
    public HeroNode postOrderSearch(int no) {

        //判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        //说明在左子树找到
        if (resNode != null) {
            return resNode;
        }

        //如果左子树没有找到，则向右子树递归进行后序遍历查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入后序查找");
        //如果左右子树都没有找到，就比较当前结点是不是
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}