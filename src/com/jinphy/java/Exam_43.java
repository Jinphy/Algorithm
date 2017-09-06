package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exam_43 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        buyApple(Integer.parseInt(reader.readLine()));
    }

    /*
    * 因为每袋的个数为6或者8，所有要想刚好买n个苹果则n必须为偶数，
    * 即n = 2a = 8x + 6b, 化简后，a = 4x + 3b,而要想使得袋数最少
    * 则要当尽量让4的个数x最大，所以最大为a/4,但是还有可能有0,1,2,3
    * 四种余数，当余数为0时，表示刚好全部能用4（即用每袋8个）装；
    * 当余数为1时，说明多出一个，此时应该在两个4中此处两个3和两个1，此时的组合
    * 是a/4-2个4和 2+1个3 共a/4+1 个袋子，当余数为2时情况与余数为1时相同，当然
    * 前提是要有足够的4可以拆成3+1，如果令 x = a/4, y = a%4 则经过计算化简后
    * 要满足x+y>=3，此时总袋数为x+1个，否则不能刚好买n个苹果；最后一种余数为3，
    * 说明可以组成a/4个4 和1个3，共a/4+1个袋子
    *
    * */
    public static void buyApple(int n) {
        if ((n & 0b1)!= 0) {// n % 2 !=0
            // n 是奇数，不可能买到刚好需要的个数
            System.out.println(-1);
            return;
        }
        n = n>>1;//n = n/2, 所以刚好能买是 n = 4x + （3的个数）
        int x = n>>2;// x = n /4
        int y = n & 0b11;// y = n % 4，即y = n & (4-1)

        if (y == 0) {
            System.out.println(x);
        } else if (y == 3 || x + y >= 3) {
            System.out.println(x + 1);
        } else{
            System.out.println(-1);

        }
    }
}
