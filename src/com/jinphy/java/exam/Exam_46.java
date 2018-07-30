package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：12286
        算法知识视频讲解
        题目描述
        一个只包含'A'、'B'和'C'的字符串，如果存在某一段长度为3的连续子串中恰好'A'、'B'和'C'各有一个，那么这个字符串就是纯净的，否则这个字符串就是暗黑的。例如：
        BAACAACCBAAA 连续子串"CBA"中包含了'A','B','C'各一个，所以是纯净的字符串
        AABBCCAABB 不存在一个长度为3的连续子串包含'A','B','C',所以是暗黑的字符串
        你的任务就是计算出长度为n的字符串(只包含'A'、'B'和'C')，有多少个是暗黑的字符串。
        输入描述:
        输入一个整数n，表示字符串长度(1 ≤ n ≤ 30)
        输出描述:
        输出一个整数表示有多少个暗黑字符串
        示例1
        输入

        2
        3
        输出

        9
        21
*/

public class Exam_46 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            countDarkStrings(Integer.parseInt(reader.readLine().trim()));
        }
    }

    /*
    * 采用动态规划解此问题，要求长度规模为n的字符串中黑暗字符串的个数先求长度
    * 规模为n-1的字符串中黑暗字符的个数，所以求长度为n时，即求n+1长度的字符串加上
    * 最后一个字符时黑暗字符串的个数，显然此时只需要在规模为n-1时所有黑暗字符串中统计就行
    * 而在长度为n-1的黑暗字符串中前n-1个字符已经是知道了的无需再判断，只需用把长度为
    * n-1的字符串中的最后两个字符与新加进来的第n个字符比较，而最后两个字符只用两种情况
    * 要么相同（xx),要么不同(xy),所以只需要知道这两种结果在长度为n-1的黑暗字符串中分别
    * 占的比例就可以，而加上最后一个字符后要保证还是黑暗字符串则只能是xx变成xxx或者xyx,
    * xy只能是xyx,xyy,然后在更新两者的比例，再求长度更大的字符串的黑暗字符串的个数。
    *
    * */
    private static void countDarkStrings(int n) {
        if (n == 0) {
            System.out.println(0);
        } else if (n==1) {
            System.out.println(3);
        } else if (n == 2) {
            System.out.println(9);
        } else {
            long[] xx = new long[n + 1];//以两个相同字符结尾的黑暗字符串的个数，例如AA
            long[] xy = new long[n + 1];//以两个不同字符结尾的黑暗字符串的个数，例如AB
            xx[2] = 3;
            xy[2] = 6;
            for (int i = 3; i <= n; i++) {
                // 这两个式子是根据比例换算后的化简式,分别求长度为 i 时，以相同字符结尾和以不同字符结尾的
                // 黑暗字符串的个数
                xx[i] = xx[i - 1] + xy[i - 1];
                xy[i] = (xx[i - 1] << 1) + xy[i - 1];
            }
            System.out.println(xx[n] + xy[n]);
        }

    }
}
