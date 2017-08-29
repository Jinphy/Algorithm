package com.jinphy.java;

import java.util.Scanner;
/*
时间限制：1秒 空间限制：32768K 热度指数：4673
        算法知识视频讲解
        题目描述
        一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，每个桩子上都有一个弹簧，
        袋鼠跳到弹簧上就可以跳的更远。每个弹簧力量不同，用一个数字代表它的力量，如果弹簧力量为5，就代表袋鼠下一
        跳最多能够跳5米，如果为0，就会陷进去无法继续跳跃。河流一共N米宽，袋鼠初始位置就在第一个弹簧上面，要跳到
        最后一个弹簧之后就算过河了，给定每个弹簧的力量，求袋鼠最少需要多少跳能够到达对岸。如果无法到达输出-1
        输入描述:
        输入分两行，第一行是数组长度N (1 ≤ N ≤ 10000)，第二行是每一项的值，用空格分隔。
        输出描述:
        输出最少的跳数，无法到达输出-1
        示例1
        输入

        5
        2 0 1 1 1
        输出

        4*/
public class Exam_7 {

    private static Scanner reader;
    private static int[] power = new int[10001];
    private static int MAX = Integer.MAX_VALUE-100;

    public static void main(String[] args) {
        reader = new Scanner(System.in);
        while (true) {
            leastSkips();
        }
    }

    private static int input() {
        int n = reader.nextInt();
        for (int i=0;i<n;i++) {
            power[i] = reader.nextInt();
        }
        return n;
    }

    private static void leastSkips(){
        int n = input();

        int[] skips = new int[n+1];// 跳到第i个桩时的最小跳数
        for (int i = 1; i < skips.length; i++) {
            skips[i] = MAX;
        }

        skips[0] = 0;
        for (int i = 1;i<=n;i++) {
            for (int j = 0;j<i;j++) {
                if (j + power[j] >= i) {
                    skips[i] = Math.min(skips[i], skips[j] + 1);
                }
            }
        }
        if (skips[n] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(skips[n]);
        }

    }
}
