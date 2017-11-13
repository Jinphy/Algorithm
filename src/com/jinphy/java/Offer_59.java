package com.jinphy.java;

import java.util.LinkedList;
import java.util.Queue;
/*

时间限制：1秒 空间限制：32768K 热度指数：46891
        算法知识视频讲解
        题目描述
        请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

*/

public class Offer_59 {


    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null ||(pRoot.left == null && pRoot.right == null)) {
            return true;
        }
        if (pRoot.left == null || pRoot.right == null) {
            return false;
        }
        TreeNode left = pRoot.left;
        TreeNode right = pRoot.right;
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.add(left);
        rightQueue.add(right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            left = leftQueue.poll();
            right = rightQueue.poll();
            if (left.val != right.val) {
                return false;
            }
            if (!push(left.left, right.right, leftQueue, rightQueue)) {
                return false;
            }
            if (!push(left.right, right.left, leftQueue, rightQueue)) {
                return false;
            }
        }
        return true;
    }

    private boolean push(TreeNode left, TreeNode right, Queue<TreeNode> leftQueue, Queue<TreeNode> rightQueue) {
        if (left != null && right != null) {
            leftQueue.add(left);
            rightQueue.add(right);
            return true;
        } else if (left == null && right == null) {
            return true;
        } else {
            return false;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
