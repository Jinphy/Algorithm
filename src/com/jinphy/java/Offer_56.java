package com.jinphy.java;

import java.util.HashMap;
import java.util.Map;

public class Offer_56 {


    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Map<ListNode, Integer> map = new HashMap<>();

        ListNode node = pHead;
        while (node != null) {
            if (map.get(node) == null) {
                map.put(node, 0);
                node = node.next;
            } else {
                return node;
            }
        }
        return null;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
