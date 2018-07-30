package com.jinphy.java.exam;


import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：4713
        算法知识视频讲解
        题目描述
        小易喜欢的单词具有以下特性：
        1.单词每个字母都是大写字母
        2.单词没有连续相等的字母
        3.单词没有形如“xyxy”(这里的x，y指的都是字母，并且可以相同)这样的子序列，子序列可能不连续。
        例如：
        小易不喜欢"ABBA"，因为这里有两个连续的'B'
        小易不喜欢"THETXH"，因为这里包含子序列"THTH"
        小易不喜欢"ABACADA"，因为这里包含子序列"AAAA"
        小易喜欢"A","ABA"和"ABCBA"这些单词
        给你一个单词，你要回答小易是否会喜欢这个单词。
        输入描述:
        输入为一个字符串，都由大写字母组成，长度小于100
        输出描述:
        如果小易喜欢输出"Likes",不喜欢输出"Dislikes"
        示例1
        输入

        AAA
        输出

        Dislikes
*/


public class Exam_54 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        word(reader.readLine().trim());
    }

    private static void word(String word) {
        char[] chars = word.toCharArray();
        int[] count = new int[26];
        for (int i = 1;i<chars.length;i++) {
            if (chars[i] < 'A' ||
                    chars[i] > 'Z' ||
                    chars[i] == chars[i - 1] ) {
                System.out.println("Dislikes");
                return;
            }
            count[chars[i]-'A']++;
            if (count[chars[i] - 'A'] == 4) {
                System.out.println("Dislikes");
                return;
            }
        }
        int x;
        for (int i = 0; i < count.length-1; i++) {
            if (count[i] > 1) {
                for (int j=i+1;j<count.length;j++) {
                    if (count[j] > 1) {
                        x = 0;
                        char c = '\0';
                        for (char a : chars) {
                            if (a == ('A' + i) || a == ('A' + j)) {
                                if (c != a) {
                                    x++;
                                    c = a;
                                    if (x == 4) {
                                        System.out.println("Dislikes");
                                        return;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

        System.out.println("Likes");
    }
}
