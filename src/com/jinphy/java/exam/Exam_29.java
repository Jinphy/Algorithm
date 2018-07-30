package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
时间限制：1秒 空间限制：32768K 热度指数：6236
        算法知识视频讲解
        题目描述
        假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个数组如下： a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab, baac … …, yyyw, yyyx, yyyy 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。 编写一个函数，输入是任意一个编码，输出这个编码对应的Index.
        输入描述:
        输入一个待编码的字符串,字符串长度小于等于100.
        输出描述:
        输出这个编码的index
        示例1
        输入

        baca
        输出

        16331*/

public class Exam_29 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        findIndex(reader.readLine().trim());
    }

    private static void findIndex(String str) {
        char[] encodes = str.toCharArray();
        long index = -1;

        for (int i = 0; i < encodes.length; i++) {
            int offset = encodes[i] - 'a';
            index += offset * getNodesAtBrench(i+1,4) + 1;
        }

        System.out.println(index);
    }

    private static long getNodesAtBrench(int nodeDeep, int deep) {
        long nodes = 0;
        int n = deep-nodeDeep+1;

        for (int i = 0; i < n; i++) {
            nodes += Math.pow(25, i);
        }
        return nodes;
    }

}
