package com.jinphy.java;

public class Sort {

    public static<T> T[] qSort(T[] array,Comparator<T> comparator) {
        qSort(0, array.length-1,comparator, array);
        return array;
    }

    private static<T> void qSort( int left, int right,Comparator<T> comparator,T... array) {
        if (left < right) {
            T key = array[left];
            int low = left;
            int high = right;
            while (low < high) {
                while (low < high) {
                    if (comparator.compare(key,array[high])) {
                        high--;
                    } else {
                        array[low++] = array[high];
                        break;
                    }
                }
                while (low < high) {
                    if (comparator.compare(array[low], key)) {
                        low++;
                    } else {
                        array[high--] = array[low];
                        break;
                    }
                }
            }
            array[low]= key;
            qSort(left, low - 1,comparator, array);
            qSort(low + 1, right, comparator,array);
        }
    }


    ////////////////////////////////////////////////////////////
    //=============interface==================================
    interface Comparator<T>{
        boolean compare(T a, T b);
    }
}
