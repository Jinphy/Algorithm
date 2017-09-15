package com.jinphy.java;

/*

时间限制：1秒 空间限制：32768K 热度指数：137155
        算法知识视频讲解
        题目描述
        输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
*/


public class Offer_19 {


    public int numberOf1(int n) {
        int counter=0;

        for (int i=0;i<32;i++) {
            if ((n & 1) == 1) {
                counter++;
            }
            n = n>>>1;
        }
        return  counter;
    }
}
