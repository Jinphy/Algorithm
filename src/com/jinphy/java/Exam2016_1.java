package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
/*

时间限制：1秒 空间限制：32768K 热度指数：17380
        本题知识点： 排序
        算法知识视频讲解
        题目描述
        git是一种分布式代码管理工具，git通过树的形式记录文件的更改历史，比如： base'<--base<--A<--A' ^ | --- B<--B' 小米工程师常常需要寻找两个分支最近的分割点，即base.假设git 树是多叉树，请实现一个算法，计算git树上任意两点的最近分割点。 （假设git树节点数为n,用邻接矩阵的形式表示git树：字符串数组matrix包含n个字符串，每个字符串由字符'0'或'1'组成，长度为n。matrix[i][j]=='1'当且仅当git树种第i个和第j个节点有连接。节点0为git树的根节点。）
        示例1
        输入

        [01011,10100,01000,10000,10000],1,2
        输出


        1
*/
//   内存超限

public class Exam2016_1 {
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        s = s.replaceAll("[\\[\\]]{1}", "");
        String[] split = s.split("[, ]{1,}");
        char[][] matrix = new char[split.length - 2][split.length - 2];
        for (int i=0;i<split.length-2;i++) {
            matrix[i] = split[i].toCharArray();
        }
        int indexA = Integer.parseInt(split[split.length - 2]);
        int indexB = Integer.parseInt(split[split.length - 1]);
        int index = getSplitNode(matrix, indexA, indexB);
        System.out.println(index);
    }
    /**
     * 返回git树上两点的最近分割点
     *
     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 当且仅当git树中第i个和第j个节点有连接，节点0为git树的跟节点
     * @param indexA 节点A的index
     * @param indexB 节点B的index
     * @return 整型
     */
    public static int getSplitNode(char[][] matrix, int indexA, int indexB) {
        Stack<Integer> pathA = new Stack<>();
        Stack<Integer> pathB = new Stack<>();
        findPath(matrix, indexA, pathA);
        findPath(matrix, indexB, pathB);
        int index = 0;
        while (true) {
            indexA = pathA.pop();
            indexB = pathB.pop();
            if (indexA == indexB) {
                index = indexA;
            } else {
                break;
            }
        }

        return index;
    }

    private static void findPath(char[][]matrix,int index,Stack<Integer> path) {
        while (true) {
            for (int i=0;i<matrix.length;i++) {
                if (matrix[i][index] == '1') {
                    path.push(i);
                    index = i;
                    if (i == 0) {
                        break;
                    }
                }
            }
        }
    }
}
