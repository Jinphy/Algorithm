package com.jinphy.java;

public class Offer_58 {


    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        TreeLinkNode parent = pNode.next;
        while (parent != null) {
            if (parent.left == pNode) {
                return parent;
            } else {
                pNode = parent;
                parent = parent.next;
            }
        }
        return null;
    }


    class TreeLinkNode{
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
