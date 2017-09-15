package com.jinphy.java;


import java.util.LinkedList;
import java.util.Queue;
/*

时间限制：1秒 空间限制：32768K 热度指数：157021
        算法知识视频讲解
        题目描述
        输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
*/


public class Offer_25 {


    public boolean HasSubtree(TreeNode a,TreeNode b) {
        if (a == null || b == null) {
            return false;
        }
        if (a.val == b.val && contains(a,b)) {
            return true;
        }
        if (HasSubtree(a.left, b)) {
            return true;
        }
        return HasSubtree(a.right, b);

    }

    private boolean contains(TreeNode a, TreeNode b) {
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        queueA.add(a);
        queueB.add(b);
        while (!queueB.isEmpty()) {
            TreeNode bb = queueB.poll();
            TreeNode aa = queueA.poll();
            if (aa.val != bb.val) {
                return false;
            }
            if (bb.left != null) {
                if (aa.left == null) {
                    return false;
                } else {
                    queueA.add(aa.left);
                    queueB.add(bb.left);
                }
            }
            if (bb.right != null) {
                if (aa.right == null) {
                    return false;
                } else {
                    queueA.add(aa.right);
                    queueB.add(bb.right);
                }
            }
        }

        return true;

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
