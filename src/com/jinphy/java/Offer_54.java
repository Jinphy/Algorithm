package com.jinphy.java;

public class Offer_54 {


    public static void main(String[] args) {
        String str = "123.45e+6";
        isNumeric(str.toCharArray());
    }

    public static boolean isNumeric(char[] str) {
        int dot = -1;
        int e = -1;
        // 遍历字符串，如果"." 或者 "e/E"有出现两次则非法
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '.') {
                if (dot == -1) {
                    dot = i;
                } else {
                    // "."出现两次
                    return false;
                }
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (e == -1) {
                    e = i;
                } else {
                    // "e/E"出现两次
                    return false;
                }
            } else if ((str[i] == '+') || str[i] == '-') {
                if (i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    // "-/+"不在第一个位置或者不在"e/E"后面
                    return false;
                }

            } else if (str[i] < '0' || str[i] > '9') {
                // 非法字符
                return false;
            }
        }// end for

        if (e != -1 && dot != -1) {
            // "." 和"e/E"都出现一次
            if (e == str.length - 1 || e < dot) {
                // "+/-" 在末尾,或"." 在 "e/E" 后面
                return false;
            }
        } else if (e != -1) {
            // "e/E" 出现一次
            if (e == str.length - 1 || e == 0 || ((str[0] == '-' || str[0] == '+') && e == 1)) {
                return false;
            }
        }
        return true;
    }
}
