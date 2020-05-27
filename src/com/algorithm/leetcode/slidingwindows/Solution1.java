package com.algorithm.leetcode.slidingwindows;


/**
 * 最大连续1的个数 III
 * <p>
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int K = 2;
        System.out.println(longestOnes(A, K));
    }

    /**
     * 滑动窗口解题思路
     * 1.定义left和right
     * 2.当遇到1时：right++
     * 3.当遇到0时：3.1当K>0时，right++，K--
     * 3.2当K=0时，left++至遇到0，再次left++。此时窗口left退出1个0，right加入1个0，即窗口内拥有K个0，为当前最大
     * 4.每层循环后，将最大值与当前right和left的距离进行比较，返回max
     */

    public static int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length <= K) {
            return A.length;
        }
        int max = 0;
        for (int left = 0, right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                if (K == 0) {
                    while (A[left] == 1) {
                        left++;
                    }
                    left++;
                } else {
                    K--;
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int left = 0;
        int right = k;
        int[] result = new int[nums.length - k + 1];
        for (left = 0, right=k; right < nums.length; left++, right++) {
            int max = nums[left];
            for (int i = left; i < right; i++) {
                max = Math.max(max, nums[i]);
            }
            result[left] = max;
        }
        return result;
    }
}
