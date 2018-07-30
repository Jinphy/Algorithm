package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
时间限制：1秒 空间限制：32768K 热度指数：7247
        算法知识视频讲解
        题目描述
        给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
        输入描述:
        输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
        输出描述:
        为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
        示例1
        输入

        7 2
        输出

        111*/

public class Exam_37 {
    private static char[] chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().trim().split(" {1,}");
        int x = Integer.parseInt(split[0]);
        int radix = Integer.parseInt(split[1]);
        radixChange(x, radix);
    }

    private static void radixChange(int x,int radix) {
        int num = Math.abs(x);
        StringBuilder builder = new StringBuilder();
        do {
            builder.append(chars[num % radix]);
            num /= radix;
        } while (num > 0);
        if (x < 0) {
            System.out.print("-");
        }
        System.out.println(builder.reverse());
    }
}
