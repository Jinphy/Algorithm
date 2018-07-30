package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：1830
        算法知识视频讲解
        题目描述
        有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
        输入描述:
        输入包括一行，逗号隔开的两个正整数x和y，取值范围[1,10]。
        输出描述:
        输出包括一行，为走法的数目。
        示例1
        输入

        3 2
        输出

        10

*/

public class Exam_16 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = reader.readLine().trim().split(" {1,}");
        int x = Integer.valueOf(xy[0]);
        int y = Integer.valueOf(xy[1]);
        countRoute(x, y);
    }

    private static void countRoute(int x, int y) {
        int[][] counter = new int[x+1][y+1];
        for (int i = 0; i <= x; i++) {
            counter[i][0] = 1;
        }
        for (int i = 0; i <= y; i++) {
            counter[0][i] = 1;
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                counter[i][j] = counter[i - 1][j] + counter[i][j - 1];
            }
        }
        System.out.println(counter[x][y]);
    }
}
