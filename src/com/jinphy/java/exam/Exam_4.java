package com.jinphy.java.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*时间限制：1秒 空间限制：32768K 热度指数：1807
        算法知识视频讲解
        题目描述
        继MIUI8推出手机分身功能之后，MIUI9计划推出一个电话号码分身的功能：首先将电话号码中的每个数字加上8取个位，然后使用对应的大写字母代替 （"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"）， 然后随机打乱这些字母，所生成的字符串即为电话号码对应的分身。
        输入描述:
        第一行是一个整数T（1 ≤ T ≤ 100)表示测试样例数；接下来T行，每行给定一个分身后的电话号码的分身（长度在3到10000之间）。
        输出描述:
        输出T行，分别对应输入中每行字符串对应的分身前的最小电话号码（允许前导0）。
        示例1
        输入

        4
        EIGHT
        ZEROTWOONE
        OHWETENRTEO
        OHEWTIEGTHENRTEO
        输出

        0
        234
        345
        0345*/
public class Exam_4 {
//    public static String[] numbers = {
//            "ZERO",//z
//            "ONE",//o-zero-two-four
//            "TWO",//w
//            "THREE",//t-two-eight
//            "FOUR",//f-five
//            "FIVE",//v-seven
//            "SIX",//x
//            "SEVEN",//s-six
//            "EIGHT",//g
//            "NINE"//i-five-six-eight
//            // z->w->x->g->s->v->f->t->o->i
//            // zero->two->six->eight->seven->five->four->three->one->nine
//    };
    public static Map<Character, Integer> chars = new HashMap(26);
    public static int[] num = new int[10];
    private static HashMap<Integer, Integer> numMap = new HashMap<>(10);

    static {
        for (int i = 0; i < num.length; i++) {
            num[i] = (i + 2) % 10;
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int t = reader.nextInt();
        String str;
        reader.nextLine();
        while (t-- > 0) {
            str = reader.nextLine();
            printMinNumber(str);
        }
    }

    public static void printMinNumber(String str) {
        initMap();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            chars.put(c, chars.get(c) + 1);
        }
        numMap.put(num[0], chars.get('Z'));
        numMap.put(num[2], chars.get('W'));
        numMap.put(num[6], chars.get('X'));
        numMap.put(num[8], chars.get('G'));
        numMap.put(num[7], chars.get('S') - numMap.get(num[6]));
        numMap.put(num[5], chars.get('V') - numMap.get(num[7]));
        numMap.put(num[4], chars.get('F') - numMap.get(num[5]));
        numMap.put(num[3], chars.get('T') - numMap.get(num[2]) - numMap.get(num[8]));
        numMap.put(num[1], chars.get('O') - numMap.get(num[0]) - numMap.get(num[2]) - numMap.get(num[4]));
        numMap.put(num[9], chars.get('I') - numMap.get(num[5]) - numMap.get(num[6]) - numMap.get(num[8]));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int count = numMap.get(i);
            for (int j = 0; j < count; j++) {
                result.append(i);
            }
        }
        System.out.println(result.toString());
    }

    private static void initMap() {
        for (int i = 0; i < 26; i++) {
            chars.put(((char) ('A' + i)), 0);
        }
        for (int i = 0; i < 10; i++) {
            numMap.put(i, 0);
        }
    }


}
