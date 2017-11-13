package com.jinphy.java;

public class Offer_53 {


    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        if (str.length == 0 && pattern.length == 0) {
            return true;
        }

        return match(str, 0, pattern, 0);
    }

    private boolean match(char[] str, int strIndex, char[] pattern ,int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            // 字符串和模式都匹配到尾部，说明匹配成功
            return true;
        }
        if (strIndex < str.length && patternIndex == pattern.length) {
            // 字符串还没到尾部，但是模式已经到达尾部，说明匹配失败
            return false;
        }
        if (strIndex < str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
            // 当前字符与模式当前字符匹配
            if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
                // 当前模式是x*可以不与当前字符匹配，可以只匹配一次，也可以匹配多次,
                // ********************动态规划*****************************
                return match(str, strIndex, pattern, patternIndex + 2) ||//不匹配
                        match(str, strIndex + 1, pattern, patternIndex + 2) ||// 匹配1次
                        match(str, strIndex + 1, pattern, patternIndex);// 匹配多次
            } else {
                // 模式当前字符的下一个不是 *
                return match(str, strIndex + 1, pattern, patternIndex + 1);
            }
        } else {
            // 当前字符与模式当前字符不匹配
            if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
                // 模式当前字符的下一个字符是 *
                return match(str, strIndex, pattern, patternIndex + 2);
            } else {
                // 模式当前字符的下一个不是 *
                return false;
            }
        }
    }
}
