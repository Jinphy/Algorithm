package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：4336
        算法知识视频讲解
        题目描述
        输入n个整数，输出出现次数大于等于数组长度一半的数。
        输入描述:
        每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
        输出描述:
        输出出现次数大于等于n/2的数。
        示例1
        输入

        3 9 3 2 5 6 7 3 2 3 3 3
        输出

        3
*/


public class Exam_33 {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().trim().split(" {1,}");
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        find(ints);
    }

    /*
    * 因为要找的数大于或等于数组长度的一半，所有，该数的个数减去其他数的个数一定大于等于0
    * */
    private static void find(int... ints) {
        int counter=0;
        int pre = 0;
        for (int x : ints) {
            if (counter == 0) {
                pre = x;
                counter++;
            }
            if (pre != x) {
                counter--;
            }
        }
        System.out.println(pre);

    }

/*
    private static void find(int... ints) {
        TwoForkTree tree = TwoForkTree.create(ints[0], ints.length / 2);

        for (int i = 1; i < ints.length; i++) {
            if (TwoForkTree.visit(tree, ints[i])) {
                System.out.println(ints[i]);
                return;
            }
        }
    }

    private static class TwoForkTree{
        int value;
        int counter = 1;
        TwoForkTree left;
        TwoForkTree right;
        private static int n;


        public static TwoForkTree create(int value,int n) {
            TwoForkTree.n = n;
            return new TwoForkTree(value);
        }

        private TwoForkTree(int value) {
            this.value = value;
        }

        public static boolean visit(TwoForkTree root, int value) {
            while (true){
                if (root.value == value) {
                    root.counter++;
                    return root.counter == n;
                } else if (root.value < value) {
                    if (root.right != null) {
                        root = root.right;
                    } else {
                        root.right = new TwoForkTree(value);
                        return false;
                    }
                } else {
                    if (root.left != null) {
                        root = root.left;
                    } else {
                        root.left = new TwoForkTree(value);
                        return false;
                    }
                }
            }
        }

    }*/
}
