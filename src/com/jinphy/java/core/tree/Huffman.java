package com.jinphy.java.core.tree;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Huffman {

    public static class Node{

        public int val;

        public Node lChild;

        public Node rChild;
        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }


    }

    public static Node create(int[] nums) {
        List<Node> list = new LinkedList<>();
        for (int val : nums) {
            list.add(new Node(val));
        }
        Node lChild;
        Node rChild;
        int l;
        int r;
        while (list.size() > 1) {
            lChild = list.get(0);
            rChild = list.get(1);
            l = 0;
            r = 1;
            if (lChild.val > rChild.val) {
                Node temp = lChild;
                lChild = rChild;
                rChild = temp;
                l = 1;
                r = 0;
            }
            for (int i = 2; i < list.size(); i++) {
                Node temp = list.get(i);
                if (temp.val < lChild.val) {
                    rChild = lChild;
                    r = l;
                    lChild = temp;
                    l = i;
                } else if (temp.val < rChild.val) {
                    rChild = temp;
                    r = i;
                }
            }
            list.remove(lChild);
            list.remove(rChild);

            Node parent = new Node(lChild.val + rChild.val);
            parent.lChild = lChild;
            parent.rChild = rChild;
            list.add(parent);
        }
        return list.get(0);
    }



    public static void preOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrder(head.lChild);
        preOrder(head.rChild);
    }


}
