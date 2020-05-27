package com.algorithm.leetcode.greed;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums2 = new int[]{3, 2, 1, 0, 4};
        int[] nums3 = new int[]{2, 0};
        System.out.println(canJump(nums3));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i<=rightmost){
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n-1){
                    return true;
                }
            }
        }
        return false;
    }

    //取0的位置，遍历是否能全部跳过
    public static boolean canJump2(int[] nums) {
        boolean result = false;
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1 && nums[0] == 0) {
            return !result;
        }
        if (nums.length > 1 && nums[0] == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                list.add(i);
            }
        }
        result = true;
        for (int i = list.size() - 1; i >= 0; i--) {
            int index = list.get(i) - 1;
            while (index > 0) {
                if (nums[index] > list.get(i) - index) {
                    break;
                }
                index--;
                if (index == 0) {
                    return false;
                }
            }
        }
        return result;
    }
}
