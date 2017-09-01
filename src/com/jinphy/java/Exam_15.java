package com.jinphy.java;

import java.util.Scanner;
/*

时间限制：1秒 空间限制：32768K 热度指数：1737
        算法知识视频讲解
        题目描述
        给你六种面额1、5、10、20、50、100元的纸币，假设每种币值的数量都足够多，编写程序求组成N员（N为0-10000的非负整数）的不同组合的个数。
        输入描述:
        输入为一个数字N，即需要拼凑的面额
        输出描述:
        输出也是一个数字，为组成N的组合个数。
        示例1
        输入

        5
        输出

        2
*/

public class Exam_15 {

    private static int max100;
    private static int max50;
    private static int max20;
    private static int max10;
    private static int max5;
    private static int count;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        count(reader.nextInt());
    }


    /**
     * 动态规划问题
     * @param n
     */
    private static void count(int n) {
        int[] coins = {1, 5, 10, 20, 50, 100};
        long[] counter = new long[n + 1];//问题规模
        counter[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i]) {
                    counter[j] += counter[j - coins[i]];
                }
            }
        }
        System.out.println(counter[n]);
    }

/*
    private static void count(int n) {
        count = 0;
        handle100(n);
        System.out.println(count);
    }

    private static void handle100(int total) {
        max100 = total / 100;
        for (int i = max100; i >= 0; i--) {
            handle50(total - 100 * i);
        }
    }

    private static void handle50(int total) {
        max50 = total / 50;
        for (int i = max50; i >= 0; i--) {
            handle20(total - 50 * i);
        }
    }

    private static void handle20(int total) {
        max20 = total / 20;
        for (int i = max20; i >= 0; i--) {
            handle10(total - 20 * i);
        }
    }

    private static void handle10(int total) {
        max10 = total / 10;
        for (int i = max10; i >= 0; i--) {
            handle5(total - 10 * i);
        }
    }

    private static void handle5(int total) {
        max5 = total / 5;
        for (int i = max5; i >= 0; i--) {
            handle1(total - 5 * i);
        }
    }

    private static void handle1(int total) {
        count++;
    }*/
}
