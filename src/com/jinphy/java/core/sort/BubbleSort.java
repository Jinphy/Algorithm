package com.jinphy.java.core.sort;

/**
 * Desc: 冒泡排序
 * Author: jianhui.jiang
 * Time: 2018/7/30 14:35
 */
public class BubbleSort implements Sort {


    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int temp;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
