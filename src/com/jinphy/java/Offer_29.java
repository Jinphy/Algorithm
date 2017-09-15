package com.jinphy.java;

import java.util.Stack;

public class Offer_29 {


    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (popA.length != pushA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for (int i=0;i<pushA.length;i++) {
            if (pushA[i] == popA[j]) {
                j++;
                continue;
            }
            if (!stack.empty() && stack.peek() == popA[j]) {
                j++;
            }
            stack.push(pushA[i]);
        }
        while (j != popA.length) {
            if (popA[j++] != stack.pop()) {
                return false;
            }
        }
        return true;
    }

}
