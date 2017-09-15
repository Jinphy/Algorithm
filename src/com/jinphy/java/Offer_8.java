package com.jinphy.java;
/*

时间限制：1秒 空间限制：32768K 热度指数：119828
        算法知识视频讲解
        题目描述
        一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
*/


public class Offer_8 {

    public int jumpFloor(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] jumps = new int[n + 1];
        jumps[0] = 1;
        int current=0;
        // 跳第i 个台阶时，可以从当前台阶的前面所有台阶跳过来，并且
        // 也可以从开始的位置跳过来，所以每个台阶都要加上jumps[0]=1
        for (int i=1;i<=n;i++) {
            for (int j=0;j<i;j++) {
                jumps[i] += jumps[j];
            }

        }
        return jumps[n];
    }

}
