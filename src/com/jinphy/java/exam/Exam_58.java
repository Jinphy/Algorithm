package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：7823
        算法知识视频讲解
        题目描述
        有一片1000*1000的草地，小易初始站在(1,1)(最左上角的位置)。小易在每一秒会横向或者纵向移动到相邻的草地上吃草(小易不会走出边界)。大反派超超想去捕捉可爱的小易，他手里有n个陷阱。第i个陷阱被安置在横坐标为xi ，纵坐标为yi 的位置上，小易一旦走入一个陷阱，将会被超超捕捉。你为了去解救小易，需要知道小易最少多少秒可能会走入一个陷阱，从而提前解救小易。
        输入描述:
        第一行为一个整数n(n ≤ 1000)，表示超超一共拥有n个陷阱。
        第二行有n个整数xi，表示第i个陷阱的横坐标
        第三行有n个整数yi，表示第i个陷阱的纵坐标
        保证坐标都在草地范围内。
        输出描述:
        输出一个整数,表示小易最少可能多少秒就落入超超的陷阱
        示例1
        输入

        3
        4 6 8
        1 2 1
        输出

        3
*/


public class Exam_58 {
    private static final int LENGTH = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        int[] xs = toArray(reader.readLine());
        int[] ys = toArray(reader.readLine());
        minTimes(xs, ys);
    }

    private static void minTimes(int[] xs, int[] ys) {
        int x = xs[0];
        int y = ys[0];
        int min = x + y;
        for (int i = 1; i < xs.length; i++) {
            int xy = xs[i] + ys[i];
            if (min > xy) {
                min = xy;
                x = xs[i];
                y = ys[i];
            }
        }
        System.out.println(min- 2);

    }

    private static int[] toArray(String str) {
        String[] split = str.trim().split(" {1,}");
        int[] result = new int[split.length];
        int i=0;
        for (String s : split) {
            result[i++] = Integer.parseInt(s);
        }
        return result;
    }
}