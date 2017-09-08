package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Exam_50 {
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        int n;
        while (t-->0) {
            n = Integer.parseInt(reader.readLine().trim());
            findOrigin(n);
        }
    }

    // 采用逆过程的方法
    public static void findOrigin(int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        n++;
        while (--n>0) {
            queue.addFirst(n);
            Integer x = queue.pollLast();
            queue.addFirst(x);
        }
        StringBuilder result = new StringBuilder();
        for (Integer x : queue) {
            result.append(x + " ");
        }
        System.out.println(result.toString().trim());
    }


/*
    public static void findOrigin(int n) {
        // 用数列表示当前还未排序的元素的下标
        List<Integer> index = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            index.add(i);
        }
        // 待排序的数组
        int[] ints = new int[n];
        // 当前的排序队列头部的下标，但是每次排序时都不排序头部元素，而是排序他的下一个下标
        int head = 0;
        // 排序
        for (int i=1;i<=n;i++) {
            head = (head + 1) % index.size();// 获取排序当前元素i的对应下标
            ints[index.remove(head)] = i;//排序元素 i
        }

        StringBuilder result = new StringBuilder();
        for (int x : ints) {
            result.append(x + " ");
        }
        System.out.println(result.toString().trim());

    }
    */
}
