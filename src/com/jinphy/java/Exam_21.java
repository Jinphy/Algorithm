package com.jinphy.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
// 保卫方案


public class Exam_21 {

    private static long pairs;
    private static int n ;
    private static int len ;
    private static int maxHeight;
    private static int[] heights = new int[1000000];

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        len = reader.nextInt();
        for (int i = 0; i < len; i++) {
            heights[i] = reader.nextInt();
        }
        countPairs(heights);
    }

    private static void countPairs(int[] heights) {
        Sentry[] sentries = Sentry.transformAndSort(heights,len);
        Sentry maxSentry = new Sentry();
        pairs = 0;
        n = len - 1;
        maxHeight = 0;
        for (int i = 0; i< n; i++) {
            maxHeight = 0;
            Sentry.setMaxHeight(sentries,maxSentry,i,i+1);

            for (int j = i+1;j<len;j++) {
                if (canPair(heights[i], heights[j], maxHeight)) {
                    pairs++;
                    maxHeight = heights[j];
                } else if (canPair(heights[i], heights[j], maxSentry.height)) {
                    pairs++;
                }
                if (maxSentry.index == j + 1) {
                    Sentry.updateMaxHeight(sentries,maxSentry,i,j+1);
                }
            }
        }
        System.out.println(pairs);

    }


    private static boolean canPair(int a, int b, int max) {
        if (max > a || max > b) {
            return false;
        }
        return true;
    }

    private static class Sentry{
        public int height;
        public int index;
        public static int start;

        public Sentry(){}

        public Sentry(int index, int height) {
            this.index = index;
            this.height = height;
        }

        public static Sentry[] transformAndSort(int[] heights, int len) {
            Sentry[] sentries = new Sentry[len];
            for (int i = 0; i < len; i++) {
                sentries[i] = new Sentry(i, heights[i]);
            }
            Arrays.sort(sentries, new Comparator<Sentry>() {
                @Override
                public int compare(Sentry o1, Sentry o2) {
                    return o1.height-o2.height;
                }
            });
            Sentry.start = len-1;
            return sentries;
        }

        public static void setMaxHeight(Sentry[] sentries, Sentry maxHeightSentry, int outStart, int outEnd) {
            start = sentries.length-1;
            if (sentries[start].index == outStart || sentries[start].index == outEnd) {
                updateMaxHeight(sentries, maxHeightSentry, outStart, outEnd);
            } else {
                maxHeightSentry.height = sentries[start].height;
                maxHeightSentry.index = sentries[start].index;
            }
        }

        public static void updateMaxHeight(Sentry[] sentries, Sentry maxHeightSentry, int outStart, int outEnd) {
            start--;
            for (int i = start;i>=0;i--) {
                if (sentries[i].index < outStart || sentries[i].index > outEnd) {
                    maxHeightSentry.height = sentries[i].height;
                    maxHeightSentry.index = sentries[i].index;
                    return;
                }
            }
            maxHeightSentry.height = 0;
            maxHeightSentry.index = -1;
        }
    }
}



/*

public class Exam_21 {

    private static long pairs;
    private static int n ;
    private static int len ;
    private static int maxA;
    private static int maxB;
    private static boolean[] succeed = new boolean[1000000];
    private static int[] heights = new int[1000000];

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        len = reader.nextInt();
        for (int i = 0; i < len; i++) {
            heights[i] = reader.nextInt();
        }
        countPairs(heights);
    }

    private static void countPairs(int[] heights) {
        pairs = 0;
        n = len - 1;
        maxA = 0;
        maxB =0;
        for (int i = 0; i< n; i++) {
            maxA = 0;
            for (int j = i+1; j < len; j++) {
                if (canPass(heights[i], heights[j], maxA)) {
                    pairs++;
                    succeed[j] = true;
                }
                maxA = Math.max(maxA, heights[j]);
            }
            maxA = maxB;
            for (int j = n;j>=i+1;j--) {
                if (!succeed[j] && canPass(heights[i], heights[j], maxA)) {
                    pairs++;
                }
                succeed[j] = false;
                maxA = Math.max(maxA, heights[j]);
            }
            maxB = Math.max(maxB, heights[i]);
        }
        System.out.println(pairs);

    }

    private static boolean canPass(int a, int b, int max) {
        if (max > a || max > b) {
            return false;
        }
        return true;
    }
}
*/
