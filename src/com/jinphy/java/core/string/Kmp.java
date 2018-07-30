package com.jinphy.java.core.string;

public class Kmp {


    public int find(String haystack, String needle) {
        if(needle==null || needle.length() == 0){
            return 0;
        }
        if(haystack==null || haystack.length() == 0){
            return -1;
        }
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int[] next = getNext(n);

        int j = 0;

        for(int i = 0; i < h.length; i++){
            while(j > 0 && h[i] != n[j]){
                j = next[j];
            }
            if(h[i] == n[j]){
                j++;
            }
            if(j == n.length){
                return i -j +1;
            }
        }

        return -1;
    }



    /**
     *  求字符串p的不同长度子串的前后缀（前后缀不能是字符串本身）的最长公共部分
     *  例如：字符串 "abbaa" 的长度为四的子串为："abba",其前后缀的最长公共部分为a，所以长度为1
     *
     */
    private int[] getNext(char[] p){
        // 存放不同长度子串的最长公共前后缀
        int[] next = new int[p.length+1];

        next[0] = next[1] = 0;

        int j=0;
        for(int i = 1;i<p.length;i++){
            while(j > 0 && p[i] != p[j]){
                j = next[j];
            }
            if(p[i] == p[j]){
                j++;
            }
            next[i+1] = j;
        }
        return next;
    }
}