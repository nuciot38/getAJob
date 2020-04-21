package com.datastruct.sort;

public class MerageSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 6, 7, 4, 8, 2, 1};
        mergeSort(a, 0, a.length / 2, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void mergeSort(int[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        int[] temp = new int[a.length];
        for (int k = lo; k < hi; k++) {
            temp[k] = a[k];
        }
        for (int k = lo; k < hi; k++) {
            if (i > mid) {
                a[k] = temp[j++];
            } else if (j > hi) {
                a[k] = temp[i++];
            } else if (temp[i] < a[j]) {
                a[k] = temp[i++];
            } else {
                a[k] = temp[j++];
            }
        }
    }
}
