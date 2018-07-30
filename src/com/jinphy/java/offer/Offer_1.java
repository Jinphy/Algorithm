package com.jinphy.java.offer;
/*

时间限制：1秒 空间限制：32768K 热度指数：422340
        本题知识点： 查找
        算法知识视频讲解
        题目描述
        在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*/

public class Offer_1 {
    public static void main(String[] args) {

    }

    public boolean find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int i=0;
        int j = array[0].length-1;
        while (i < array.length && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private boolean binarySearch(int target, int[] array) {
        int left = 0;
        int right = array.length-1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }
}
