package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：2746
        算法知识视频讲解
        题目描述
        请设计一个算法能够完成两个用字符串存储的整数进行相加操作，对非法的输入则返回error
        输入描述:
        输入为一行，包含两个字符串，字符串的长度在[1,100]。
        输出描述:
        输出为一行。合法情况输出相加结果，非法情况输出error
        示例1
        输入

        123 123
        abd 123
        输出

        246
        Error
*/

public class Exam_14 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] str = reader.readLine().split(" {1,}");
            add(str[0].toCharArray(), str[1].toCharArray());
        }
    }

    private static void add(char[] aStr, char[] bStr) {
        try {
            check(aStr);
            check(bStr);
        } catch (Exception e) {
            System.out.println("error");
            return;
        }
        int maxLen = Math.max(aStr.length, bStr.length);
        int minLen = Math.min(aStr.length, bStr.length);
        char[] result = new char[maxLen];

        boolean flag = false;
        int a;
        int b;
        int sum;

        for (int i = 1; i <= minLen; i++) {
            a = aStr[aStr.length - i] - '0';
            b = bStr[bStr.length - i] - '0';
            sum = flag ? a + b + 1 : a + b;
            result[result.length - i] = (char) (sum % 10 + '0');
            flag = sum > 9 ? true : false;
        }

        char[] remain;
        int remainLen = maxLen - minLen;
        if (aStr.length > bStr.length) {
            remain = aStr;
        } else {
            remain = bStr;
        }
        for (int i = remainLen - 1; i >= 0; i--) {
            sum = flag ? remain[i] - '0' + 1 : remain[i] - '0';
            result[i] = (char) (sum % 10 + '0');
            flag = sum > 9 ? true : false;
        }

        if (flag) {
            System.out.println("1" + new String(result));
        } else {
            System.out.println(new String(result));
        }

    }

    private static void check(char[] str) throws Exception {
        for (char c : str) {
            if (c < '0' || c > '9') {
                throw new Exception();
            }
        }
    }
}
