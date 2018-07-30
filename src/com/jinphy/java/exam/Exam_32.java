package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
时间限制：1秒 空间限制：32768K 热度指数：9394
        算法知识视频讲解
        题目描述
        将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
        输入描述:
        每个测试输入包含1个测试用例：  I like  beijing. 输入用例长度不超过100
        输出描述:
        依次输出倒置之后的字符串,以空格分割
        示例1
        输入

        I like  beijing.
        输出

        beijing. like I*/

public class Exam_32 {

    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reverseWords(s);
    }

    private static void reverseWords(String string) {
        String[] split = string.trim().split(" {1,}");
        StringBuilder builder = new StringBuilder(string.length()+1);
        for (int i = split.length - 1; i >= 0; i--) {
            builder.append(split[i] + " ");
        }
        System.out.println(builder.toString().trim());

    }
}
