package com.datastruct.sort;

public class Insertion {
    public static void main(String[] args) {
        int[] a = {3, 5, 6, 7, 4, 8, 2, 1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void sort(int[] a) {
        int N = a.length;
        SelectTools selectTools = new SelectTools();
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    selectTools.swap(a, j, j - 1);
                }
            }
        }
    }

}
