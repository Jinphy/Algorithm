package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：13944
        算法知识视频讲解
        题目描述
        n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，每一次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
        输入描述:
        每个输入包含一个测试用例。每个测试用例的第一行包含一个整数 n（1 <= n <= 100），接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。
        输出描述:
        输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。
        示例1
        输入

        4
        7 15 9 5
        输出

        3

*/

public class Exam_65 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String[] split = reader.readLine().trim().split(" {1,}");
        int[] apples = new int[split.length];
        int total=0;
        int i=0;
        for (String s : split) {
            apples[i++] = Integer.parseInt(s);
            total += apples[i - 1];
        }
        solve(total, apples);
    }

    public static void solve(int total,int... apples) {

        if (total % apples.length != 0) {
            System.out.println(-1);
            return;
        }
        int average = total / apples.length;

        if ((average & 1) == 0) {
            for (int apple : apples) {
                if ((apple & 1) == 1) {
                    System.out.println(-1);
                    return;
                }
            }
        } else {
            for (int apple : apples) {
                if ((apple & 1) == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        int counter = 0;
        for (int apple : apples) {
            if (apple > average) {
                counter += (apple - average);
            }
        }
        System.out.println(counter >> 1);

    }
}

