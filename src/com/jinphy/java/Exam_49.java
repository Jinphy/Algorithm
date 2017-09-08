package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Exam_49 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String[] split = reader.readLine().trim().split(" {1,}");
        int[] ints = new int[split.length];
        int i = 0;
        for (String s : split) {
            ints[i++] = Integer.parseInt(s);
        }
        makePalindrome(ints);
    }

    /*
    * 一个序列如果是回文序列，则最起码首尾两个元素必须先是相同的，不然即使中间的子序列是
    * 回文的也没用，所有，每次操作时应该从两端开始，如果首尾的两个元素是相同的则两端缩短在bijiao
    * ，例如 序列 1 2 1 3 3 1，则首尾的就无需执行相加操作了，直接比较2 和3，发现左边的2小于右边的3
    * 此时如果让3+3 显然2不可能再由和右边相等的机会，所以应该让两者中较小的2+1=3，然后在让左边相加
    * 后的结果3与右边的3再进行比较，此时3==3，所以再缩短比较，如此重复直到左边的下标与右边下标相等
    *
    * */
    private static void makePalindrome(int[] ints) {
        int i = 0;
        int j = ints.length - 1;
        int counter = 0;
        int left = ints[i];
        int right = ints[j];
        while (i < j) {
            if (left == right) {
                left = ints[++i];
                right = ints[--j];
            } else if (left < right) {
                left += ints[++i];
                counter++;
            } else {
                right += ints[--j];
                counter++;
            }
        }

        System.out.println(counter);
    }

}
