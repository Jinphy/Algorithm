package com.jinphy.java;
/*

时间限制：1秒 空间限制：32768K 热度指数：4833
        算法知识视频讲解
        题目描述
        给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。 比如： （1） “hello xiao mi”-> “mi xiao hello”
        输入描述:
        输入数据有多组，每组占一行，包含一个句子(句子长度小于1000个字符)
        输出描述:
        对于每个测试示例，要求输出句子中单词反转后形成的句子
        示例1
        输入

        hello xiao mi
        输出

        mi xiao hello
*/

import java.util.Scanner;

public class Exam_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String sentence;
        while (true) {
            sentence = reader.nextLine();
            reverseSentence(sentence);
        }
    }

    public static void reverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        String[] resultWords = new String[words.length];
        for (int i = 0;i<words.length;i++) {
            resultWords[i] = words[words.length - i - 1];
        }
        StringBuilder reverseSentence = new StringBuilder();
        for (String resultWord : resultWords) {
            reverseSentence.append(resultWord + " ");
        }
        System.out.println(reverseSentence.toString().trim());

    }
}
