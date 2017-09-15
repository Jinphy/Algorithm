package com.jinphy.java;

public class Offer_31 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length <= 0) {
            return false;
        }
        return isBST(sequence, 0, sequence.length - 1);

    }

    /**
     * 二叉搜索树的特点是，某个节点的左分支的所有节点都小于该节点，
     * 有分支的所有节点都大于该节点，在后续遍历中，肯定是先遍历左分支，
     * 再遍历右分支，最后遍历该节点，所以当前序列的最后一个必定是当前遍历的
     * 节点，从序列开始所搜，在出现大于最后一个元素的值出现前，所有小于
     * 最后一个元素值得元素都是左分支的节点，当出现大于最后一个元素值得元素后，接下来
     * 的所有元素都必须也大于最后一个元素，这部分为右分支的所有节点，所以只要
     * 右分支中有小于最后一个元素值得元素出现，则，该序列肯定不是二叉搜索树的后续遍历序列
     *
     * */
    public boolean isBST(int[] sequence, int left, int right) {
        if (left >= right) {
            return true;
        }
        int i;
        for (i = left; i < right; i++) {
            if (sequence[i] > sequence[right]) {
                break;
            }
        }
        for (int j=i+1;j<right;j++) {
            if (sequence[j] < sequence[right]) {
                return false;
            }
        }
        return isBST(sequence, left, i - 1) && isBST(sequence, i, right-1);
    }
}
