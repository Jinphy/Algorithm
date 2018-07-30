package com.jinphy.java.offer;

import java.util.HashMap;
import java.util.Map;
/*

时间限制：1秒 空间限制：32768K 热度指数：115085
        本题知识点： 链表
        算法知识视频讲解
        题目描述
        输入一个复杂链表（每个节点中有节点值，以及两个指针，
        一个指向下一个节点，另一个特殊指针指向任意一个节点），
        返回结果为复制后复杂链表的head。（注意，输出结果中请
        不要返回参数中的节点引用，否则判题程序会直接返回空）
*/

public class Offer_33 {


    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode head = visit(pHead, map);
        return head;
    }

    public RandomListNode visit(RandomListNode pHead,Map<RandomListNode,RandomListNode>map) {
        RandomListNode head = new RandomListNode(pHead.label);
        map.put(pHead, head);
        if (pHead.next != null) {
            head.next = map.get(pHead.next);
            if (head.next == null) {
                head.next = visit(pHead.next, map);
            }
        }
        if (pHead.random != null) {
            head.random = map.get(pHead.random);
            if (head.random == null) {
                head.random = visit(pHead.random, map);
            }
        }
        return head;
    }

    /*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/

    public class RandomListNode{
        int label;
        RandomListNode next;
        RandomListNode random;

        RandomListNode(int label) {

        }
    }
}
