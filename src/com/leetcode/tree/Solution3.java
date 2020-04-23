package com.leetcode.tree;

/**
 * LeetCode 96 不同的二叉树
 */
public class Solution3 {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    //动态规划
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }

    //数学演绎
    //卡塔兰数
    public static int numTrees2(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

}
