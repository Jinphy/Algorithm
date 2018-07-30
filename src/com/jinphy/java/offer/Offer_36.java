package com.jinphy.java.offer;

import java.util.Arrays;
/*

时间限制：1秒 空间限制：32768K 热度指数：114278
        本题知识点： 数组
        算法知识视频讲解
        题目描述
        数组中有一个数字出现的次数超过数组长度的一半，
        请找出这个数字。例如输入一个长度为9的
        数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现
        了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
*/

public class Offer_36 {


    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        Arrays.sort(array);
        int maxCount = Integer.MIN_VALUE;
        int maxValue =0;
        int count = 1;
        int halfLen = array.length>>1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                if (++count > halfLen) {
                    return array[i];
                }
            } else {
                count=1;
            }
        }
        return 0;
    }

}
