package com.jinphy.java;

import java.util.Arrays;
/*
时间限制：1秒 空间限制：32768K 热度指数：108723
        本题知识点： 数组
        算法知识视频讲解
        题目描述
        在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
        输入描述:
        题目保证输入的数组中没有的相同的数字
        数据范围：
        对于%50的数据,size<=10^4
        对于%75的数据,size<=10^5
        对于%100的数据,size<=2*10^5
        示例1
        输入

        1,2,3,4,5,6,7,0
        输出

        7*/


public class Offer_41 {

    public int InversePairs(int [] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int[] copy = Arrays.copyOf(array, array.length);
        Counter counter = new Counter();

        pairs(0, array.length - 1, counter,array,copy,false);

        return counter.value;
    }

    /**
     *
     * 用分治法对数组进行排序，然后在每次合并的过程中统计逆序对的个数，但是有一点
     * 如果每次合并都创建一个辅助数组来存放当前合并的结果的话，将会内存超限，因为在
     * 分治的过程中，将会创建很多辅助数组，所以这里传入一个原数组的备份数组作为辅助数组
     * 在每层合并的过程中，交替的把结果合并到array或者assit（辅助）数组中，从而可以不用
     * 每次都使用新数组来存放合并结果，节省大量空间。
     * @param left 当前分治左下标
     * @param right 当前分治右下标
     * @param counter 逆序对统计器
     * @param array 原数组
     * @param assist 辅助数组，初始时是原数组的拷贝
     * @param useAssist 标记，作用是在分治的当前层，是否使用辅助数组来存放合并结果，true时表示用辅助数组存放合并结果，
     *                  false时表示用原数组存放当前层分治的合并结果
     */
    public void pairs(int left, int right,Counter counter, int[] array,int[] assist,boolean useAssist) {
        if (left == right) {
            return;
        }
        int mid = (left + right) >> 1;
        pairs(left, mid, counter, array,assist,!useAssist);
        pairs(mid + 1, right, counter, array,assist,!useAssist);

        int k = left;
        int i=left;
        int j = mid+1;
        int[] a;
        int[] b;

        if (useAssist) {
            a = array;
            b = assist;
        } else {
            a = assist;
            b = array;
        }

        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                b[k++] = a[i++];
            } else {
                counter.value += mid+1-i;
                counter.value %= 1000000007;
                b[k++] = a[j++];
            }
        }
        while (i <= mid) {
            b[k++] = a[i++];
        }
        while (j <= right) {
            b[k++] = a[j++];
        }
    }

    private class Counter{
        int value;
    }



}

