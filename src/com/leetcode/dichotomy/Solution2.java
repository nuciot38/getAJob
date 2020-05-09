package com.leetcode.dichotomy;

/**
 * LeetCode 35 搜索插入位置
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        Solution2 solution2 = new Solution2();
        int res = solution2.searchInsert(nums, 0);
        System.out.println(res);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        if (target > nums[right]){
            return right + 1;
        }
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
