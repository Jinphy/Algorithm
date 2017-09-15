package com.jinphy.java;
/*

时间限制：1秒 空间限制：32768K 热度指数：158682
        算法知识视频讲解
        题目描述
        一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

*/

public class Offer_7 {


    /*
    * 解释，在跳第i个台阶的时候，有且只有两个选择，
    * 1、从前一个台阶跳过来
    * 2、从前两个台阶跳过来
    * 所以 jump[i] = jump[i-1]+jump[i-2];
    *
    * */
    public int jumpFloor(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int preOne = 2;
        int preTwo = 1;
        int current = 0;
        for (int i=3;i<=n;i++) {
            current = preOne+preTwo;
            preTwo = preOne;
            preOne = current;
        }
        return current;
    }
}
