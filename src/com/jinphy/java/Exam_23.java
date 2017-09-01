package com.jinphy.java;

import java.util.Scanner;
/*
        时间限制：1秒 空间限制：32768K 热度指数：3790
        算法知识视频讲解
        题目描述
        给定整数m以及n各数字A1,A2,..An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果，请求出这些结果中大于m的有多少个。
        输入描述:
        第一行包含两个整数n,m.

        第二行给出n个整数A1，A2，...，An。

        数据范围

        对于30%的数据，1 <= n, m <= 1000

        对于100%的数据，1 <= n, m, Ai <= 10^5
        输出描述:
        输出仅包括一行，即所求的答案
        示例1
        输入

        3 10
        6 5 10
        输出

        2*/

public class Exam_23 {


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = reader.nextInt();
        }

        count(ints, m);

    }

    private static void count(int[] ints, int m) {
        TrieTree tree = TrieTree.create(ints);
        long count = 0;
        for (int anInt : ints) {
            count += TrieTree.query(tree, anInt, m, 31);
        }
        System.out.println(count / 2);
    }

    private static class TrieTree {
        private TrieTree[] next = new TrieTree[2];
        private long count = 1;

        private TrieTree() {
        }

        public static TrieTree create(int[] array) {
            TrieTree root = new TrieTree();
            TrieTree current;
            int digit;
            for (int a : array) {
                current = root;
                for (int i = 31; i >= 0; i--) {
                    digit = (a >> i) & 1;
                    if (current.next[digit] == null) {
                        current.next[digit] = new TrieTree();
                    } else {
                        current.next[digit].count++;
                    }
                    current = current.next[digit];
                }
            }
            return root;
        }

        public static long query(TrieTree root, int a, int m, int index) {
            if (root == null) {
                return 0;
            }
            TrieTree current = root;
            int aDigit;
            int mDigit;
            for (int i = index; i >= 0; i--) {
                aDigit = (a >> i) & 1;
                mDigit = (m >> i) & 1;
                if (mDigit == 1 && aDigit == 1) {
                    if (current.next[0] == null) {
                        return 0;
                    }
                    current = current.next[0];
                } else if (mDigit == 1 && aDigit == 0) {
                    if (current.next[1] == null) {
                        return 0;
                    }
                    current = current.next[1];
                } else if (mDigit == 0 && aDigit == 1) {
                    long count0 = current.next[0]==null?0:current.next[0].count;
                    long count1 = TrieTree.query(current.next[1], a, m, i - 1);
                    return count0 + count1;
                } else if (mDigit == 0 && aDigit == 0) {
                    long count0 = TrieTree.query(current.next[0], a, m, i - 1);
                    long count1 = current.next[1] == null ? 0 : current.next[1].count;
                    return count0 + count1;
                }
            }
            return 0;
        }
    }
}
