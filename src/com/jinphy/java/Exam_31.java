package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;



/*
*时间限制：1秒 空间限制：32768K 热度指数：5509
 算法知识视频讲解
题目描述
输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
输入描述:
每个测试输入包含2个字符串
输出描述:
输出删除后的字符串
示例1
输入

They are students.
aeiou
输出

Thy r stdnts.
*
*
*
* 该题的思路：
*   java中所有的字符都是两个字节，即所有的字符都占16位，所以所有字符的总个数最多为2^16-1个，
*   在该题中，有两个字符串，要求删除第一个字符串中所有在第二个字符串中出现的字符，思路是，先标记
*   第二个字符串中的所有出现个的字符，然后再删除第一个字符串中被标记过的字符。如果把字符是否出现过
*   按照字符char的转换为int作为下标保存在数组中，则需要开2^16长度的数组才足够保存信息，显然不切实际，
*   那么，前面提到的char有16位，而一个long型有64位，如果用一个long型整数中的1位来表示一个字符是否出现过
*   是则置1，否则置0，那么一个long型的整数可以保存64个字符是否出现过的信息，那么总共2^16个字符只需要
*   (2^16) / (64) = 2^10, 即1024个long型的整数即可保存，所以，只要声明一个长度为1024的long型数组即可
*   这样，在判断或者设置某个字符是否出现时，只需要将个16位的char型字符的高10的值作为数组下标索引，将
*   低6位的值作为数组对应下标下的元素的某一位的位置即可。
*
*
*
* */
public class Exam_31 {


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String one = reader.readLine();
        String two = reader.readLine();
        delete(one, two);
    }

    private static void delete(String one, String two) {
        long[] flags = scan(two);
        char[] chars = one.toCharArray();
        StringBuilder result = new StringBuilder(chars.length);
        for (char c : chars) {
            if (!canDelete(flags, c)) {
                result.append(c);
            }
        }
        System.out.println(result);
    }

    private static long[] scan(String string) {
        char[] chars = string.toCharArray();
        long[] flags = new long[1024];

        for (char c : chars) {
            mark(flags, c);
        }
        return flags;
    }

    private static void mark(long[] flags, char c) {
        int index = c >>> 6;
        int offset = c & 0b111111;
        long set = 1L << offset;

        flags[index] = flags[index] | set;
    }

    private static boolean canDelete(long[] flags, char c) {
        int index = c >>> 6;
        int offset = c & 0b111111;
        long check = 1L << offset;

        return (flags[index] & check)==check;
    }
}
