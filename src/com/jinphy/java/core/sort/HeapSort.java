package com.jinphy.java.core.sort;


import com.jinphy.java.utils.DataUtils;

/**
 * Desc: 堆排序
 * Author: jianhui.jiang
 * Time: 2018/7/30 14:41
 */
public class HeapSort implements Sort {

    @Override
    public void sort(int[] nums) {
        // 创建最大堆
        createMaxHeap(nums);

        // 交换堆顶元素和最后一个叶子结点，然后调整最大堆
        int len = nums.length;
        while (len-- > 1) {
            // 把堆顶元素（数组第一个元素）与最后一个叶子节点交换
            DataUtils.swap(nums, 0, len);

            // 重新调整剩余的最大堆
            heapNode(nums, 0, len, (len >> 1) - 1);
        }
    }


    /**
     * Desc: 建立数组的最大堆
     * Author: jianhui.jiang
     * Time: 2018/7/30 13:40
     */
    private void createMaxHeap(int[] nums) {
        // 最后一个非叶子节点
        int lastNoLeafNode = (nums.length >> 1) - 1;
        for (int i = lastNoLeafNode; i >= 0; i--) {
            heapNode(nums, i, nums.length, lastNoLeafNode);
        }
    }

    /**
     * Desc: 建立当前节点的最大堆
     * Author: jianhui.jiang
     * Time: 2018/7/30 13:39
     */
    private void heapNode(int[] nums, int node, int len, int lastNoLeafNode) {
        if (node > lastNoLeafNode) {
            return;
        }
        int lChild = (node << 1) + 1;
        int rChild = (node << 1) + 2;
        int i = (rChild < len && nums[rChild] > nums[lChild]) ? rChild : lChild;
        if (nums[node] < nums[i]) {
            DataUtils.swap(nums, i, node);
            heapNode(nums, i, len, lastNoLeafNode);
        }
    }

}
