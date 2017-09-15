package com.jinphy.java;

import java.util.LinkedList;
import java.util.Queue;
/*

时间限制：1秒 空间限制：32768K 热度指数：93011
        算法知识视频讲解
        题目描述
        操作给定的二叉树，将其变换为源二叉树的镜像。
        输入描述:
        二叉树的镜像定义：源二叉树
             8
           /  \
          6   10
         / \  / \
        5  7 9 11
        镜像二叉树
              8
            /  \
          10   6
         / \  / \
        11 9 7  5
*/

public class Offer_26 {

    public static void main(String... args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(6);
        root.left.left.left= new TreeNode(5);
        root.left.left.left.left = new TreeNode(4);
        Mirror(root);
    }

    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(root);
        TreeNode node ;
        while (!queue1.isEmpty()) {
            node = queue1.poll();
            queue.add(node);
            if (node.right != null) {
                queue1.add(node.right);
            }
            if (node.left != null) {
                queue1.add(node.left);
            }
        }
        queue1.add(queue.poll());

        boolean hasLeft=false;
        boolean hasRight=false;
        while (!queue1.isEmpty()) {
            node = queue1.poll();
            if (node.right != null) {
                node.right = null;
                hasLeft = true;
            }
            if (node.left != null) {
                node.left = null;
                hasRight = true;
            }
            if (hasLeft) {
                node.left = queue.poll();
                queue1.add(node.left);
                hasLeft=false;
            }
            if (hasRight) {
                node.right = queue.poll();
                queue1.add(node.right);
                hasRight = false;
            }
        }

    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
