package com.jinphy.java;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
/*
时间限制：1秒 空间限制：32768K 热度指数：11395
        算法知识视频讲解
        题目描述
        某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
        输入描述:
        输入包括m+2行。
        第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000)
        第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。
        接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
        输出描述:
        输出一个整数,表示最大的总预计消费金额
        示例1
        输入

        3 5
        2 4 2
        1 3
        3 5
        3 7
        5 9
        1 10
        输出

        20*/

public class Exam_40 {

    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] tables = new int[n];
        for (int i = 0; i < tables.length; i++) {
            tables[i] = reader.nextInt();
        }
        Arrays.sort(tables);

        Queue<Batch> batches = new PriorityQueue<>();
        int peoples;
        int consumptions;
        while (m-- > 0) {
            peoples = reader.nextInt();
            consumptions = reader.nextInt();
            if (peoples <=tables[n - 1]) {
                batches.add(new Batch(peoples, consumptions));
            }
        }
        solve(tables, batches);
    }

    private static void solve(int[] tables, Queue<Batch> batches) {
        long total = 0;
        int usedTables = 0;
        boolean[] visited = new boolean[tables.length];
        Batch batch;
        while (!batches.isEmpty()) {
            if (usedTables == tables.length) {
                break;
            }
            batch = batches.poll();
            for (int i = 0; i < tables.length; i++) {
                if (tables[i] >= batch.peoples && !visited[i]) {
                    visited[i] = true;
                    total += batch.consumptions;
                    usedTables++;
                    break;
                }
            }
        }

        System.out.println(total);

    }

    private static class Batch implements Comparable<Batch>{
        int peoples;
        int consumptions;

        public Batch(int peoples, int consumptions) {
            this.peoples = peoples;
            this.consumptions = consumptions;
        }

        @Override
        public int compareTo(Batch o) {
            if (this.consumptions == o.consumptions) {
                return this.peoples - o.consumptions;
            } else {
                return o.consumptions - this.consumptions;
            }
        }
    }
}
