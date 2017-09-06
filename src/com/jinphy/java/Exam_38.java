package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exam_38 {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        zeroNumOffactorialTail(Integer.parseInt(reader.readLine().trim()));
    }

    /*
    * 在0-9十个数字中，能形成尾数为0的只可能是5，并且一个5乘以一个偶数就能形成0的尾数
    * 而在1~n的数字中必定存在偶数的个数大于5的个数，所以n！中，要计算尾数0的个数，只需
    * 知道5的个数即可，例如50！ = 50 *49 *48*......*2*1，而其中能分解成含有因子5的数只能是5的倍数
    * ，例如 50 = 5*10、45 = 5*9、40、35、30、25、20、15、10 = 5*2、5 = 5*1，所以第一次能拆成
    * 50/5 = 10个因子5，但是还有5未全部被拆出来，本例子中有5*10中的10可以拆成5*2, 25 = 5*5中的5可以
    * 拆成5*1
    * 所以求5的个数的方法应该是n/5 + n/5^2 + n/5^3...,一直除到n/5^m=0为止
    *
    * */
    private static void zeroNumOffactorialTail(int n) {
        int count = 0;
        do {
            n /= 5;
            count += n;
        } while (n > 0);

        System.out.println(count);
    }
}
