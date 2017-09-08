package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：8075
        算法知识视频讲解
        题目描述
        Fibonacci数列是这样定义的：
        F[0] = 0
        F[1] = 1
        for each i ≥ 2: F[i] = F[i-1] + F[i-2]
        因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。
        输入描述:
        输入为一个正整数N(1 ≤ N ≤ 1,000,000)
        输出描述:
        输出一个最小的步数变为Fibonacci数"
        示例1
        输入

        15
        输出

        2
*/

public class Exam_53 {
    public static void main(String[] args) throws  Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        toFibonacci(Integer.parseInt(reader.readLine().trim()));

    }

    private static void toFibonacci(int n) {
        int first = 0;
        int second = 1;
        int current;
        do {
            current = first + second;
            first = second;
            second = current;
        } while (second < n);
        if (n == second) {
            System.out.println(0);
        } else {
            int x = second-n;
            int y = n-first;
            System.out.println(x < y ? x : y);
        }

    }
}
