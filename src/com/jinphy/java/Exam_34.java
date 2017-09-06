package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：7576
        算法知识视频讲解
        题目描述
        找出n个数里最小的k个
        输入描述:
        每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n
        不超过100。
        输出描述:
        输出n个整数里最小的k个数。升序输出
        示例1
        输入

        3 9 6 8 -10 7 -11 19 30 12 23 5
        输出

        -11 -10 3 6 7
*/


public class Exam_34 {

    public static void main(String[] args)throws  Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] split = reader.readLine().trim().split(" {1,}");
        int[] ints = new int[split.length];
        int i = 0;
        for (String s : split) {
            ints[i++] = Integer.parseInt(s);
        }

        printPreK(ints);
    }

    private static void printPreK(int[] ints) {
        int n = ints.length - 1;
        int k = ints[n];

        sort(ints, 0, n - 1, k);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            builder.append(ints[i] + " ");
        }
        System.out.println(builder.toString().trim());


    }

    private static void sort(int[] ints, int left, int right, int k) {
        if (left < right) {
            int low = left;
            int high = right;
            int key = ints[left];

            while (low < high) {
                while (low < high) {
                    if (key <= ints[high]) {
                        high--;
                    } else {
                        ints[low++] = ints[high];
                        break;
                    }
                }
                while (low < high) {
                    if (key >= ints[low]) {
                        low++;
                    } else {
                        ints[high--] = ints[low];
                        break;
                    }
                }
            }
            ints[low] = key;

            sort(ints, left, low - 1, k);
            if (k > low + 1) {
                sort(ints, low + 1, right, k);
            }

        }
    }


}
