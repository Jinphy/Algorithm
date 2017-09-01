package com.jinphy.java;

import java.io.File;
import java.util.Scanner;

public class Exam_13 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        printFileNameExtension(reader.nextLine());
    }

    private static void printFileNameExtension(String path) {
        int lastSeparator = path.lastIndexOf(File.separator);
        int lastDot = path.lastIndexOf(".");
        if (lastSeparator < lastDot) {
            System.out.println(path.substring(lastDot + 1));
        } else {
            System.out.println("null");
        }
    }
}
