package com.jinphy.java;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Offer_40 {

    public static void main(String[] args) {
    }

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        boolean[] visited = new boolean[123];
        int[] index = new int[123];
        int[] counter = new int[123];
        char[] chars = str.toCharArray();
        for (int x=0;x<chars.length;x++) {
            char i = chars[x];
            counter[i]++;
            if (!visited[i]) {
                visited[i] = true;
                index[i] = x;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 'a'; i <= 'z'; i++) {
            if (counter[i] == 1 && index[i]<result) {
                result = index[i];
            }
        }
        for (int i='A';i<='Z';i++) {
            if (counter[i]==1 && index[i]<result)
                result = index[i];
        }

        return result;
    }


}
