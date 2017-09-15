package com.jinphy.java;
/*

时间限制：1秒 空间限制：32768K 热度指数：67967
        本题知识点： 字符串
        算法知识视频讲解
        题目描述
        将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
        输入描述:
        输入一个字符串,包括数字字母符号,可以为空
        输出描述:
        如果是合法的数值表达则返回该数字，否则返回0
        示例1
        输入

        +2147483647
        1a33
        输出

        2147483647
        0
*/


public class Offer_50 {


    public int StrToInt(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean positive = true;
        if (str.startsWith("-")) {
            positive = false;
            str = str.substring(1);
        } else if (str.startsWith("+")) {
            str = str.substring(1);
        }
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c < '0' || c > '9') {
                return 0;
            }
        }
        int index;
        for (index=0;index<chars.length;index++) {
            if (chars[index] != '0') {
                break;
            }
        }
        if (index == chars.length) {
            return 0;
        }
        int result=0;
        for (int i=index;i<chars.length;i++) {
            result *= 10;
            result += (chars[i] - '0');
        }

        return positive?result:-result;
    }
}
