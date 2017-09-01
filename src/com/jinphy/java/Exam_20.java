package com.jinphy.java;

import java.util.Scanner;

/*

时间限制：1秒 空间限制：32768K 热度指数：10166
        算法知识视频讲解
        题目描述
        给你两个集合，要求{A} + {B}。 注：同一个集合中不会有两个相同的元素。
        输入描述:
        每组输入数据分为三行,第一行有两个数字n,m(0 ≤ n,m ≤ 10000)，分别表示集合A和集合B的元素个数。后两行分别表示集合A和集合B。每个元素为不超过int范围的整数,每个元素之间有个空格隔开。
        输出描述:
        针对每组数据输出一行数据，表示合并后的集合，要求从小到大输出，每个元素之间有一个空格隔开,行末无空格。
        示例1
        输入

        3 3
        1 3 5
        2 4 6
        输出

        1 2 3 4 5 6
*/

public class Exam_20 {

    public static void main(String[] args)  {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] a = readIntArray(reader,n);
        int[] b = readIntArray(reader,m);
        combine(a, b);

    }

    private static int[] readIntArray(Scanner reader,int len)  {
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = reader.nextInt();
        }
        return result;
    }

    private static void combine(int[] a, int[] b) {
        sort(a, 0, a.length - 1);
        sort(b, 0, b.length - 1);
        int[] ab = new int[a.length + b.length];
        int i=0;
        int j=0;
        int k=0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                ab[k++] = a[i++];
            } else {
                ab[k++] = b[j++];
            }
        }
        while (i < a.length) {
            ab[k++] = a[i++];
        }
        while (j < b.length) {
            ab[k++] = b[j++];
        }
        System.out.println(join(ab," "));
    }

    private static String join(int[] array, String delimiter) {
        StringBuilder result = new StringBuilder();
        result.append(array[0]);
        for (int i = 1;i<array.length;i++) {
            if (array[i] != array[i - 1]) {
                result.append(delimiter).append(array[i]);
            }
        }
        return result.toString();
    }

    private static void sort(int[] array,int left,int right) {
        if (left < right) {
            int low = left;
            int high = right;
            int key = array[left];
            while (low < high) {
                while (low < high) {
                    if (key <= array[high]) {
                        high--;
                    } else {
                        array[low++] = array[high];
                        break;
                    }
                }
                while (low < high) {
                    if (array[low] <= key) {
                        low++;
                    } else {
                        array[high--] = array[low];
                        break;
                    }
                }
            }
            array[low] = key;
            sort(array, left, low - 1);
            sort(array, low + 1, right);
        }
    }
}
