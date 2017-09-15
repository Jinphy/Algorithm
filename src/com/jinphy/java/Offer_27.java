package com.jinphy.java;

import java.util.ArrayList;
/*

时间限制：1秒 空间限制：32768K 热度指数：162056
        本题知识点： 数组
        算法知识视频讲解
        题目描述
        输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
        例如，如果输入如下矩阵：
        1  2  3  4
        5  6   7 8
        9 10 11 12
        13 14 15 16
        则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
*/


public class Offer_27 {


    public static void main(String[] args) {

    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int n0 = 0;
        int m0 = 0;
        int n1 = matrix.length;
        int m1 = matrix[0].length;
        int len = n1 * m1;
        ArrayList<Integer> out = new ArrayList<>(len);
        int i=0;
        int j=0;
        int count=0;
        while (true) {
            // 向右打印
            for (j=m0;j<m1;j++) {
                out.add(matrix[i][j]);
                count++;
                if (count == len) {
                    return out;
                }
            }
            j--;
            n0++;
            // 向下打印
            for (i=n0;i<n1;i++) {
                out.add(matrix[i][j]);
                count++;
                if (count == len) {
                    return out;
                }
            }
            i--;
            m1--;
            //向左打印
            for (j--;j>=m0;j--) {
                out.add(matrix[i][j]);
                count++;
                if (count == len) {
                    return out;
                }
            }
            j++;
            n1--;
            // 向上打印
            for (i--;i>=n0;i--) {
                out.add(matrix[i][j]);
                count++;
                if (count == len) {
                    return out;
                }
            }
            i++;
            m0++;
        }

    }
}
