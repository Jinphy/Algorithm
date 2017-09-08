package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

时间限制：1秒 空间限制：32768K 热度指数：53433
        算法知识视频讲解
        题目描述
        小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
        例如：半径的平方如果为25
        优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。
        输入描述:
        输入为一个整数，即为圆半径的平方,范围在32位int范围内。
        输出描述:
        输出为一个整数，即为优雅的点的个数
        示例1
        输入

        25
        输出

        12
*/

public class Exam_48 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int squareR = Integer.parseInt(reader.readLine().trim());
        solve(squareR);

    }

    private static void solve(int squareR) {
        int total=0;
        double r = Math.sqrt(squareR);
        double x = Math.sqrt(2)*r/2;

        // 判断半径R 是否是整数,即判断与xy轴相交的四个点的坐标是否为整数
        if (r - (int) r < 0.00000000000001) {
            total+=4;
        }else {
            r++;
        }

        // 判断开始的X轴的值是否是整数，x的值是第一象限原的角度为45°时的大小
        // 此时X == Y，即判断园与直线 y = x 和直线Y = -x相交的四个点是否为整数点
        if (x - (int) x < 0.00000000000001) {
            total +=4;
        }
        x++;
        total += (quarterPoint((int) x, (int) r, squareR)<<2);

        System.out.println(total);

    }

    // 计算一个象限内（不包含与X、Y轴和与y = x、y= - x相交的点）的优雅点的个数
    private static int quarterPoint(int fromX,int radius,int squareRadius) {
        int result= 0;
        int x;
        double y;
        int squareX;
        for (x = fromX;x<radius;x++) {
            squareX = x * x;
            y = Math.sqrt(squareRadius - squareX);
            if (y - (int) y < 0.00000000000001) {//判断y是否为整数
                result+=2;
            }
        }
        return result;
    }


}
