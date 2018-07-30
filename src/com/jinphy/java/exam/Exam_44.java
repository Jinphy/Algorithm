package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*

时间限制：1秒 空间限制：32768K 热度指数：28725
        算法知识视频讲解
        题目描述
        小易是一个数论爱好者，并且对于一个数的奇数约数十分感兴趣。一天小易遇到这样一个问题： 定义函数f(x)为x最大的奇数约数，x为正整数。 例如:f(44) = 11.
        现在给出一个N，需要求出 f(1) + f(2) + f(3).......f(N)
        例如： N = 7
        f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21
        小易计算这个问题遇到了困难，需要你来设计一个算法帮助他。
        输入描述:
        输入一个整数N (1 ≤ N ≤ 1000000000)
        输出描述:
        输出一个整数，即为f(1) + f(2) + f(3).......f(N)
        示例1
        输入

        7
        输出

        21
*/

/*
* 解题思路：
*       在求一个数从1 ~ n的这n个数的所有最大的奇数约数的和时
*       例如 n= 20；则1,2,3,4,5,6,7,8,9,10,11,12,13，14,15,16,17,18,19,20中
*       所有的奇数的最大的奇数约数是其本身，所有可以分两步：
*       第一步：求所有奇数的最大奇数约数的和，即1+3+5+7+9+11+13+15+17+19
*       第二步：求所有偶数的最大奇数余数的和，
*       偶数有：2,4,6,8,10,12,14,16,18,20，
*       可以分解成：1*2,2*2,3*2,4*2,5*2,6*3，7*2,8*2,9*2,10*2，其中因子2肯定会包含在奇数约数中
*       ，所以可以化简为1,2,3,4,5,6,7,8,9,10，所以现在的为题就转化为规模更小的
*       n/2的所有最大的奇数约数的和了，是个子问题，按上述同样的步骤解子问题,指导子问题n=1时，该子问题的
*       解即为1，即为最小子问题，将所有子问题的结果累加即为问题的最终解
*
* */

public class Exam_44 {


    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long result = calculate(Long.parseLong(reader.readLine().trim()));
        System.out.println(result);
    }

    // 循环方法求解
    private static long calculate(long n) {
        long result=1;
        while (n > 1) {
            if ((n & 0b1) == 0) {
                // n 为偶数
                result += getSum(n - 1);
            } else {
                // n 为奇数
                result += getSum(n);
            }
            n = n >> 1;
        }
        return result;
    }
    /*
    // 递归方法求解
    private static long calculate(long n) {
        if (n == 1) {
            return 1;
        }
        long result;
        if ((n & 0b1) == 0) {
            // n 为偶数
            result = getSum(n - 1);
        } else {
            // n 为奇数
            result = getSum(n);
        }
        return result + calculate(n >> 1);
    }
*/

    // 计算1 + 3 + ...+ x 的值，x是奇数
    private static long getSum(long x) {
        // (x+1)^2/4
        return ((++x) * x) >> 2;
    }
}
