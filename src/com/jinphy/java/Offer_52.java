package com.jinphy.java;

public class Offer_52 {


    public int[] multiply(int[] A) {
        int[] out = new int[A.length];
        int mul=1;
        out[0] = 1;
        for (int i=1;i<out.length;i++) {
            mul *= A[i - 1];
            out[i] = mul;
        }
        mul=1;
        for (int i=out.length-2;i>=0;i--) {
            mul *= A[i + 1];
            out[i] *= mul;
        }
        return out;
    }
}
