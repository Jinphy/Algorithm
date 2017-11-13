package com.jinphy.java;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println(random.nextDouble());

    }

    public static void sort(int left, int right, int... array) {
        if (left < right) {
            int low = left;
            int high = right;
            int key = array[low];
            while (low < high) {
                while (low < high) {
                    if (array[high] >= key) {
                        high--;
                    } else {
                        array[low++] = array[high];
                        break;
                    }
                }
                while (low < high) {
                    if (array[low] <= key) {
                        low++;
                    } else {
                        array[high--] = array[low];
                        break;
                    }
                }
            }
            array[low] = key;
            sort(left, low - 1, array);
            sort(low + 1, right, array);
        }
    }


    public int luckyNumber(int a, int b) throws Exception {
        if (a >= 1 && a <= 1_000_000_000) {
            if (b >= a && b <= 1_000_000_000) {
                int count = 0;
                String bStr = String.valueOf(b);
                String aStr = String.valueOf(a);
                int bLen = bStr.length();
                int aLen = aStr.length();
                int bCnt = 0;
                int aCnt = 0;
                int x = 1;
                for (int i = 1; i < bLen; i++) {
                    x <<= 1;
                    bCnt += x;
                }
                char ch = bStr.charAt(0);
                if (ch > '7') {
                    x <<= 1;
                    bCnt += x;
                }
            }
        }
        throw new Exception("the range of a is out of 1 and 1000 000 000");
    }

    public Map<String, Double> solve(double m, int n) {
        Random random = new Random(System.currentTimeMillis());
        List<String> menbers = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            menbers.add("a" + i);
        }
        Map<String, Double> result = new HashMap<>();
        while (menbers.size() > 1) {
            int i = random.nextInt(menbers.size());
            String key = menbers.remove(i);
            double value = random.nextDouble() * m;
            m -= value;
            result.put(key, value);
        }
        result.put(menbers.remove(0), m);
        return result;
    }


}