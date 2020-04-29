package com.datastruct.sort;

public class Insertion {
    public void sort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (a[j]<a[i]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

}
