package com.jinphy.java.offer;

import java.util.Stack;
/*

时间限制：1秒 空间限制：32768K 热度指数：145292
        本题知识点： 队列 栈
        算法知识视频讲解
        题目描述
        用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
*/

public class Offer_5 {


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int out = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return out;
    }
}
