package com.algorithm.leetcode.bitoperator;

/**
 * LeetCode 136 只出现一次的数字
 */
public class Solution2 {
    public int singleNumber(int[] nums){
        int result = nums[0];
        for (int i=1;i<nums.length;i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
