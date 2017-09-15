package com.jinphy.java;
/*

时间限制：1秒 空间限制：32768K 热度指数：177250
        本题知识点： 数组
        算法知识视频讲解
        题目描述
        输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
        使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组
        的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
*/


public class Offer_21 {

    public void reOrderArray(int [] array) {
        int left = 0;
        int odd;
        int n = array.length-1;
        for (int i = 0; i < n; i++) {
            if ((array[i] & 1) == 1) {
                continue;
            }
            int j;
            for (j = i+1;j<array.length;j++) {
                if ((array[j] & 1) == 1) {
                    break;
                }
            }
            if (j == array.length) {
                break;
            }
            odd = array[j];
            do {
                array[j] = array[--j];
            } while (j > i);
            array[i] = odd;
        }
    }
}
