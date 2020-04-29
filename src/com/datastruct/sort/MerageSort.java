package com.datastruct.sort;

public class MerageSort {

    public void mergeSort(int[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k < hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k < hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    private int[] aux;

    public void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    public void sort(int[] a, int lo, int hi) {
        if (hi <= lo){
            return;
        }
        int mid = lo +(hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi );
        mergeSort(a, lo, mid, hi);
    }

}
