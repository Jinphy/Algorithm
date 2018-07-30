package com.jinphy.java.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：7934
        算法知识视频讲解
        题目描述
        小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
        输入描述:
        输入一个初始位置x_0,范围在1到1,000,000,006
        输出描述:
        输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1
        示例1
        输入

        125000000
        输出

        1
*/


public class Exam_56 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        solve(Integer.parseInt(reader.readLine().trim()));
    }

    /*
    * 两种移动方法：
    *       4*x+3 ==> 4*(x+1)-1; <-----------------------①
    *       8*x+7 ==> 8*(x+1)-1; <-----------------------②
    * 假如第一种移动了a次，第二中移动了b次，则经过计算后位置在
    *       2^(2a+3b)*(x+1)-1;
    * 令n = 2a+3b,则化简得 2^n*(x+1)-1 <----------③,所以只要找到该值是1_000_000_007整数倍即可
    * 如果计算出相应的n为了使得移动的次数少应该尽量让b取最大，因为b是对应①的（每次移动的距离大，
    * 所以在移动了③的距离的情况下，每次移动越多，移动次数就越少
    *
    *
    *
    * */
    private static void solve(long x) {
        int food = 1_000_000_007;
        int n = 4;
        int counter = -1;
        for (int i = 2; i <= 300000; i++) {
            // i 从2开始是因为n = 2a+3b = 4,相当于n = 1<<2
            // 以为n最小只能是4的情况，即式子①所示
            int temp = (int) ((n * (x + 1) - 1) % food);
            if (temp == 0) {
                counter = i / 3 + (i % 3 == 0 ? 0 : 1);
                break;
            }
            n = (n << 1) % food;
        }


        System.out.println(counter);

    }
}
