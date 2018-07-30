package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：4625
        算法知识视频讲解
        题目描述
        输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
        输入描述:
        每个测试输入包含2个整数,n和m
        输出描述:
        按每个组合的字典序排列输出,每行输出一种组合
        示例1
        输入

        5 5
        输出

        1 4
        2 3
        5
*/

public class Exam_30 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().trim().split(" {1,}");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        print(n, m);
    }

    public static void print(int n, int m) {
        sum(null, 1, m, n);
        if (m <= n) {
            System.out.println(m);
        }
    }

    private static void sum(String pre, int min, int m, int n) {
        if (pre == null || pre.trim().length()==0) {
            pre = "";
        } else {
            pre = pre + " ";
        }

        int max = m - min;
        while (min < max && min <= n) {
            if (max <= n) {
                System.out.println(pre + min + " " + max);
            }
            sum(pre + min, min + 1, max, n);
            min++;
            max--;
        }
    }
}
