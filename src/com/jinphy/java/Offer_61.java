package com.jinphy.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*

时间限制：1秒 空间限制：32768K 热度指数：44497
        算法知识视频讲解
        题目描述
        从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
*/

public class Offer_61 {


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        TreeNode node;
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> layer = new ArrayList<>(n);
            while (--n >= 0) {
                node = queue.poll();
                layer.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(layer);
        }

        return result;
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
