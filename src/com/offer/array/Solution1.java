package com.offer.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指offer 奇数在前，偶数在后，不改变奇数间和偶数间的位置关系
 */

public class Solution1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray2(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void reOrderArray(int[] array) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                queue2.add(array[i]);
            } else {
                queue1.add(array[i]);
            }
        }
        int index = 0;
        while (index < queue1.size()) {
            array[index] = queue1.poll();
            index++;
        }
        while (index < queue1.size() + queue2.size()) {
            array[index] = queue2.poll();
            index++;
        }
    }

    public static void reOrderArray2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 != 0) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
