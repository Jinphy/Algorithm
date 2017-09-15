package com.jinphy.java;
/*

时间限制：1秒 空间限制：32768K 热度指数：69300
        本题知识点： 链表
        算法知识视频讲解
        题目描述
        输入两个链表，找出它们的第一个公共结点。
*/

public class Offer_42 {


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        ListNode p;

        p = pHead1;
        while (p != null) {
            len1++;
            p = p.next;
        }
        p = pHead2;
        while (p != null) {
            len2++;
            p = p.next;
        }
        p = pHead1;
        ListNode q = pHead2;
        int len=0;
        if (len1 > len2) {
            len = len1 - len2;
            p = pHead1;
            q = pHead2;
        } else if (len1 < len2) {
            len = len2 - len1;
            p = pHead2;
            q = pHead1;
        }
        while (len-- > 0) {
            p = p.next;
        }
        while (p != null) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
