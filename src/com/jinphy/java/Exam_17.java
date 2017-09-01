package com.jinphy.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
时间限制：1秒 空间限制：32768K 热度指数：3313
        算法知识视频讲解
        题目描述
        现在有一个数组，其值为从1到10000的连续增长的数字。出于某次偶然操作，导致这个数组中丢失了某三个元素，同时顺序被打乱，现在需要你用最快的方法找出丢失的这三个元素，并且将这三个元素根据从小到大重新拼接为一个新数字，计算其除以7的余数。 例：丢失的元素为336，10，8435，得到的新数字为103368435，除以七的余数为2。
        输入描述:
        输入数据为一行，包含9997个数字，空格隔开。
        输出描述:
        输出为一行，包含一个数字。
        示例1
        输入

        同题设例子输入
        输出

        2*/

public class Exam_17 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        findLostNumber(toIntArray(str));
    }

    private static int[] toIntArray(String string) {
        String[] split = string.split(" {1,}");
        int[] result = new int[10001];
        int x;
        for (String s : split) {
            x = Integer.parseInt(s);
            result[x] = x;
        }
        return result;
    }

    private static void findLostNumber(int[] numbers) {
        int[] lost = new int[3];
        int j=0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i]==0) {
                lost[j++] = i;
            }
        }
        long number = Long.parseLong(""+lost[0]+lost[1]+lost[2]);
        System.out.println(number%7);
    }
}
