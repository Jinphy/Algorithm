package com.jinphy.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*

时间限制：1秒 空间限制：32768K 热度指数：1311
        算法知识视频讲解
        题目描述
        酒店房间的价格录入是通过时间段来录入的，比如10月1日至10月7日800元，10月8日至10月20日500元，请实现以下函数int[][] merge(int[][] dateRangePrices)，输入是某个酒店多个日期段的价格，每个日期段（终止日期大于等于起始日期）和对应的价格使用长度为3的数组来表示，比如[0, 19, 300], [10, 40, 250]分别表示从某天开始第1天到第20天价格都是300，第11天到第41天价格都是250，这些日期端有可能重复，重复的日期的价格以后面的为准， 请以以下规则合并并输出合并结果：
        1.相邻两天的价格如果相同，那么这两个日期段应该合并
        2.合并的结果应该以起始日期从小到大排序
        输入描述:
        输入数据包括多行，如样例输入所示。
        输出描述:
        输出数据为一行，如样例输出所示
        示例1
        输入

        1 1 100
        2 3 100
        4 5 110
        输出

        [1, 3, 100],[4, 5, 110]
*/

public class Exam_12 {

    public static final int START = 0;
    public static final int END = 1;
    public static final int PRICE = 2;
    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        String str;
        //这里的循环条件判断在平台提交时，要使用reader.hasNext()
        while ((str = reader.nextLine()).length()>0) {
            strs.add(str);
        }
        int[][] result = merge(parseStrings(strs));
        System.out.println(getString(result));
    }

    private static String getString(int[][] result) {
        StringBuilder builder = new StringBuilder();
        for (int[] ints : result) {
            builder.append(Arrays.toString(ints) + ",");
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    private static int[][] parseStrings(List<String> strs) {
        int[][] result = new int[strs.size()][3];
        int i = 0;
        for (String str : strs) {
            String[] split = str.split(" ");
            result[i][START] = Integer.valueOf(split[START]);
            result[i][END] = Integer.valueOf(split[END]);
            result[i++][PRICE] = Integer.valueOf(split[PRICE]);

        }
        return result;
    }

    private static int[][] merge(int[][] dateRangePrices) {
        int[] prices = new int[100000];
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;
        for (int i = 0; i < dateRangePrices.length; i++) {
            for (int j = dateRangePrices[i][START]; j <= dateRangePrices[i][END]; j++) {
                prices[j] = dateRangePrices[i][PRICE];
            }
            minDay = Math.min(minDay, dateRangePrices[i][START]);
            maxDay = Math.max(maxDay, dateRangePrices[i][END]);
        }
        int n = count(prices, minDay, maxDay);

        return getResult(n, prices,minDay,maxDay);

    }

    private static int count(int[] prices, int minDay, int maxDay) {
        int count;
        if (prices[minDay] != 0) {
            count = 1;
        } else {
            count = 0;
        }
        for (int i = minDay + 1; i <= maxDay; i++) {
            if (prices[i] != 0 && prices[i] != prices[i - 1]) {
                count++;
            }
        }
        return count;
    }

    private static int[][] getResult(int n, int[] prices, int minDay, int maxDay) {
        int[][] result = new int[n][3];

        int i = -1;
        if (prices[minDay] != 0) {
            i++;
            result[i][START] = minDay;
            result[i][END] = minDay;
            result[i][PRICE] = prices[minDay];
        }

        for (int j = minDay + 1; j <= maxDay; j++) {
            if (prices[j] != 0) {
                if (prices[j] == prices[j - 1]) {
                    result[i][END] = j;
                } else {
                    i++;
                    result[i][START] = j;
                    result[i][END] = j;
                    result[i][PRICE] = prices[j];
                }
            }
        }
        return result;
    }
}
