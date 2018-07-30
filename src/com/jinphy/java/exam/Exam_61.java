package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*

时间限制：1秒 空间限制：32768K 热度指数：8734
        算法知识视频讲解
        题目描述
        你就是一个画家！你现在想绘制一幅画，但是你现在没有足够颜色的颜料。为了让问题简单，我们用正整数表示不同颜色的颜料。你知道这幅画需要的n种颜色的颜料，你现在可以去商店购买一些颜料，但是商店不能保证能供应所有颜色的颜料，所以你需要自己混合一些颜料。混合两种不一样的颜色A和颜色B颜料可以产生(A XOR B)这种颜色的颜料(新产生的颜料也可以用作继续混合产生新的颜色,XOR表示异或操作)。本着勤俭节约的精神，你想购买更少的颜料就满足要求，所以兼职程序员的你需要编程来计算出最少需要购买几种颜色的颜料？
        输入描述:
        第一行为绘制这幅画需要的颜色种数n (1 ≤ n ≤ 50)
        第二行为n个数xi(1 ≤ xi ≤ 1,000,000,000)，表示需要的各种颜料.
        输出描述:
        输出最少需要在商店购买的颜料颜色种数，注意可能购买的颜色不一定会使用在画中，只是为了产生新的颜色。
        示例1
        输入

        3
        1 7 3
        输出

        3
*/

public class Exam_61 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        List<Integer> colors = new LinkedList<>();
        String[] split = reader.readLine().trim().split(" {1,}");
        for (String s : split) {
            insert(colors, Integer.parseInt(s));
        }
        minColors(colors);

    }

    public static void minColors(List<Integer> colors) {
        int result = 0;
        int maxIndex = colors.size() - 1;
        int secondMaxIndex = maxIndex - 1;
        while (colors.size() > 2) {
            if (getHighBit(colors.get(maxIndex)) == getHighBit(colors.get(secondMaxIndex))) {
                // 最大的两个数的位数相同，则这两个数异或后必会产生一个第一位的数，并且这两个数都可以有其中一个
                // 数与这个地位的数异或得到，所以将最大的数替换成异或后低位的这个数
                int replace = colors.get(maxIndex) ^ colors.get(secondMaxIndex);
                colors.remove(maxIndex);// 该最大值可有其他比它小的数异或得到，所以不用再比较该值了
                if (!exist(colors, replace)) {// 判断这个用来替换最大值的数是否已经存在
                    insert(colors, replace);
                } else {
                    maxIndex--;
                    secondMaxIndex--;
                }
            } else {
                // 最大的的最高位比其他的数都大，说明该最大值不可能由位数比它小的数异或得到
                // 所以这个最大值（这种颜色）是必须要买的
                colors.remove(maxIndex);
                result++;
                maxIndex--;
                secondMaxIndex--;
            }
        }
        System.out.println(result + colors.size());
    }

    private static void insert(List<Integer> colors, int value) {
        for (int i = 0; i < colors.size(); i++) {
            if (value < colors.get(i)) {
                colors.add(i, value);
                return;
            }
        }
        colors.add(value);
    }

    private static boolean exist(List<Integer> colors, int key) {
        int left = 0;
        int right = colors.size() - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (colors.get(mid) == key) {
                return true;
            } else if (colors.get(mid) > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    private static int getHighBit(int x) {
        int bit = 0;
        while (x > 0) {
            bit++;
            x = x >>> 1;
        }
        return bit;
    }
}
