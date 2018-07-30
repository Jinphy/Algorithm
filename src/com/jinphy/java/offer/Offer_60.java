package com.jinphy.java.offer;

import java.util.ArrayList;
import java.util.LinkedList;
/*

时间限制：1秒 空间限制：32768K 热度指数：51390
        算法知识视频讲解
        题目描述
        请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
        第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
*/

public class Offer_60 {


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        visitLayer(queue, true, result);
        return result;
    }

    private void visitLayer(LinkedList<TreeNode> queue, boolean isForWard, ArrayList<ArrayList<Integer>> result) {
        if (queue.isEmpty()) {
            return;
        }
        int n = queue.size();
        ArrayList<Integer> layer = new ArrayList<>(n);
        for (TreeNode x : queue) {
            layer.add(x.val);
        }
        result.add(layer);

        TreeNode node;
        if (isForWard) {
            // 当前层从左到右
            while (--n >= 0) {
                node = queue.remove(n);
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }

        } else {
            // 当前层从右到左
            while (--n >= 0) {
                node = queue.remove(n);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        // 遍历下一层，方向相反
        visitLayer(queue, !isForWard, result);
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
