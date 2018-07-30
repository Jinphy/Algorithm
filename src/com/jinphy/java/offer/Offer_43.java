package com.jinphy.java.offer;
/*

时间限制：1秒 空间限制：32768K 热度指数：52224
        算法知识视频讲解
        题目描述
        输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

*/

public class Offer_43 {


    public int TreeDepth(TreeNode root) {
        return visit(root);
    }

    public int visit(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result=1;

        result += Math.max(visit(root.left), visit(root.right));

        return result;
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}

