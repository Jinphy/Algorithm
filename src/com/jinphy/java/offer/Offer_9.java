package com.jinphy.java.offer;
/*

时间限制：1秒 空间限制：32768K 热度指数：106536
        算法知识视频讲解
        题目描述
        我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
*/


public class Offer_9 {


    public int rectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int preOne = 2;
        int preTwo = 1;
        int current = 0;
        for (int i = 3; i <= target; i++) {
            current = preOne + preTwo;
            preTwo = preOne;
            preOne = current;
        }

        return current;
    }

}
