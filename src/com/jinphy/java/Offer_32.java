package com.jinphy.java;

import java.util.ArrayList;
import java.util.Stack;
/*

时间限制：1秒 空间限制：32768K 热度指数：120325
        算法知识视频讲解
        题目描述
        输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入
        整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
*/

public class Offer_32 {


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        preDFS(root,0, target,path, result);
        return result;
    }

    public void preDFS(TreeNode root, int sum, int target,Stack<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (root == null) {
            return;
        }
        path.push(root.val);
        sum += root.val;
        if (root.left == null && root.right == null && sum == target) {
            ArrayList<Integer> route = new ArrayList<>();
            route.addAll(path);
            result.add(route);
        }
        preDFS(root.left, sum, target, path, result);
        preDFS(root.right, sum, target, path, result);
        path.pop();
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
