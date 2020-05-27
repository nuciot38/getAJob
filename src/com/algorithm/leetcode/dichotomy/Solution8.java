package com.algorithm.leetcode.dichotomy;

/**
 * LeetCode 1011 在D天内送达包裹的能力
 */
public class Solution8 {

    public int shipWithinDays(int[] weights, int D) {
        int lo = 0, hi = Integer.MAX_VALUE;
        while (lo<hi){
            int mid = lo + (hi-lo)/2;
            if (canShip(weights, D, mid)){
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    public boolean canShip(int[] weights, int D, int K){
        int cur = K;
        for (int weight : weights){
            if (weight > K){
                return false;
            }
            if (cur < weight){
                cur = K;
                D--;
            }
            cur -= weight;
        }
        return D>0;
    }


    public static int shipWithinDays2(int[] weights, int D) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            max = Math.max(max, weights[i]);
            sum += weights[i];
        }
        int min = Integer.MAX_VALUE;
        while (max < sum) {
            int mid = max + (sum - max) / 2;
            int day = D;
            int index = 0;
            int i;
            for (i = 0; i < weights.length; i++) {
                int current = 0;
                while (index < weights.length) {
                    if (current + weights[index] <= mid) {
                        current += weights[index];
                        index++;
                    } else {
                        break;
                    }
                }
            }
            if (index == weights.length && i == day) {
                min = Math.min(min, mid);
                sum = mid;
            } else if (index < weights.length && i == day) {
                max = mid + 1;
            } else {
                sum = mid;
            }
        }
        return min;
    }
}
