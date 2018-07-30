package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：824
        算法知识视频讲解
        题目描述
        小B乘火车和朋友们一起在N市到M市之间旅行。她在路途中时睡时醒。当她醒来观看窗外的风景时，注意到每个火车站都有一种特别颜色的旗帜，但是她看到的旗帜仅仅是经过的一小部分。小B在乘车过程中有两次清醒的时间，她到达旅程终点时处于睡梦中。出站时，她和朋友们谈论着一路的见闻，朋友们觉得很有意思，他们把N到和M之间经过车站的旗帜颜色依次列出来，然后告诉你小B记得的旗帜颜色序列，让你判断小B究竟是从N和M之间哪些方向才能看到所说颜色的旗帜，还是根本就不可能看到？颜色用字母代表，相同的字母代表相同的颜色，不同的字母则表示不同的颜色。
        输入描述:
        输入中有多组测试数据，每组测试数据包含三行，第一行为一个由小写拉丁字母构成的非空字符串，长度不超过10^5，表示N到M之间车站的颜色。火车从M向N运行时，经过的车站相同，只是方向相反。第二行为小B在第一次睡醒时看到的颜色序列，第三行为小B在第二次睡醒时看到的颜色序列。两个序列都是小写的拉丁字母构成的字符串，长度不超过100个字母。每个序列的颜色顺序排列按小B看到的时间顺序排列。
        输出描述:
        对每组测试数据，在单独的行中输出小B的旅行方向。

        forward - 由N到M方向；

        backward -由M到N方向

        both - 两种方向都有可能；

        invalid - 不可能看到这样的颜色序列；
        示例1
        输入

        atob
        a
        b
        aaacaaa
        aca
        aa
        输出

        forward
        both

*/

public class Exam_25 {

    private static String NToM = "forward";
    private static String MToN = "backward";
    private static String both = "both";
    private static String invalid = "invalid";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String stations = reader.readLine().trim();
            String one = reader.readLine().trim();
            String two = reader.readLine().trim();
            solve(stations,one,two);
        }
    }

    private static void solve(String stations, String one, String two) {
        boolean nTom = check(stations, one, two);
        boolean mTon = check(reverse(stations), one, two);
        if (nTom && mTon) {
            System.out.println(both);
        } else if (nTom) {
            System.out.println(NToM);
        } else if (mTon) {
            System.out.println(MToN);
        } else {
            System.out.println(invalid);
        }
    }

    private static boolean check(String stations, String one, String two) {
        char[] s = stations.toCharArray();
        char[] o = one.toCharArray();
        char[] t = two.toCharArray();

        int first = firstIndex(s, o);
        int last = lastIndex(s, t);
        if (first == -1 || last == -1) {
            return false;
        }
        return first + o.length <= last;
    }


    private static int firstIndex(char[] target, char[] pattern) {
        int[] next = getNext(pattern);
        int j=0;
        for (int i = 0; i < target.length; i++) {
            while (j > 0 && target[i] != pattern[j]) {
                j = next[j];
            }
            if (target[i] == pattern[j]) {
                j++;
            }
            if (j == pattern.length) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private static int lastIndex(char[] target, char[] pattern) {
        int index = firstIndex(reverse(target), reverse(pattern));

        return target.length - pattern.length - index;
    }

    private static int[] getNext(char[] pattern) {
        int[] next = new int[pattern.length + 1];
        int j=0;
        next[0] = next[1] = 0;

        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = next[j];
            }
            if (pattern[i] == pattern[j]) {
                j++;
            }
            next[i + 1] = j;
        }
        return next;
    }


    // 翻转字符串
    private static char[] reverse(char[] str) {
        char[] reserve = new char[str.length];
        int j=str.length-1;
        for (int i = 0; i < str.length; i++) {
            reserve[j--] =str[i];
        }
        return reserve;
    }


    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

}
