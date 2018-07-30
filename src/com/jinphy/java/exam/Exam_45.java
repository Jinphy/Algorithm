package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：16819
        算法知识视频讲解
        题目描述
        对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
        如果 X = 123，则rev(X) = 321;
        如果 X = 100，则rev(X) = 1.
        现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？
        输入描述:
        输入为一行，x、y(1 ≤ x、y ≤ 1000)，以空格隔开。
        输出描述:
        输出rev(rev(x) + rev(y))的值
        示例1
        输入

        123 100
        输出

        223
*/

public class Exam_45 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().trim().split(" {1,}");
        solve(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    public static void solve(int x, int y) {
        x = reverse(x);
        y = reverse(y);
        System.out.println(reverse(x + y));
    }

    private static int reverse(int x) {
        int result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
}
