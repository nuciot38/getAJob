package com.datastruct.sort;

public class Selection {
    public void sort(int[] a) {
        int len = a.length;
        Example example = new Example();
        for (int i=0;i<len-1;i++){
            int min = i;
            for (int j=i+1;j<len;j++){
                if (a[j] < a[min]){
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

}
