package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Exam_60 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String[] split = reader.readLine().trim().split(" {1,}");
        int[] bolls = new int[split.length];
        int i = 0;
        for (String s : split) {
            bolls[i++] = Integer.parseInt(s);
        }
        solve(bolls);
    }

    private static void solve(int[] bolls) {
        Arrays.sort(bolls);
        System.out.println(luckyBag(bolls, 0, 0, 1));
    }

    private static int luckyBag(int[] bolls, int pos, long sum, long product) {
        int count = 0;
        long newSum;
        long newProduct;
        for (int i = pos; i < bolls.length; i++) {
            newSum = sum + bolls[i];
            newProduct = product * bolls[i];
            if (newSum > newProduct) {
                count += 1 + luckyBag(bolls, i + 1, newSum, newProduct);
            } else if (bolls[i] == 1) {
                count += luckyBag(bolls, i + 1, newSum, newProduct);
            } else {
                break;
            }
            while (i < bolls.length - 1 && bolls[i] == bolls[i + 1]) {
                i++;
            }
        }

        return count;
    }

}
