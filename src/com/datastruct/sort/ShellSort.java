package com.datastruct.sort;

public class ShellSort {
    public void sort(int[] a) {
        int len = a.length;
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (a[j] < a[j-h]) {
                        int temp = a[j-h];
                        a[j-h] = a[j];
                        a[j] = temp;
                    }
                }
            }
            h = h / 3;
        }


    }
}
