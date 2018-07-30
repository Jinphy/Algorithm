package com.jinphy.java.exam;

import java.util.Scanner;

public class Exam_2 {
    private static Scanner reader;
    private static int n;
    private static int[] tree;
    private static int parent;
    private static int child;

    public static void main(String[] args) {
        reader = new Scanner(System.in);
        tree = new int[1000];
        while (true) {
            printTreeHeight();
        }
    }

    public static void printTreeHeight() {
        n = reader.nextInt();
        int i = 0;
        tree[0] = -1;
        while (++i < n) {
            parent = reader.nextInt();
            child = reader.nextInt();
            tree[child] = parent;
        }
        int currentNode = n-1;
        int height = 1;
        while (tree[currentNode] != -1) {
            height++;
            currentNode = tree[currentNode];
        }
        System.out.println(height);
    }



}
