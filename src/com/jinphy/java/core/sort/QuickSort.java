package com.jinphy.java.core.sort;

/**
 * Desc: 快速排序
 * Author: jianhui.jiang
 * Time: 2018/7/30 14:36
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }


    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int low = left;
        int high = right;
        int key = nums[left];
        while (low < high) {
            while (low < high) {
                if (nums[high--] < key) {
                    nums[low++] = nums[++high];
                    break;
                }
            }
            while (low < high) {
                if (key < nums[low++]) {
                    nums[high--] = nums[--low];
                    break;
                }
            }
        }
        nums[low] = key;

        sort(nums, left, low - 1);
        sort(nums, low + 1, right);
    }
}
