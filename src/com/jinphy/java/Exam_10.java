package com.jinphy.java;

import java.util.Arrays;
import java.util.Scanner;
/*
时间限制：1秒 空间限制：32768K 热度指数：3979
        算法知识视频讲解
        题目描述
        给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符。
        输入描述:
        输入数据一个字符串，包括字母,数字等。
        输出描述:
        输出首先出现三次的那个英文字符
        示例1
        输入

        Have you ever gone shopping and
        输出

        e*/

public class Exam_10 {

    private  static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        findChar(reader.nextLine());
    }

    private static void findChar(String str) {
        char[] chars = str.toCharArray();
        int[] counter = new int[52];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                index = chars[i] - 'A';
            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                index = chars[i]-'a'+26;
            }else {
                continue;
            }
            counter[index]++;
            if (counter[index] == 3) {
                System.out.println(chars[i]);
                break;
            }
        }

    }
}
