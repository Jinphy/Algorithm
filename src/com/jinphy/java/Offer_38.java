package com.jinphy.java;

import java.util.Arrays;
import java.util.Comparator;
/*

时间限制：1秒 空间限制：32768K 热度指数：82751
        本题知识点： 数组
        算法知识视频讲解
        题目描述
        输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
        打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
        则打印出这三个数字能排成的最小数字为321323。
*/

public class Offer_38 {


    public static void main(String[] args) {

        int[] numbers = {3,5,1,4,2};


    }

    public String PrintMinNumber(int [] numbers) {
        String[] str = new String[numbers.length];
        int i=0;
        for (int number : numbers) {
            str[i++] = String.valueOf(number);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return compares(a, b);
            }
        });

        StringBuilder builder = new StringBuilder();
        for (String s : str) {
            builder.append(s);
        }

        return builder.toString();
    }

    public  int compares(String a, String b) {
        if (a.length() == b.length()) {
            return a.compareTo(b);
        } else if (a.length() > b.length()) {
            int x = a.substring(0, b.length()).compareTo(b);
            if (x == 0) {
                return compares(a.substring(b.length()), b);
            } else {
                return x;
            }
        } else {
            int x = a.compareTo(b.substring(0, a.length()));
            if (x == 0) {
                return compares(a, b.substring(a.length()));
            } else {
                return x;
            }
        }
    }

}
