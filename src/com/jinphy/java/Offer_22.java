package com.jinphy.java;
/*

时间限制：1秒 空间限制：32768K 热度指数：235346
        本题知识点： 链表
        算法知识视频讲解
        题目描述
        输入一个链表，输出该链表中倒数第k个结点。
*/


public class Offer_22 {


    public ListNode FindKthToTail(ListNode head,int k) {

        if(head==null){
            return null;
        }
        ListNode node = head;
        int n=0;
        do {
            n++;
            node = node.next;
        } while (node != null);
        if(n<k){
            return null;
        }
        n -=k;
        while (n-- > 0) {
            head = head.next;
        }
        return head;
    }
    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
