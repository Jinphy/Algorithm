package com.jinphy.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchStringByKMP {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findIndexs("aabaabce", "aab")));
    }

    public static int firstIndex(String target, String pattern) {
        char[] t = target.toCharArray();
        char[] p = pattern.toCharArray();
        int[] next = getNext(p);

        int j = 0;

        for (int i = 0; i < t.length; i++) {
            while (j > 0 && t[i] != p[j]) {
                j = next[j];
            }
            if (t[i] == p[j]) {
                j++;
            }
            if (j == p.length) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int lastIndex(String target, String pattern) {

        int index = firstIndex(reverse(target), reverse(pattern));

        return target.length() - pattern.length() - index;
    }

    public static int[] findIndexs(String target, String pattern) {
        char[] t = target.toCharArray();
        char[] p = pattern.toCharArray();
        int[] next = getNext(p);
        List<Integer> indexs = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < t.length; i++) {
            while (j > 0 && t[i] != p[j]) {
                j = next[j];
            }
            if (t[i] == p[j]) {
                j++;
            }
            if (j == p.length) {
                indexs.add(i - j + 1);
                j = next[j];
            }
        }
        if (indexs.size() == 0) {
            return null;
        }
        int[] result = new int[indexs.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = indexs.get(i);
        }
        return result;
    }


    /**
     * 统计字符串target中的subString子串的个数
     *
     * @param target
     * @param subString
     * @return target中子串的个数
     */
    public static int countSubString(String target, String subString) {
        char[] t = target.toCharArray();
        char[] p = subString.toCharArray();
        int[] next = getNext(p);
        int j = 0;
        int counter = 0;
        for (int i = 0; i < t.length; i++) {
            while (j > 0 && t[i] != p[j]) {
                j = next[j];
            }
            if (t[i] == p[j]) {
                j++;
            }
            if (j == p.length) {
                counter++;
                j = next[j];
            }
        }
        return counter;
    }

    /*
         获取字符数组pattern的不同长度子串时前后缀的最大公共部分的长度
         例如：pattern = "aabaacdaa",则长度5时前后缀的最大公共部分的长度
         为2
        */
    private static int[] getNext(char[] pattern) {
        int[] next = new int[pattern.length + 1];
        int j = 0;
        next[0] = next[1] = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = next[j];
            }
            if (pattern[i] == pattern[j]) {
                j++;
            }
            next[i + 1] = j;
        }
        return next;
    }

    /**
     * 翻转字符串
     *
     * @param string
     * @return
     */
    public static String reverse(String string) {
        StringBuilder builder = new StringBuilder(string);
        return builder.reverse().toString();
    }

}
