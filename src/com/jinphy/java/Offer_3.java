package com.jinphy.java;

import java.util.ArrayList;

public class Offer_3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> out = new ArrayList<>();
        while (listNode != null) {
            out.add(0, listNode.val);
            listNode = listNode.next;
        }
        return out;
    }

    public static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
