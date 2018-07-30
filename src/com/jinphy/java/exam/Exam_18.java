package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
时间限制：1秒 空间限制：32768K 热度指数：5494
        算法知识视频讲解
        题目描述
        小明同学学习了不同的进制之后，拿起了一些数字做起了游戏。小明同学知道，在日常生活中我们最常用的是十进制数，而在计算机中，二进制数也很常用。现在对于一个数字x，小明同学定义出了两个函数f(x)和g(x)。 f(x)表示把x这个数用十进制写出后各个数位上的数字之和。如f(123)=1+2+3=6。 g(x)表示把x这个数用二进制写出后各个数位上的数字之和。如123的二进制表示为1111011，那么，g(123)=1+1+1+1+0+1+1=6。 小明同学发现对于一些正整数x满足f(x)=g(x)，他把这种数称为幸运数，现在他想知道，小于等于n的幸运数有多少个？
        输入描述:
        每组数据输入一个数n(n<=100000)
        输出描述:
        每组数据输出一行，小于等于n的幸运数个数。
        示例1
        输入

        21
        输出

        3*/

public class Exam_18 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        countLuckyNumber(n);
    }

    private static void countLuckyNumber(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (sum(i,10) == sum(i,2)) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    private static int sum(int x, int radix) {
        int sum = 0;
        while (x != 0) {
            sum += x % radix;
            x /= radix;
        }
        return sum;
    }
/*

    private static int f(int x) {
        char[] numbers = Integer.toString(x).toCharArray();
        int result = 0;
        for (char number : numbers) {
            result += number - '0';
        }
        return result;
    }

    private static int g(int x) {
        char[] numbers = Integer.toBinaryString(x).toCharArray();
        int result = 0;
        for (char number : numbers) {
            if (number == '1') {
                result++;
            }
        }
        return result;
    }
*/


}
