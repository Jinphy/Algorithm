package com.jinphy.java;

import java.util.Scanner;


public class Exam_41 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        System.out.println(getMaxSum(array, n));

    }

    public static int getMaxSum(int[] array, int n) {
        if (array.length == 0 || array == null){
            return 0;
        }
        int currentSum = array[0];
        int currentMax = array[0];
        for (int i = 1; i < n; i++) {
            if (currentSum < 0) {
                currentSum = array[i];
            } else {
                currentSum += array[i];
            }
            if (currentSum > currentMax) {
                currentMax = currentSum;
            }
        }
        return currentMax;
    }
}

/*

public class Exam_41 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] ints = new int[n];
        int i = 0;
        do {
            ints[i++] = reader.nextInt();
        } while (i < n);
        maxSum(ints);
    }

    private static void maxSum(int[] ints) {
        long result = 0;
        List<Sum> list = new ArrayList<>();
        Sum sum = null;
        byte flag = 0;
        int start = -1;
        for (int i = 0; i < ints.length; i++) {
            // 此循环的作用是找出数组中第一个大于0的数
            if (ints[i] > 0) {
                start = i + 1;
                sum = new Sum(i, i, ints[i]);
                result = sum.value;
                list.add(sum);
                break;
            }
        }
        if (start == -1) {
            printmaxElement(ints);
            return;
        }

        int end = -1;
        for (int i = ints.length - 1; i >= 0; i--) {
            // 此循环的作用是找出数组中最后一个大于0的数
            if (ints[i] > 0) {
                end = i + 1;
                break;
            }
        }
        if (end == -1) {
            printmaxElement(ints);
            return;
        }

        for (int i = start; i < end; i++) {
            // 此循环的作用是从第一个大于0的数开始，到最后一个大于0的数结束
            // 相加合并所有连续相同符号的数，合并后的结果必定是这样
            // 一个数组：所有下包为偶数的数大于或等于0，所有下标为奇数的数都小于0
            // 并且第一个数和最后一个数一定大于0
            if ((ints[i] ^ ints[i - 1]) < 0) {//相邻两个元素异号
                sum = new Sum(i, i, ints[i]);
                list.add(sum);
            } else {
                sum.j = i;
                sum.value += ints[i];
            }
            result = Math.max(sum.value, result);
        }

        int len = list.size() - 1;
        for (int i = 0; i < len; i += 2) {
            // 此循环是找出所有间隔在小于0的数之间的正数组成连续的子数组的和的最大值
            if (list.get(i).value > -list.get(i + 1).value) {
                list.get(i + 2).value += (list.get(i).value + list.get(i + 1).value);
                result = Math.max(list.get(i + 2).value, result);
            }
        }
        System.out.println(result);

    }

    private static void printmaxElement(int... ints) {
        int max = Integer.MIN_VALUE;
        for (int x : ints) {
            max = Math.max(max, x);
        }
        System.out.println(max);
    }

    private static class Sum {
        int i;
        int j;
        int value;

        public Sum(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}

*/
