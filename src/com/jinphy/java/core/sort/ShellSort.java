package com.jinphy.java.core.sort;


/**
 * Desc: 希尔排序
 * Author: jianhui.jiang
 * Time: 2018/7/31 9:35
 */
public class ShellSort implements  Sort{

    /**
     * Desc: 希尔排序的一个实现
     * Author: jianhui.jiang
     * Time: 2018/7/31 10:06
     */
    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int step = nums.length >> 1;

        while (step > 0) {
            // 分成step 组，然后分别在每组中进行插入排序
            for (int i = 0; i < step; i++) {
                // 排序第i组
                for (int j = i+step; j < nums.length; j += step) {
                    int temp = nums[j];
                    int k = 0;
                    for (k = j - step; k >= 0; k -= step) {
                        if (nums[k] > temp) {
                            nums[k + step] = nums[k];
                        } else {
                            break;
                        }
                    }
                    nums[k + step] = temp;
                }
            }
            step >>= 1;
        }
    }

    /**
     * Desc: 希尔排序另一个实现，推荐
     * Author: jianhui.jiang
     * Time: 2018/7/31 10:00
     */
    public void sort_1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int step = nums.length >> 1;
        while (step > 0) {
            for (int i = step; i < nums.length; i++) {
                int temp = nums[i];
                int j;
                for (j = i - step; j >= 0; j -= step) {
                    if (nums[j] > temp) {
                        nums[j + step] = nums[j];
                    } else {
                        break;
                    }
                }
                nums[j + step] = temp;
            }
            step >>= 1;
        }
    }
}










