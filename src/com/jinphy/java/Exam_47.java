package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*

时间限制：1秒 空间限制：32768K 热度指数：26178
        算法知识视频讲解
        题目描述
        小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
        这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
        例如：
        N = 4，M = 24：
        4->6->8->12->18->24
        于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
        输入描述:
        输入为一行，有两个整数N，M，以空格隔开。
        (4 ≤ N ≤ 100000)
        (N ≤ M ≤ 100000)
        输出描述:
        输出小易最少需要跳跃的步数,如果不能到达输出-1
        示例1
        输入

        4 24
        输出

        5
*/


public class Exam_47{
    public static void main(String[] args) throws  Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().trim().split(" {1,}");
        solve(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }


    public static void solve(int n, int m) {
        if (n == m) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[m + 1];
        for (int i = n+1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        List<Integer> factors;
        for (int i = n; i <m; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            factors = getFactors(i);
            for (int factor : factors) {
                if (i + factor <= m && dp[i] + 1 < dp[i + factor]) {
                    dp[i + factor] = dp[i] + 1;
                }
            }
        }
        System.out.println(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
    }

    public static List<Integer> getFactors(int x) {
        int n = (int) Math.sqrt(x);
        List<Integer> factors = new ArrayList<>();

        if (n * n == x) {
            factors.add(n);
        } else {
            n++;
        }

        for (int i = 2; i < n; i++) {
            if (x % i == 0) {
                factors.add(i);
                factors.add(x / i);
            }
        }
        return factors;
    }

}
/*

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exam_47 {

    public static void main(String[] args) throws  Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().trim().split(" {1,}");
        solve(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    // 这是贪心算法，表面上可以找出最大值，但实际上，由于没有遍历每个可以到达的石头来比较取最小值
    // 求出来的未必是最小值，所以用该方法求出来的是错误答案
    private static void solve(int n, int m) {
        if (n == m) {
            System.out.println(0);
            return;
        }
        Stack<Stone> stones = new Stack<>();
        stones.push(new Stone(n));
        int skip;
        Stone current;

        while (!stones.empty()) {
            // 当栈为空时，说明跳不到编号为m的石头，失败
            current = stones.peek();//从当前石头开始跳，尽量跳最大步
            while ((skip = nextFactor(current.i, current.factor - 1)) > 0) {
                // 当skip==0时，说明从当前石头无法再往前跳了，此时就要退回到上个跳过的石头
                current.factor = skip;// 保存当前在当前石头能跳的最大步数
                if (current.i + skip > m) {
                    // 跳过编号为m的石头了，要继续找下个步数更小的跳跃
                    continue;
                } else if (current.i + skip < m) {
                    // 没有超过m,可以调到m,压栈，退出该循环，跳下一个石头
                    stones.push(new Stone(current.i + skip));
                    break;
                } else {
                    // 刚好等于m 说明跳跃成功
                    System.out.println(stones.size());
                    return;
                }
            }
            if (skip == 0) {
                // 如果不能再往前跳，只能退回到上次跳跃的石头，出栈
                stones.pop();
            }
        }
        // 跳跃失败
        System.out.println(-1);
    }

    private static int nextFactor(int x, int max) {
        while (max > 1) {
            if (x % max==0) {
                return max;
            }
            max--;
        }
        return 0;
    }

    private static class Stone{
        int i;
        int factor;

        public Stone(int i) {
            this.i = i;
            this.factor = i;
        }
    }
}
*/







