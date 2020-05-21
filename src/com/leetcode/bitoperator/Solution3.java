package com.leetcode.bitoperator;

/**
 * 面试题56-II 出现一次的数字
 */
public class Solution3 {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            one = one ^ num & ~two;
            two = two ^ num & ~one;
        }
        return one;
    }
}
