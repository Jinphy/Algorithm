package com.jinphy.java;
/*

时间限制：1秒 空间限制：32768K 热度指数：173636
        本题知识点： 链表
        算法知识视频讲解
        题目描述
        输入一个链表，反转链表后，输出链表的所有元素。
*/


public class Offer_23 {

    public ListNode reverseList(ListNode head) {
        ListNode child = head;
        if (child == null) {
            return null;
        }
        ListNode current = head.next;
        if (current == null) {
            return head;
        }
        ListNode parent = current.next;
        current.next = child;
        child.next = null;
        if (parent == null) {
            return current;
        }
        while (parent.next != null) {
            child = current;
            current = parent;
            parent = parent.next;
            current.next = child;
        }
        parent.next = current;
        return parent;
    }

    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
