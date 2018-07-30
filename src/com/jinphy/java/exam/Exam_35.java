package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exam_35 {
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printLongesgNumber(reader.readLine());
    }

    private static void printLongesgNumber(String string) {
        char[] chars = string.toCharArray();
        int index= -1;
        int maxLengthIndex=-1;
        int length = 0;
        int maxLength = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                if (index == -1) {
                    index = i;
                }
                length++;
            } else {
                if (index != -1 && maxLength < length) {
                    maxLength = length;
                    maxLengthIndex = index;
                }
                length=0;
                index = -1;
            }
        }
        if (length > maxLength) {
            maxLength = length;
            maxLengthIndex = index;
        }
        System.out.println(string.substring(maxLengthIndex, maxLengthIndex+maxLength));

    }
}
