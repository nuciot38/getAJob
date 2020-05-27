package com.algorithm.leetcode.dp;

/**
 * LeetCode 152 乘积最大子数组
 */
public class Solution3 {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        Solution3 solution = new Solution3();
        System.out.println(solution.maxProduct(nums));
    }
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int ans = nums[0];
        for(int i = 1;i<len;i++){
            dpMax[i] = Math.max(dpMax[i-1] * nums[i], Math.max(nums[i], dpMin[i-1] * nums[i]));
            dpMin[i] = Math.min(dpMin[i-1] * nums[i], Math.min(nums[i], dpMax[i-1] * nums[i]));
            ans = Math.max(ans, dpMax[i]);
        }
        return ans;
    }
}
