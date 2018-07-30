package com.jinphy.java.exam;

import java.util.Scanner;

public class Exam_9 {

    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        String number;
        int cnt;
        while (true) {
            number = reader.next();
            cnt = reader.nextInt();
            remainLargest(number,cnt);
        }

    }

    private static void remainLargest(String number,int cnt){
        StringBuilder str = new StringBuilder(number);
        int n;
        for (int i = 0; i < cnt; i++) {
            n = str.length()-1;
            for (int j=0;j<n;j++) {
                if (str.charAt(j) < str.charAt(j + 1)) {
                    str.deleteCharAt(j);
                    break;
                }
            }
        }
        System.out.println(str);
    }

}
