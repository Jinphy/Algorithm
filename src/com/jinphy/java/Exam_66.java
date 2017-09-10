package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：15355
        算法知识视频讲解
        题目描述
        牛牛想尝试一些新的料理，每个料理需要一些不同的材料，问完成所有的料理需要准备多少种不同的材料。
        输入描述:
        每个输入包含 1 个测试用例。每个测试用例的第 i 行，表示完成第 i 件料理需要哪些材料，各个材料用空格隔开，输入只包含大写英文字母和空格，输入文件不超过 50 行，每一行不超过 50 个字符。
        输出描述:
        输出一行一个数字表示完成所有料理需要多少种不同的材料。
        示例1
        输入

        BUTTER FLOUR HONEY FLOUR EGG
        输出

        4
*/

public class Exam_66 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] materials = new String[51];
        int n = 0;
        do {
            materials[n] = reader.readLine();
            if (materials[n] == null || materials[n].length() == 0) {
                break;
            }
        } while (++n < 51);

        material(materials, n);
    }

    public static void material(String[] materials,int n) {
        int result=0;
        TrieTree root = new TrieTree();
        for (int i = 0; i < n; i++) {
            String str = materials[i];
            while (str.length() > 50) {
                result+=TrieTree.visit(root, str.substring(0, 50).trim());
                str = str.substring(50);
            }
            result += TrieTree.visit(root, str.trim());
        }
        System.out.println(result);

    }

    private static class TrieTree{
        public TrieTree[] next;
        public boolean flag = false;

        public TrieTree() {
            next = new TrieTree[26];
        }

        public static int visit(TrieTree root, String str) {
            str += " ";
            int result = 0;
            char[] chars = str.toCharArray();
            TrieTree current = root;

            for (char c:chars) {
                if (c<'A'||c>'Z') {
                    if (!current.flag) {
                        result++;
                        current.flag = true;
                    }
                    current = root;
                } else {
                    if (current.next[c - 'A'] == null) {
                        current.next[c - 'A'] = new TrieTree();
                    }
                    current = current.next[c - 'A'];
                }
            }
            return result;
        }
    }
}
