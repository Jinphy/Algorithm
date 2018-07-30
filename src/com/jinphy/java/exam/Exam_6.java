package com.jinphy.java.exam;

import java.text.DecimalFormat;
import java.util.Scanner;
/*时间限制：1秒 空间限制：32768K 热度指数：3300
        算法知识视频讲解
        题目描述
        数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
        输入描述:
        输入数据有多组，每组占一行，由两个整数n（n < 10000）和m(m < 1000)组成，n和m的含义如前所述。
        输出描述:
        对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
        示例1
        输入

        81 4
        2 2
        输出

        94.73
        3.41
        */
public class Exam_6 {
    private  static double[] array = new double[1000];
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n;
        int m;
        while (true) {
            n = reader.nextInt();
            m = reader.nextInt();
            sumOfArray(n, m);
        }
    }

    private static void sumOfArray(int n, int m) {
        array[0] = n;
        for (int i=1;i<m;i++) {
            array[i] = Math.sqrt(array[i - 1]);
        }
        double result = 0;
        for (int i=0;i<m;i++) {
            result += array[i];
        }
        DecimalFormat format = new DecimalFormat("#.00");
        String str = format.format(result);
        System.out.println(str);
    }
}

