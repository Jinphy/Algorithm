package com.jinphy.java;
/*

时间限制：1秒 空间限制：32768K 热度指数：96796
        本题知识点： 链表
        算法知识视频讲解
        题目描述
        在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
        重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
*/

public class Offer_57 {



    public ListNode deleteDuplication(ListNode pHead){
        return delete(pHead);
    }

    /*
    * 在一个排好序的，删除那些出现大于1次的元素，例如：1 1 2 3 3 4 5 删除后为 2 4 5
    * 采用递归方法删除，每次递归都从表头开始删，即每次都找到一个合法的表头（在上例中 2是第一个合法的表头）
    * 然后在找下一个表头（当前表头的下一个合法表头，上例中为4），以此递归知道找到所有表头
    *
    * */
    private ListNode delete(ListNode head) {
        if (head == null || head.next == null) {
            // 如果当前表头为空或者只有一个元素则返回该表头
            return head;
        }
        // 从当前表头开始找，直到找到没有重复的合法表头
        // 例如1 1 2 2 3 4 ，则合法表头是3
        ListNode node = head.next;
        boolean equal = false;// 标志相邻节点是否相等
        while (node!= null) {
            if (node.val == head.val) {
                node = node.next;
                equal = true;
            } else {
                equal = false;
                if (node == head.next) {
                    break;
                } else {
                    head = node;
                    node = node.next;
                }
            }
        }// end while
        // node ==null 说明后面没有节点了
        if (node == null) {
            // 判断前面的节点是否重复
            if (equal) {
                // 重复，则返回null
                return null;
            }
            // 不重复则返回当前找到的表头
            return head;
        }

        // 找到当前表头，继续找下一个表头
        head.next = delete(head.next);
        return head;
    }

    class ListNode{
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
