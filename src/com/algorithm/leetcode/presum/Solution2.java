package com.algorithm.leetcode.presum;

import java.util.HashMap;

/**
 * LeetCode 1124 表现良好的最长时间段
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] hours = {8, 10, 6, 16, 5};
        Solution2 solution4 = new Solution2();
        System.out.println(solution4.longestWPI(hours));
    }

    public int longestWPI(int[] hours) {
        int[] pre_sum = new int[hours.length + 1];
        pre_sum[0] = 0;
        int res = 0;
        for (int i = 1; i <= hours.length; i++) {
            pre_sum[i] = pre_sum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (pre_sum[i] > 0) {
                res = i;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= hours.length; i++) {
            if (pre_sum[i] < 0 && !map.containsKey(pre_sum[i])) {
                map.put(pre_sum[i], i);
            }
        }

        for (int i = 0; i < hours.length; i++) {
            if (pre_sum[i] <= 0 && map.containsKey(pre_sum[i + 1] - 1)) {
                int temp = map.get(pre_sum[i + 1] - 1);
                if (temp <= i) {
                    res = Math.max(i - temp + 1, res);
                }
            }
        }
        return res;
    }
}
