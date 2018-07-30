package com.jinphy.java.exam;

import java.util.Arrays;
import java.util.Scanner;

/*时间限制：1秒 空间限制：32768K 热度指数：2952
        算法知识视频讲解
        题目描述
        有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。有一天国王把项链赏赐给了一个学者，并跟他说，你可以带走这条项链，但是王后很喜欢红宝石，蓝宝石，紫水晶，翡翠和钻石这五种，我要你从项链中截取连续的一小段还给我，这一段中必须包含所有的这五种宝石，剩下的部分你可以带走。如果无法找到则一个也无法带走。请帮助学者找出如何切分项链才能够拿到最多的宝石。
        输入描述:
        我们用每种字符代表一种宝石，A表示红宝石，B表示蓝宝石，C代表紫水晶，D代表翡翠，E代表钻石，F代表玉石，G代表玻璃等等，我们用一个全部为大写字母的字符序列表示项链的宝石序列，注意项链是首尾相接的。每行代表一种情况。
        输出描述:
        输出学者能够拿到的最多的宝石数量。每行一个
        示例1
        输入

        ABCYDYE
        ATTMBQECPD
        输出

        1
        3*/

public class Exam_8 {

    private static Scanner reader = new Scanner(System.in);
    private static int[] outChars = new int[5];
    private static int result;

    public static void main(String[] args) {
        String str;
        while (true) {
            str = reader.next();
            cut(str);
        }

    }

    private static void cut(String input) {
        scan(input);
        int n = input.length();
        int head;
        int tail = 0;
        result = 0;
        String str = input+input;

        for (head = n;head<str.length();head++) {
            tail = cut(head, tail, str, n);
        }

        System.out.println(result);
    }

    private static int cut(int head,int tail,String str,int n) {
        int c = str.charAt(head)-'A';
        if (c >= 0 && c < 5) {
            outChars[c]++;
        }
        while (true) {
            c = str.charAt(tail)-'A';
            if (c >= 0 && c < 5) {
                if (outChars[c] > 1) {
                    tail++;
                    outChars[c]--;
                } else {
                    break;
                }
            } else {
                tail++;
            }
        }

        result = Math.max(result, n - (head - tail + 1));

        return tail;
    }

    private static void scan(String str) {
        Arrays.fill(outChars, 0);
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i)-'A';
            if (c >= 0 && c < 5) {
                outChars[c]++;
            }
        }
    }
}
