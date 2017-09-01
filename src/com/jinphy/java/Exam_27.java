package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
时间限制：1秒 空间限制：32768K 热度指数：6238
        算法知识视频讲解
        题目描述
        给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
        如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
        输入描述:
        输入包括一个整数n,(3 ≤ n < 1000)
        输出描述:
        输出对数
        示例1
        输入

        10
        输出

        2*/

public class Exam_27 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        countPrimePairs(Integer.parseInt(reader.readLine().trim()));

    }

    private static void countPrimePairs(int n) {
        boolean[] primes = scanPrimes(n);
        int counter=0;

        // 因为两个数相加等于n 则必须这两个数在n中间值两边或刚好为中间值
        // 例如 n = 10时，4和6，5和5
        int len = primes.length / 2 + 1;
        for (int i = 2; i < len; i++) {
            if (primes[i] && primes[n - i]) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    private static boolean[] scanPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        primes[0] = primes[1] = false;
        primes[n] = true;
        for (int i = 2;i<n;i+=2) {
            primes[i] = true;
            primes[i+1] = true;
        }
        // 偶数都不是素数
        for (int i=4;i<=n;i+=2) {
            primes[i] = false;
        }
        for (int i = 3;i<=n;i+=2) {
            if (primes[i]) {
                if (!isPrime(i)) {
                    primes[i] = false;
                }
                int i2 = i<<1;
                for (int j = i*3;j<=n;j+=i2) {
                    // i的倍数都不是素数，这里只算奇数倍就可以，因为前面所有的偶数都判断过了
                    primes[j] = false;
                }
            }
        }
        return primes;
    }

    private static boolean isPrime(int x) {
        int n = (int) Math.sqrt(x)+1;
        for (int i=3;i<n;i+=2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
