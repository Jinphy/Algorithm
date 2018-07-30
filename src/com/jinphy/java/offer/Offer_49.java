package com.jinphy.java.offer;

public class Offer_49 {

    public static void main(String[] args) {
        System.out.println(Add(3, -4));
    }

    public static int Add(int num1,int num2) {
        int result=0;
        int carry=0;
        int bit=1;
        int n=32;
        while (n-- > 0) {
            int a = num1 & bit;
            int b = num2 & bit;
            if (a > 0 && b > 0) {
                if (carry == 1) {
                    result = result | bit;
                } else {
                    carry = 1;
                }
            } else if (a > 0 || b > 0) {
                if (carry == 0) {
                    result = result | bit;
                    carry = 0;
                } else {
                    carry = 1;
                }
            } else {
                if (carry == 1) {
                    result = result | bit;
                }
                carry = 0;
            }
            bit <<= 1;
        }
        return result;
    }
}
