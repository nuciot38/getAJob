package com.leetcode.bitoperator;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题56-1 数组中数字出现的次数
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

    }
    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.remove(nums[i]);
            }else {
                map.put(nums[i], 1);
            }
        }
        int[] result = new int[2];
        int index = 0;
        for (int a : map.keySet()){
            result[index] = a;
            index++;
        }
        return result;
    }
}
