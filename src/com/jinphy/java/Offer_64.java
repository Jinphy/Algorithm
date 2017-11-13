package com.jinphy.java;

import java.util.ArrayList;
/*

时间限制：1秒 空间限制：32768K 热度指数：37814
        算法知识视频讲解
        题目描述
        如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
        那么中位数就是所有数值排序之后位于中间的数值。如果从数据流
        中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

*/


public class Offer_64 {

    ArrayList<Integer> nums = new ArrayList<>();

    public void Insert(Integer num) {
        int n = nums.size()-1;
        if (n == -1) {
            nums.add(num);
            return;
        }
        if (num >= nums.get(n)) {
            nums.add(num);
            return;
        }
        for (int i=0;i<=n;i++) {
            if (num < nums.get(i)) {
                nums.add(i, num);
                return;
            }
        }
    }

    public Double GetMedian() {
        int n = nums.size();
        int i = n >> 1;
        if (n % 2 == 0) {
            return (nums.get(i) + nums.get(i - 1)) / 2.0;
        } else {
            return (double) nums.get(i);
        }
    }
}
