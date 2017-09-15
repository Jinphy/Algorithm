package com.jinphy.java;
/*

时间限制：1秒 空间限制：32768K 热度指数：144134
        算法知识视频讲解
        题目描述
        给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
*/

public class Offer_20 {


    public double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        int e = Math.abs(exponent);
        double result = 1;
        while (e-- > 0) {
            result*=base;
        }
        return exponent > 0 ? result : 1 / result;
    }
}