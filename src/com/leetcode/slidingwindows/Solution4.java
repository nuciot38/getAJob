package com.leetcode.slidingwindows;

public class Solution4 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int[] nums2 = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums2, k));
    }

    /**
     * 只考虑奇数的个数，当奇数的个数等于k时，此时滑动窗口开始符合需求
     * 窗口右侧和左侧分别++，当遇到奇数时停下。
     * 停下时，left+1和right+1相乘即是当前窗口所能组成的优美子数组的个数，加1是考虑到以奇数为窗口的边界
     * left++，窗口左侧弹出奇数，将统计的奇数的个数减1，继续循环。
     */
    public static int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0, oddNums = 0, count = 0;
        while (right < nums.length) {
            if ((nums[right++] & 1) == 1) {
                oddNums++;
            }
            if (oddNums == k) {
                int temp = right;
                while (right < nums.length && ((nums[right] & 1) == 0)) {
                    right++;
                }
                int rightDis = right - temp;
                int leftDis = 0;
                while ((nums[left] & 1) == 0) {
                    left++;
                    leftDis++;
                }
                count += (leftDis + 1) * (rightDis + 1);
                left++;
                oddNums--;
            }
        }
        return count;
    }

    //超出时间限制
    public static int numberOfSubarrays2(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 1) {
                    temp++;
                }
                if (temp == k) {
                    count++;
                }
                if (temp > k) {
                    break;
                }
            }
        }
        return count;
    }
}
