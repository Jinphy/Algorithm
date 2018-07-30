package com.jinphy.java.core.sort;

import java.util.Arrays;

/**
 * Desc: 归并排序
 * Author: jianhui.jiang
 * Time: 2018/7/30 14:38
 */
public class MergeSort implements Sort{


    @Override
    public void sort(int[] nums) {
        sort(nums, Arrays.copyOf(nums, nums.length), 0, nums.length - 1);
    }


    private void sort(int[] source, int[] temp, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = (left + right) >> 1;

        // 分治法排序两个子数组
        sort(temp, source, left, middle);
        sort(temp, source, middle + 1, right);

        int k = left;
        int i = left;
        int j = middle + 1;

        int x = middle + 1;
        int y = right + 1;
        while (k < y) {
            if (i < x && j < y) {
                source[k++] = temp[i] < temp[j] ? temp[i++] : temp[j++];
            } else{
                source[k++] = i < x ? temp[i++] : temp[j++];
            }
        }
    }

}
