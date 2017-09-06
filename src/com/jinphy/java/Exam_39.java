package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
/*

时间限制：1秒 空间限制：32768K 热度指数：4746
        算法知识视频讲解
        题目描述
        小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
        输入描述:
        输入包括n+1行:

        第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)

        接下来的n行:

        每行m个0或者1,以空格分隔
        输出描述:
        如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,则输出"Can not escape!"。
        测试数据保证答案唯一
        示例1
        输入

        4 4 10
        1 0 0 1
        1 1 0 1
        0 1 1 1
        0 0 1 1
        输出

        [0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
*/


public class Exam_39 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().trim().split(" {1,}");
        byte n = Byte.parseByte(split[0]);

        byte m = Byte.parseByte(split[1]);
        int p = Integer.parseInt(split[2]);
        boolean[][] nodes = new boolean[n][m];
        for (byte i = 0; i < n; i++) {
            split = reader.readLine().trim().split(" {1,}");
            for (byte j = 0; j < m; j++) {
                nodes[i][j] = split[j].charAt(0) == '1';
            }
        }
        solve(n,m,p,nodes);

    }

    // 解决该为题的函数
    private static void solve(byte n, byte m, int p, boolean[][] nodes) {
        boolean[][] visited = new boolean[n][m];
        Stack<Integer> stack = new Stack<>();
        byte i = 0;
        byte j = 0;
        int counter = 0;
        stack.push(compress((byte) 0, (byte) 0,0));
        visited[0][0] = true;
        while (!stack.empty()) {
            if (finished(i, j, m)) {
                if (counter <= p) {
                    printRoute(stack);
                } else {
                    System.out.println("Can not escape!");
                }
                return;
            }

            // 开始位置在左下角，结束位置在右下角
            if (i - 1 > -1 && !visited[i - 1][j] && nodes[i - 1][j]) {
                // 先向下判断
                visited[--i][j] = true;
                stack.push(compress(i, j,0));
            } else if (j + 1 < m && !visited[i][j + 1] && nodes[i][j + 1]) {
                // 再右上判断
                visited[i][++j] = true;
                stack.push(compress(i, j,1));
                counter += 1;
            } else if (i + 1 < n && !visited[i + 1][j] && nodes[i + 1][j]) {
                // 再向上判断
                visited[++i][j] = true;
                stack.push(compress(i, j,3));
                counter += 3;
            } else if (j - 1 > -1 && !visited[i][j - 1] && nodes[i][j - 1]) {
                // 最后向左判断
                visited[i][--j] = true;
                stack.push(compress(i, j,1));
                counter +=1;
            } else {
                // 如果四个方向都不能过则只能退回到上个访问的节点
                int node = stack.pop();
                counter -= getValue(node);
                node = stack.peek();
                i = getI(node);
                j = getJ(node);
            }

        }
        System.out.println("Can not escape!");
    }

    // 输出结果路径的函数
    private static void printRoute(Stack<Integer> stack) {
        StringBuilder builder = new StringBuilder(printIJ(stack.pop()));
        while (!stack.empty()) {
            builder.insert(0, printIJ(stack.pop()) + ",");
        }
        System.out.println(builder);

    }

    // 返回形式化后的节点位置的函数如[1,2]
    private static String printIJ(int node) {
        byte i = getI(node);
        byte j = getJ(node);
        return "[" + i + "," + j + "]";
    }

    // 将 i,j,和到达(i,j)点时需要消耗的力量值压缩成一个int型作为压栈的值
    private static int compress(byte i, byte j,int value) {
        return (value<<8) | (i<<4) | j;
    }

    // 从栈中弹出的元素node中解析下标i
    private static byte getI(int node) {
        return (byte) ((node >>> 4) &0b1111);
    }

    // 从栈中弹出的元素node中解析下标j
    private static byte getJ(int node) {
        return (byte) (node & 0b1111);
    }

    // 从栈中弹出的元素node中解析到达该节点需要消耗的力量值
    private static int getValue(int node) {
        return node >>> 8;
    }

    // 判断是否走出迷宫
    private static boolean finished(byte i, byte j, byte m) {
        return i == 0 && j == m - 1;
    }

}
