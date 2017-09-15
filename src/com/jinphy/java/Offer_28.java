package com.jinphy.java;

import java.util.Stack;

public class Offer_28 {

    private Stack<Integer>stack;

    public void push(int node) {
        if (stack == null) {
            stack = new Stack<>();
        }
        stack.push(node);
    }

    public void pop() {
        if (stack != null) {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = Integer.MAX_VALUE;
        for (Integer x : stack) {
            if (x < min) {
                min = x;
            }
        }
        return min;
    }
}
