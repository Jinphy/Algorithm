package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：31898
        本题知识点： 动态规划
        算法知识视频讲解
        题目描述
        有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
        输入描述:
        每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
        输出描述:
        输出一行表示最大的乘积。
        示例1
        输入

        3
        7 4 7
        2 50
        输出

        49

*/

/*
*       时间超限
* */

public class Exam_68 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        int[] ints = toArray(reader.readLine().trim());
        int[] kd = toArray(reader.readLine().trim());
        solve(kd[0], kd[1], ints);
    }

    private static void solve(int k, int d, int... ints) {
        long[] max = new long[1];
        max[0] = Long.MIN_VALUE;
        for (int i=0;i<=ints.length-k;i++) {
            find(k, d, i, ints,1,max);
        }

        System.out.println(max[0]);

    }
    private static void find(int k, int d, int begin, int[] ints,long current,long[] max) {
        current *= ints[begin];
        if (k == 1) {
            max[0] = Math.max(max[0], current);
            return;
        }

        for (int i= begin+1;i<ints.length;i++) {
            if (i - begin > d) {
                break;
            }
            if (ints.length - i < k - 1) {
                break;
            }
            find(k - 1, d, i, ints, current, max);
        }
    }

    private static int[] toArray(String str) {
        String[] split = str.split(" {1,}");
        int[] ints = new int[split.length];
        int i=0;
        for (String s : split) {
            ints[i++] = Integer.parseInt(s);
        }
        return ints;
    }
}
