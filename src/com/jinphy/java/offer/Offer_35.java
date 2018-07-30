package com.jinphy.java.offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Offer_35 {

    public static void main(String[] args) {
        String str = "12";
        System.out.println(str.substring(2));

    }


    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        visit("", new String(chars), result);
        return result;
    }

    public void visit(String current, String str, ArrayList<String> result) {
        if (str.length() == 0) {
            result.add(current);
            return;
        }
        visit(current + str.charAt(0), str.substring(1), result);
        for (int i=1;i<str.length();i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                visit(current + str.charAt(i), str.substring(0, i) + str.substring(i + 1), result);
            }
        }
    }




}
