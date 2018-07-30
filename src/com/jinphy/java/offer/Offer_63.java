package com.jinphy.java.offer;
/*

时间限制：1秒 空间限制：32768K 热度指数：60263
        算法知识视频讲解
        题目描述
        给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
*/


public class Offer_63 {


    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) {
            return null;
        }
        Counter counter = new Counter();
        counter.target = k;
        return visit(pRoot, counter);
    }

    private TreeNode visit(TreeNode root, Counter counter) {
        if (root.left != null) {
            TreeNode result;
            result = visit(root.left, counter);
            if (result != null) {
                return result;
            }
        }
        if (++counter.val == counter.target) {
            return root;
        }
        if (root.right != null) {
            return visit(root.right, counter);
        }
        return null;
    }

    class Counter{
        int val;
        int target;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
