package com.datastruct.sort;

public class Example {
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 6, 123, 48, 32, 43, 12, 11, 5, 556};
//        Selection selection = new Selection();
//        selection.sort(a);

//        Insertion insertion = new Insertion();
//        insertion.sort(a);

//        ShellSort shellSort = new ShellSort();
//        shellSort.sort(a);

        MerageSort merageSort = new MerageSort();
        merageSort.sort(a);

        Example example = new Example();
        assert example.isSorted(a);
        example.show(a);

    }
}
