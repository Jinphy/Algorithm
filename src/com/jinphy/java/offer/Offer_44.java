package com.jinphy.java.offer;
/*

时间限制：1秒 空间限制：32768K 热度指数：65571
        算法知识视频讲解
        题目描述
        输入一棵二叉树，判断该二叉树是否是平衡二叉树。


        平衡二叉树：一棵二叉树为平衡二叉树当且仅当该树为空或者任何节点的左右子树的高度差不超过1
*/

public class Offer_44 {


    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        Flag flag = new Flag();
        visit(root, flag);

        return flag.isBalance;
    }

    public int visit(TreeNode root, Flag flag) {
        if (!flag.isBalance || root == null) {
            return 0;
        }
        int left = visit(root.left, flag);
        int right = visit(root.right, flag);
        if (!flag.isBalance) {
            return 0;
        }
        int deep = 1;
        if (Math.abs(left - right) > 1) {
            flag.isBalance = false;
            return 0;
        }
        deep += Math.max(left, right);
        return deep;
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public class Flag{
        boolean isBalance = true;
    }
}
