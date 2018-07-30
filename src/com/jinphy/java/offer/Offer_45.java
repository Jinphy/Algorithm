package com.jinphy.java.offer;
/*

时间限制：1秒 空间限制：32768K 热度指数：78936
        本题知识点： 数组
        算法知识视频讲解
        题目描述
        一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
*/

public class Offer_45 {

/*
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Number> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Number x = map.get(array[i]);
            if (x == null) {
                x = new Number();
                x.index = i;
                map.put(array[i], x);
            }
            x.count++;
        }
        Collection<Number> values = map.values();
        Number x = null;
        Number y = null;
        for (Number value : values) {
            if (value.count == 1) {
                if (x == null) {
                    x = value;
                } else {
                    y = value;
                    break;
                }
            }
        }
        if (x.index < y.index) {
            num1[0] = array[x.index];
            num2[0] = array[y.index];
        } else {
            num1[0] = array[y.index];
            num2[0] = array[x.index];
        }
    }
    public class Number{
        int count;
        int index;
    }
    */


/*考虑过程：
     首先我们考虑这个问题的一个简单版本：一个数组里除了一个数字之外，其他的数字都出现了两次。
     请写程序找出这个只出现一次的数字。这个题目的突破口在哪里？题目为什么要强调有一个数字出现一次，
     其他的出现两次？我们想到了异或运算的性质：任何一个数字异或它自己都等于0 。也就是说，如果我们从
     头到尾依次异或数组中的每一个数字，那么最终的结果刚好是那个只出现一次的数字，因为那些出现两次的
     数字全部在异或中抵消掉了。有了上面简单问题的解决方案之后，我们回到原始的问题。如果能够把原数组
     分为两个子数组。在每个子数组中，包含一个只出现一次的数字，而其它数字都出现两次。如果能够这样拆
     分原数组，按照前面的办法就是分别求出这两个只出现一次的数字了。我们还是从头到尾依次异或数组中的
     每一个数字，那么最终得到的结果就是两个只出现一次的数字的异或结果。因为其它数字都出现了两次，在
     异或中全部抵消掉了。由于这两个数字肯定不一样，那么这个异或结果肯定不为0 ，也就是说在这个结果数
     字的二进制表示中至少就有一位为1 。我们在结果数字中找到第一个为1 的位的位置，记为第N 位。现在我
     们以第N 位是不是1 为标准把原数组中的数字分成两个子数组，第一个子数组中每个数字的第N 位都为1 ，
     而第二个子数组的每个数字的第N 位都为0 。现在我们已经把原数组分成了两个子数组，每个子数组都包含
     一个只出现一次的数字，而其它数字都出现了两次。因此到此为止，所有的问题我们都已经解决。*/

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int xor = 0;
        for (int x : array) {
            xor ^= x;
        }
        int bit = 1;
        while ((bit & xor) == 0) {
            bit <<= 1;
        }
        num1[0] = 0;
        num2[0] = 0;
        for (int x : array) {
            if ((x & bit) == 0) {
                num1[0] ^= x;
            } else {
                num2[0] ^= x;
            }
        }
    }
}
