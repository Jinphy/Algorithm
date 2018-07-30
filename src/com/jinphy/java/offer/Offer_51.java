package com.jinphy.java.offer;

public class Offer_51 {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0) {
            duplication[0] = -1;
            return false;
        }
        int[] counter = new int[length];
        for (int x : numbers) {
            counter[x]++;
            if (counter[x] == 2) {
                duplication[0] = x;
                return true;
            }
        }
        return false;
    }

}
