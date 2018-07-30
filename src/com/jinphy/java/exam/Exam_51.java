package com.jinphy.java.exam;

import java.util.Scanner;
/*

时间限制：1秒 空间限制：32768K 热度指数：42849
        算法知识视频讲解
        题目描述
        洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）。接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，直到最后放下左手的第一张牌。接着把牌合并起来就可以了。 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。在洗牌过程中按顺序放下了6,3,5,2,4,1。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
        输入描述:
        第一行一个数T(T ≤ 100)，表示数据组数。对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，接下来一行有2n个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列。
        输出描述:
        对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。
        示例1
        输入

        3 3 1 1 2 3 4 5 6 3 2 1 2 3 4 5 6 2 2 1 1 1 1
        输出

        1 4 2 5 3 6 1 5 4 3 2 6 1 1 1 1
*/


public class Exam_51 {
    public static void main(String[] args) throws Exception{
        Scanner reader = new Scanner(System.in);
        int t = reader.nextInt();
        while (t-- > 0) {
            shuffle(reader);
        }
    }

    private static void shuffle(Scanner reader) {

        int n = reader.nextInt()<<1;
        int k = reader.nextInt();

        int[] cards = new int[n];
        int len = (cards.length - 1) >> 1;
        k = getRepeatCycle(len, k);
        int nn = n - 1;
        cards[0] = reader.nextInt();
        for (int i = 1; i < nn; i++) {
            cards[next(i, len, k)] = reader.nextInt();
        }
        cards[n-1] = reader.nextInt();

        StringBuilder builder = new StringBuilder();

        for (int card : cards) {
            builder.append(card + " ");
        }
        System.out.println(builder.toString().trim());
    }

    /*
    * 在洗牌过程中，当次数达到一定是，就会回到原来的次序，所以要计算循环的周期
    * */
    private static int getRepeatCycle(int len,int k) {
        int count = 0;
        int index = 1;

        do {
            if (index > len) {
                index = ((index - len) << 1) - 1;
            } else {
                index = index << 1;
            }
            count++;
        }while (index != 1 && count<k);
        if (count < k) {
            return k % count;
        }
        return count;
    }

    // 计算在数组下标为index时记过k次洗牌后到达的位置
    private static int next(int index, int len, int k) {
        while (k-- > 0) {
            if (index > len) {
                index = ((index - len) << 1) - 1;
            } else {
                index = index << 1;
            }
        }
        return index;
    }


    /*

    private static void shuffle(int[] cards, int k) {
        if (cards.length == 2) {
            System.out.println(cards[0] + " " + cards[1]);
        }
        int steps = cards.length-2;
        int len = steps >> 1;
        k = getRepeatCycle(len,k);
        int current = 1;
        int next;
        int temp=0;
        while (--steps > 0) {
            System.out.println("current = "+cards[current]);
            next = next(current, len, k);
            temp = cards[next];
            cards[next] = cards[current];

            current = next;
        }
        cards[current] = temp;

        StringBuilder builder = new StringBuilder();

        for (int card : cards) {
            builder.append(card + " ");
        }
        System.out.println(builder.toString().trim());
    }
*/

}
