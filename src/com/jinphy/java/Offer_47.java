package com.jinphy.java;

import java.util.ArrayList;

/*

时间限制：1秒 空间限制：32768K 热度指数：68518
        算法知识视频讲解
        题目描述
        输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
        输出描述:
        对应每个测试案例，输出两个数，小的先输出。
*/

public class Offer_47 {


    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length < 2) {
            return result;
        }
        int i=0;
        int j = array.length-1;
        while (i < j) {
            int x = array[i] + array[j];
            if (x == sum) {
                result.add(array[i]);
                result.add(array[j]);
                break;
            }
            if (x > sum) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
