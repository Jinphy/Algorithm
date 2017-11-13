package com.jinphy.java;

import java.util.ArrayList;
/*

时间限制：1秒 空间限制：32768K 热度指数：52666
        算法知识视频讲解
        题目描述
        给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
        例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么
        一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
        针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
        {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
        {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

*/

public class Offer_65 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num.length < size || size<1) {
            return result;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (max < num[i]) {
                max = num[i];
            }
        }
        result.add(max);
        int n = num.length-size+1;
        for(int i=1;i<n;i++) {
            int end = i+size-1;
            if (num[end] >= max) {
                max = num[end];
            } else {
                max = num[i];
                for (int j=i+1;j<=end;j++) {
                    if (num[j] > max) {
                        max = num[j];
                    }
                }
            }
            result.add(max);
        }

        return result;
    }
}
