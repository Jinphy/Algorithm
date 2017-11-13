package com.jinphy.java;

public class Offer_55 {

    private int[] indexs = new int[256];
    //Insert one char from stringstream
    private int i = 1;

    public void Insert(char ch) {
        if (indexs[ch] == 0) {
            indexs[ch] = i++;
        } else {
            indexs[ch] = -1;
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int first = Integer.MAX_VALUE;
        int result = '#';
        for (int i = 0; i < indexs.length; i++) {
            if (indexs[i] > 0 && indexs[i] < first) {
                first = indexs[i];
                result =  i;
            }
        }
        return ((char) result);
    }
}
