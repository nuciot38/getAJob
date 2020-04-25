package com.leetcode.sort;

import java.util.Arrays;

/**
 * LeetCode 56 合并数组
 */
public class Solution1 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2)->v1[0] - v2[0]);
        int[][] result = new int[intervals.length][2];
        int index = -1;
        for (int[] inter : intervals){
            if (index == -1 || inter[0] > result[index][1]){
                result[++index] = inter;
            }else {
                result[index][1] = Math.max(result[index][1], inter[1]);
            }
        }
        return Arrays.copyOf(result, index + 1);
    }
}
