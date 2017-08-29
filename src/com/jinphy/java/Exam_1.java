package com.jinphy.java;

import java.util.Scanner;

/*
*
* 时间限制：1秒 空间限制：32768K 热度指数：8650
  算法知识视频讲解
题目描述
设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
输入描述:
有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
输出描述:
每组数据输出一个表示最大的整数。
示例1
输入

2
12 123
4
7 13 4 246
输出

12312
7424613
*
*
* */
public class Exam_1 {

    private static Scanner reader;
    private static String[] ints;

    public static void main(String...args){
        reader = new Scanner(System.in);
        ints = new String[100];
        while(true){
            System.out.println(maxInt());
        }
    }


    public static String maxInt(){
        int n;

        n = reader.nextInt();

        for(int i=0;i<n;i++){
            ints[i] = Integer.toString(reader.nextInt());
        }

        sort(0,n-1,ints);

        StringBuilder str = new StringBuilder();

        for(int i=0;i<n;i++){
            str.append(ints[i]);
        }
        return str.toString();

    }
    public static void sort(int left,int right,String[] ints){
        if(left<right){
            String key = ints[left];
            int low = left;
            int high = right;
            while(low<high){
                while(low<high){
                    if (lt(key,ints[high])) {
                        high--;
                    } else {
                        ints[low++] = ints[high];
                        break;
                    }
                }
                while (low < high) {
                    if (lt(ints[low],key)) {
                        low++;
                    } else {
                        ints[high--] = ints[low];
                        break;
                    }
                }
            }
            ints[low] = key;
            sort(left,low-1,ints);
            sort(low+1,right,ints);
        }
    }

    private static boolean lt(String a, String b) {
        String x = a+b;
        String y = b+a;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) > y.charAt(i)) {
                return true;
            } else if (x.charAt(i) < y.charAt(i)) {
                return false;
            }
        }
        return true;
    }


//    private static boolean lt(String a, String b) {
//        int n;
//        boolean aLonger;
//        if (a.length() < b.length()) {
//            n = a.length();
//            aLonger = false;
//        } else{
//            n = b.length();
//            aLonger = true;
//        }
//        int i = 0;
//        while (i < n) {
//            if (a.charAt(i) > b.charAt(i)) {
//                return true;
//            } else if (a.charAt(i) < b.charAt(i)) {
//                return false;
//            } else {
//                i++;
//            }
//        }
//        if (a.length() == b.length()) {
//            return true;
//        }
//        if (aLonger) {
//            return lt(a.substring(n), b);
//        } else {
//            return lt(a, b.substring(n));
//        }
//    }

}
