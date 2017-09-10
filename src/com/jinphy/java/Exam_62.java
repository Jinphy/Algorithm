package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam_62 {


    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().trim().split(" {1,}");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int[] ints = toArray(reader.readLine().trim());
        solve(k, ints);
    }

    private static int[] toArray(String str) {
        String[] split = str.split(" {1,}");
        int[] ints = new int[split.length];
        int i=0;
        for (String s : split) {
            ints[i++] = Integer.parseInt(s);
        }
        return ints;
    }

    private static void solve(int k, int... ints) {
        // 保存所有空缺的元素的下标
        List<Integer> indexs = new ArrayList<>(ints.length);
        // 保存空缺的元素的值
        List<Integer> values = new ArrayList<>(ints.length);
        // 获取空缺的下标和空缺的值
        find(values,indexs,ints);
        // 初始的k 值是排列中所有的顺序对，所以把那些没有空缺的元素的顺序对减掉
        k -= getDefaultPairs(ints);
        // 统计排列总数
        int count = count(indexs, values, k, ints);

        System.out.println(count);

    }

    /**
     * 求总共的排列数，用递归调用的方法求解，每次递归在当前空缺的位置放入可选的数，
     * 按照空缺的位置从小到大填数字，如果当前位置填了一个空缺的数，当前总的顺序对还未超过
     * 指定的顺序对数，则填下一个空缺位置，知道填满所有空缺位置，如果此时总的顺序对刚好等于指定的
     * 顺序对则说明这种填法满足条件，是一种合适的排列。另外，在填的过程中，如果填到某个空缺位置是
     * 当前的顺序对已经超过指定的顺序对则无需再当前这种填法递归往后天，应该剪枝，即在该位置换别的
     * 可选空缺数
     *
     * */
    private static int count(List<Integer> indexs, List<Integer> values, int k, int... ints) {
        int count = 0;
        if (indexs.size() == 0) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }
        int index = indexs.remove(0);

        for (int i = 0; i < values.size(); i++) {
            int value = values.get(i);
            ints[index] = value;
            int pairs = getPairs(index, ints);
            if (pairs <= k) {
                values.remove(i);
                count += count(indexs, values, k - pairs, ints);
                values.add(i, value);
            }
        }
        ints[index] = 0;
        indexs.add(0, index);
        return count;
    }

    // 获取当把元素填入下标为index时增加的顺序对
    private static int getPairs(int index, int... ints) {
        int pairs = 0;
        for (int i = 0; i < ints.length; i++) {
            if (i < index && ints[i] < ints[index]) {
                pairs++;
            } else if (i > index && ints[i]>ints[index]) {
                pairs++;
            }
        }
        return pairs;
    }

    private static void find(List<Integer> values, List<Integer>index,int... ints) {
        boolean[] flag = new boolean[ints.length + 1];
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > 0) {
                flag[ints[i]] = true;
            } else {
                index.add(i);
            }
        }
        for (int i = 1; i < flag.length; i++) {
            if (!flag[i]) {
                values.add(i);
            }
        }
    }

    private static int getDefaultPairs(int... ints) {
        int pairs = 0;
        int n = ints.length - 1;
        for (int i = 0; i < n; i++) {
            if (ints[i] > 0) {
                for (int j = i+1;j<ints.length;j++) {
                    if (ints[i] < ints[j]) {
                        pairs++;
                    }
                }
            }
        }
        return pairs;
    }
}
