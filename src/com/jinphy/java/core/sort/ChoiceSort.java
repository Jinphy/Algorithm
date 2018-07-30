package com.jinphy.java.core.sort;

/**
 * Desc: 选择排序
 * Author: jianhui.jiang
 * Time: 2018/7/30 14:40
 */
public class ChoiceSort implements Sort {


    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int n = nums.length - 1;
        int min;
        int k;
        for (int i = 0; i < n; i++) {
            min = nums[i];
            k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    k = j;
                }
            }
            nums[k] = nums[i];
            nums[i] = min;
        }
    }
}
