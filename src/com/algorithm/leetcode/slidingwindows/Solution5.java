package com.algorithm.leetcode.slidingwindows;

/**
 * LeetCode 1052 爱生气的书店老板
 */
public class Solution5 {
    public static void main(String[] args) {
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;
        System.out.println(maxSatisfied2(customers, grumpy, X));
    }

    /**
     *
     */
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int loss = 0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
                customers[i] = 0;
            }
        }
        int index = 0;
        while (index < customers.length) {
            loss += customers[index];
            if (index >= X - 1) {
                if (loss > max) {
                    max = loss;
                }
                loss -= customers[index - X + 1];
            }
            index++;
        }
        return sum + max;
    }

    public static int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        int left = 0;
        int right = 0;
        int loss = 0;
        int maxloss = 0;
        int sum = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            } else {
                loss += customers[i];
                maxloss = Math.max(maxloss, loss);
            }
            if (right >= X) {
                loss = grumpy[left] == 0 ? loss : loss - customers[left];
                left++;
            }
            right++;

        }
        return sum + maxloss;
    }
}
