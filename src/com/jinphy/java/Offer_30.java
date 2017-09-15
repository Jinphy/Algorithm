package com.jinphy.java;
/*

时间限制：1秒 空间限制：32768K 热度指数：117165
        本题知识点： 栈
        算法知识视频讲解
        题目描述
        输入两个整数序列，第一个序列表示栈的压入顺序，
        请判断第二个序列是否为该栈的弹出顺序。假设压入栈
        的所有数字均不相等。例如序列1,2,3,4,5是某栈的
        压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
        但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Offer_30 {


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> out = new ArrayList<>();
        if (root == null) {
            return out;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            out.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return out;
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
