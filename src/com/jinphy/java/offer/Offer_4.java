package com.jinphy.java.offer;

/*

时间限制：1秒 空间限制：32768K 热度指数：219704
        算法知识视频讲解
        题目描述
        输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
        假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
        例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
        中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
*/

public class Offer_4 {


    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = createNode(0,0,in.length-1,pre,in);
        return root;
    }

    /**
     *
     * 根据先序遍历系列pre 和中序遍历系列in 重构二叉树
     *
     * @param current 先序遍历序列数组pre的下标，表示当前要创建的二叉树的节点
     * @param left 中序遍历序列的下标，表示创建当前节点时该分支的节点左范围
     * @param right 中序遍历序列的下标，表示创建当前节点时该分支的节点左右范围
     * @param pre 先序遍历序列
     * @param in 中序遍历序列
     * @return 当前常创建的节点
     */
    private TreeNode createNode(int current, int left, int right, int[] pre, int[] in) {
        TreeNode node = new TreeNode(pre[current]);
        int parent = 0;
        for (int i = left; i <= right; i++) {
            if (in[i] == pre[current]) {
                parent = i;
            }
        }
        int leftChilds = parent - left;
        int rightChilds = right - parent;
        if (leftChilds > 0) {
            node.left = createNode(current + 1, left, parent - 1, pre, in);
        }
        if (rightChilds > 0) {
            node.right = createNode(current + leftChilds + 1, parent + 1, right, pre, in);
        }
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
