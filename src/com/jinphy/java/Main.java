package com.jinphy.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {

    private static DecimalFormat format = new DecimalFormat("#.00000000");

    public static void main(String... args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        double[] angles = new double[n];
        int i = 0;
        while (n-- > 0) {
            angles[i++] = Double.parseDouble(reader.readLine().trim());
        }
        maxDistance(angles);
    }

    private static void maxDistance(double[] angles) {
        double max = -1;
        int head = 1;
        double distance;
        for (int i=0;i<angles.length;i++) {
            do {
                distance = angles[head] - angles[i];
                if (distance > 180) {
                    angles[i] += 360;
                    break;
                } else if (distance > max) {
                    max = distance;
                    head = (head+1)% angles.length;
                } else {
                    head = (head + 1) % angles.length;
                }
            } while (head != i);
        }

        max+=0.5;
        System.out.println(format.format(max));

    }
}

