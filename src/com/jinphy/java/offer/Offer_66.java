package com.jinphy.java.offer;
/*

时间限制：1秒 空间限制：32768K 热度指数：44932
        算法知识视频讲解
        题目描述
        请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
        路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下
        移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
        例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵
        中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
        路径不能再次进入该格子。
*/

public class Offer_66 {


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (str.length == 0) {
            return true;
        }
        Help.rows = rows;
        Help.cols = cols;
        Help.length = str.length;
        Help.matrix = matrix;
        Help.str = str;
        Help.visited = new boolean[rows][cols];

        for (int index = 0; index < matrix.length; index++) {
            if (matrix[index] == str[0]) {
                int i = index / cols;
                int j = index % cols;
                if (visit(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean visit(int i, int j, int k) {
        // 判断矩阵中当前位置（i，j）的字符是否与str[k]相等
        if (Help.matrix[i * Help.cols + j] != Help.str[k]) {
            // 不相等，说明路径到该位置时匹配不到
            return false;
        }
        if (k == Help.length - 1) {
            // 说明已经找到相应的路径了
            return true;
        }
        // 标记为访问过
        Help.visited[i][j] = true;
        // 向上找
        if (i - 1 >= 0 && !Help.visited[i - 1][j] && visit(i - 1, j, k + 1)) {
            return true;
        }
        // 向下找
        if (i + 1 < Help.rows && !Help.visited[i + 1][j] && visit(i + 1, j, k + 1)) {
            return true;
        }
        // 向左找
        if (j - 1 >= 0 && !Help.visited[i][j - 1] && visit(i, j - 1, k + 1)) {
            return true;
        }
        // 向右找
        if (j + 1 < Help.cols && !Help.visited[i][j + 1] && visit(i, j + 1, k + 1)) {
            return true;
        }
        // 找不到，擦除标记
        Help.visited[i][j] = false;

        return false;
    }

    static class Help {
        static int rows;
        static int cols;
        static int length;
        static char[] matrix;
        static char[] str;
        static boolean[][] visited;
    }
}
