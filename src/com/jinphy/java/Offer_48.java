package com.jinphy.java;

import java.util.ArrayList;

public class Offer_48 {


    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        if (m == 1) {
            return n - 1;
        }
        ArrayList<Integer> child = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            child.add(i);
        }
        int index = -1;
        while (child.size() > 1) {
            index = (index + m) % child.size();
            child.remove(index--);
        }
        return child.get(0);
    }
}
