package com.leetcode.pointer;

/**
 * LeetCode 287 寻找重复数
 */
public class Solution2 {
    //快慢指针
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }

    public int findDuplicate2(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
//            int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            if (cnt > mid) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
