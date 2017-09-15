package com.jinphy.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        if (n < 2) {
            System.out.println(0);
        }
        int[] ints = new int[n];
        for (int i = 0;i<n;i++) {
            ints[i] = reader.nextInt();
        }
        solve(ints);
    }

    private static void solve(int[] ints) {
        long counter = 0;
        int n = ints.length - 1;
        for (int i=0;i<n;i++) {
            for (int j = i + 1; j < ints.length; j++) {
                long x = Long.parseLong("" + ints[i] + ints[j]);
                if (x % 7 == 0) {
                    counter++;
                }
                x = Long.parseLong("" + ints[j] + ints[i]);
                if (x % 7 == 0) {
                    counter++;
                }
            }
        }
        System.out.println(counter);

    }
}

