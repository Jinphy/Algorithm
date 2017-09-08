package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*

时间限制：1秒 空间限制：32768K 热度指数：6690
        算法知识视频讲解
        题目描述
        小易邀请你玩一个数字游戏，小易给你一系列的整数。你们俩使用这些整数玩游戏。每次小易会任意说一个数字出来，然后你需要从这一系列数字中选取一部分出来让它们的和等于小易所说的数字。 例如： 如果{2,1,2,7}是你有的一系列数，小易说的数字是11.你可以得到方案2+2+7 = 11.如果顽皮的小易想坑你，他说的数字是6，那么你没有办法拼凑出和为6 现在小易给你n个数，让你找出无法从n个数中选取部分求和的数字中的最小数。
        输入描述:
        输入第一行为数字个数n (n ≤ 20)
        第二行为n个数xi (1 ≤ xi ≤ 100000)
        输出描述:
        输出最小不能由n个数选取求和组成的数
        示例1
        输入

        3
        5 1 2
        输出

        4
*/

public class Exam_52 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        String[] split = reader.readLine().trim().split(" {1,}");
        int[] ints = new int[n];
        int i=0;
        for (String s : split) {
            ints[i++] = Integer.parseInt(s);
        }
        findMinMiss(ints);
    }

    /*
    * 要找到最小不能用给定的n个数相加得到的那个数，有一点很重要，就是在这个数之前的数都可以被
    * 相加得到，例如如果找到的是5，则1~4都可以被找到，所以先对n个数按升序的方式排序，假设找到的是
    * 数x，则1 ~ x-1都可以被相加得到，所以必须首先有最小值1，当前能加到的最大值为1，有了1就要有2，
    * 可以是1，1，此时能加到的最大值是2，也可以是1,2，此时的最大值是3，但是不能是1,3因为这样中间就缺了
    * 2，如果当前能加到的最大值是7，则说明前面可以找到1~7的和，如果此时再有一个小于等于8的元素，则8可以与前面的
    * 1~7相加得到连续的1~15，此时最大能加到的最大值为15；但是不能再最大值为7时，没有小于等于8的数，例如是9，
    * 由于前面1~7的最大值是7，即在加入这个元素9之前最大只能加到7，不能加到8，而此时加入的是9，所以中间的8将缺失
    * ，所以加上在处理第 i个元素时，当前能加到的最大值是max,则当ints[i]>max+1,则最小不能用给定的n个数相加得到的
    * 数即找到：max+1
    *
    *
    * */
    public static void findMinMiss(int[] ints) {
        int currentMax = 0;
        Arrays.sort(ints);

        for (int x : ints) {
            if (x > currentMax + 1) {
                break;
            }
            currentMax+=x;
        }
        System.out.println(currentMax+1);
    }
}
