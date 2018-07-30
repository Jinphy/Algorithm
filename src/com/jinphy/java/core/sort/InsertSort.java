package com.jinphy.java.core.sort;

/**
 * Desc: 插入排序
 * Author: jianhui.jiang
 * Time: 2018/7/30 14:35
 */
public class InsertSort implements Sort{


    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] > val) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = val;
        }
    }
}
