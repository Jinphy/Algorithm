package com.jinphy.java.offer;
/*

时间限制：1秒 空间限制：32768K 热度指数：377338
        本题知识点： 字符串
        算法知识视频讲解
        题目描述
        请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*/

public class Offer_2 {

    public String replaceSpace(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        str = new StringBuffer();
        String replace = "%20";
        for (char c : chars) {
            if (c == ' ') {
                str.append(replace);
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}
