package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
时间限制：1秒 空间限制：32768K 热度指数：4986
        算法知识视频讲解
        题目描述
        游戏里面有很多各式各样的任务，其中有一种任务玩家只能做一次，这类任务一共有1024个，任务ID范围[1,1024]。请用32个unsigned int类型来记录着1024个任务是否已经完成。初始状态都是未完成。 输入两个参数，都是任务ID，需要设置第一个ID的任务为已经完成；并检查第二个ID的任务是否已经完成。 输出一个参数，如果第二个ID的任务已经完成输出1，如果未完成输出0。如果第一或第二个ID不在[1,1024]范围，则输出-1。
        输入描述:
        输入包括一行,两个整数表示人物ID.
        输出描述:
        输出是否完成
        示例1
        输入

        1024 1024
        输出

        1*/

public class Exam_28 {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] split = reader.readLine().trim().split(" {1,}");
        int id1 = Integer.parseInt(split[0]);
        int id2 = Integer.parseInt(split[1]);
        solve(id1,id2);
    }

    private static void solve(int id1, int id2) {
        if (id1 < 1 || id1 > 1024 || id2 < 1 || id2 > 1024) {
            System.out.println(-1);
        }
        long[] flag = new long[32];
        mark(flag, id1);
        if (isMark(flag, id2)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    /**
     * id最大为1024 共10位，把id的高5位作为标记flag的下标,32个无符号整数正好
     * 是2^5，把低5位作为无符号整数的位偏移，无符号整数也有32位 = 2^5
     *
     * @param flag
     * @param id
     */
    private static void mark(long[] flag,int id) {
        int index = (id-1)>>5;
        int offset = (id-1)&0b11111;
        long set = 1L<<offset;
        flag[index] = flag[index] | set;
    }

    private static boolean isMark(long[] flag, int id) {
        int index = (id-1)>>5;
        int offset = (id-1)&0b11111;
        long check = 1L<<offset;
        return (flag[index] & check) > 0;
    }
}
