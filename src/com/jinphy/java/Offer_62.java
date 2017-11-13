package com.jinphy.java;

import java.util.LinkedList;
import java.util.Queue;
/*

时间限制：1秒 空间限制：32768K 热度指数：51847
        算法知识视频讲解
        题目描述
        请实现两个函数，分别用来序列化和反序列化二叉树
*/

public class Offer_62 {

    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        String nullValue = "#";
        String split = " ";
        StringBuilder builder = new StringBuilder(root.val + split);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                builder.append(node.left.val + split);
            } else {
                builder.append(nullValue + split);
            }

            if (node.right != null) {
                queue.add(node.right);
                builder.append(node.right.val + split);
            } else {
                builder.append(nullValue + split);
            }
        }
        return builder.toString().trim();
    }

    TreeNode Deserialize(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.charAt(0) == '#') {
            return null;
        }
        String[] split = str.split(" {1,}");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        int i = 1;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (!split[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(split[i++]));
                queue.add(node.left);
            } else {
                i++;
            }
            if (!split[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(split[i++]));
                queue.add(node.right);
            } else {
                i++;
            }
        }
        return root;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
