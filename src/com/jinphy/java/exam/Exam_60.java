package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
/*

时间限制：1秒 空间限制：32768K 热度指数：10082
        算法知识视频讲解
        题目描述
        一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
        例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
        你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
        输入描述:
        第一行输入一个正整数n(n ≤ 1000)
        第二行为n个数正整数xi(xi ≤ 1000)
        输出描述:
        输出可以产生的幸运的袋子数
        示例1
        输入

        3
        1 1 1
        输出

        2
*/


public class Exam_60 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String[] split = reader.readLine().trim().split(" {1,}");
        int[] bolls = new int[split.length];
        int i = 0;
        for (String s : split) {
            bolls[i++] = Integer.parseInt(s);
        }
        solve(bolls);
    }

    private static void solve(int[] bolls) {
        Arrays.sort(bolls);
        System.out.println(luckyBag(bolls, 0, 0, 1));
    }

    private static int luckyBag(int[] bolls, int pos, long sum, long product) {
        int count = 0;
        long newSum;
        long newProduct;
        for (int i = pos; i < bolls.length; i++) {
            newSum = sum + bolls[i];
            newProduct = product * bolls[i];
            if (newSum > newProduct) {
                count += 1 + luckyBag(bolls, i + 1, newSum, newProduct);
            } else if (bolls[i] == 1) {
                count += luckyBag(bolls, i + 1, newSum, newProduct);
            } else {
                break;
            }
            while (i < bolls.length - 1 && bolls[i] == bolls[i + 1]) {
                i++;
            }
        }

        return count;
    }

}
