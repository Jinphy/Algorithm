package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：6338
        算法知识视频讲解
        题目描述
        给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
        当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
        输入描述:
        输入为两行:

        第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)

        第二行为n个正整数A[i](32位整数)，以空格隔开。
        输出描述:
        输出所求的方案数
        示例1
        输入

        5 15
        5 5 10 2 3
        输出

        4
*/

public class Exam_36{
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] splitNAndSum = reader.readLine().trim().split(" {1,}");
        int n = Integer.parseInt(splitNAndSum[0]);
        int sum = Integer.parseInt(splitNAndSum[1]);
        String[] split = reader.readLine().trim().split(" {1,}");
        int[] ints = new int[n];
        int i = 0;
        for (String s : split) {
            ints[i++] = Integer.parseInt(s);
        }

        countSum(sum, ints);
    }

    private static void countSum(int m, int[] input) {
        int[] ints = new int[input.length];
        int n=0;
        for (int x : input) {
            if (x <= m) {
                ints[n++] = x;
            }
        }
        input = null;
        if (n == 0) {
            System.out.println(0);
        }

        long[][] dp = new long[n][m + 1];
        dp[0][ints[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i-1][j];
                if (ints[i] <j) {
                    dp[i][j] +=  dp[i - 1][j - ints[i]];
                } else if (ints[i] == j) {
                    dp[i][j]++;
                }
            }
        }
        System.out.println(dp[n - 1][m]);
    }
}
/*

public class Exam_36 {


    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] splitNAndSum = reader.readLine().trim().split(" {1,}");
        int n = Integer.parseInt(splitNAndSum[0]);
        int sum = Integer.parseInt(splitNAndSum[1]);
        String[] split = reader.readLine().trim().split(" {1,}");
        int[] ints = new int[n];
        int i = 0;
        for (String s : split) {
            ints[i++] = Integer.parseInt(s);
        }

        countSum(n, sum, ints);
    }

    public static void countSum(int n, int sum, int[] ints) {
        int[] data = new int[sum + 1];
        for (int x : ints) {
            if (x <= sum) {
                data[x]++;
            }
        }

        System.out.println(count(data, 1, sum - 1));
    }
    public static int count(int[] data,int min,int max) {
        // sum = min + max;
        int count = 0;
        int n = (min+max)>>1;
        while (min < n) {
            if (data[min] > 0 && data[max]>0) {
                count += data[min] * data[max];
                //在递归下一个是，前面的数min已经被用了一次，所以要减1
                // 例如：如果1的个数为3，10 = 1+9；下一个递归为10 = 1+1+8
                // 可知，1+9时，有三个1可以和9相加，但是只有2个1和8相加
                data[min]--;
                // 当此递归结束后，要把刚才减掉的一个加回来：++data[min]
                // 之所以递归计算后还要乘上前面个数数min的个数，是因为相同数值的
                // 数在数组中的下标是不同的，所以要计算他们的组合数
                count += count(data,min, max)*(++data[min]);

            }
            min++;
            max--;
        }
        if (min==max&&data[min] > 1) {
            count += (data[min] * (data[min] - 1)) >> 1;
        }

        return count;
    }

}
*/
