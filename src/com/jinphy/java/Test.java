package com.jinphy.java;

import com.jinphy.java.core.sort.ShellSort;
import com.jinphy.java.core.tree.Huffman;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] nums = {2, 3, -5, 2, 4, 7, -3, -6};

        System.out.println("origin: " + Arrays.toString(nums));

        Huffman.preOrder(Huffman.create(nums));

    }

    private static void mergeSort(int[] nums) {
        mergeSort(nums, Arrays.copyOf(nums, nums.length), 0, nums.length - 1);
    }

    private static void mergeSort(int[] source, int[] temp, int left, int right) {
        if (left == right) {
            return;
        }

        int middle = (left + right) >> 1;
        mergeSort(temp, source, left, middle);
        mergeSort(temp, source, middle + 1, right);

        int k = left;
        int i = left;
        int j = middle + 1;
        int x = middle + 1;
        int y = right + 1;
        while (k < y) {
            if (i < x && j < y) {
                source[k++] = temp[i] < temp[j] ? temp[i++] : temp[j++];
            } else {
                source[k++] = i < x ? temp[i++] : temp[j++];
            }
        }
    }

    private static int findStr(String source, String pattern) {
        char[] s = source.toCharArray();
        char[] p = pattern.toCharArray();
        int[] next = getNext(p);

        int j = 0;
        for (int i = 0; i < s.length; i++) {
            while (j > 0 && s[i] != p[j]) {
                j = next[j];
            }

            if (s[i] == p[j]) {
                j++;
            }
            if (j == p.length) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private static int[] getNext(char[] pattern) {
        int[] next = new int[pattern.length + 1];
        int j = 0;
        next[0] = next[1] = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = next[j];
            }
            if (pattern[i] == pattern[j]) {
                j++;
            }
            next[i + 1] = j;
        }
        return next;
    }


    private static void qSort(int[] nums) {
        qSort(nums, 0, nums.length - 1);
    }

    private static void qSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int key = nums[left];
        int low = left;
        int high = right;
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
        qSort(nums, left, low - 1);
        qSort(nums, low + 1, right);
    }

    private static void heapSort(int[] nums) {
        createMaxHeap(nums);

        int len = nums.length;
        while (len-- > 1) {
            int temp = nums[0];
            nums[0] = nums[len];
            nums[len] = temp;
            heapNode(nums, 0, len, (len >> 1) - 1);
        }

    }


    private static void createMaxHeap(int[] nums) {
        int lastNoLeafNode = (nums.length >> 1) - 1;
        for (int i = lastNoLeafNode; i >= 0; i--) {
            heapNode(nums, i, nums.length, lastNoLeafNode);
        }
    }

    private static void heapNode(int[] nums, int node,int len,int lastNoLeafNode) {
        if (node > lastNoLeafNode) {
            return;
        }

        int lChild = (node >> 1) + 1;
        int rChild = (node >> 1) + 2;

        int i = (rChild < len && nums[rChild] > nums[lChild]) ? rChild : lChild;

        if (nums[node] < nums[i]) {
            int temp = nums[node];
            nums[node] = nums[i];
            nums[i] = temp;
            heapNode(nums, i, len, lastNoLeafNode);
        }
    }
}














