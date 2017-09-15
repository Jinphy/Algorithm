package com.jinphy.java;
/*

时间限制：1秒 空间限制：32768K 热度指数：82465
        算法知识视频讲解
        题目描述
        输入一棵二叉搜索树，将该二叉搜索树转换成一个排
        序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
*/

public class Offer_34 {


    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        visit(pRootOfTree);

        return head;
    }


    public void visit(TreeNode root) {

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }
            Convert(root.left);
            root.left = left;
            left.right = root;
        }
        if (right != null) {
            while (right.left != null) {
                right = right.left;
            }
            Convert(root.right);
            root.right = right;
            right.left = root;
        }
    }


    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
