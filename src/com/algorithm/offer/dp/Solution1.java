package com.algorithm.offer.dp;

/**
 * 面试 08.11 硬币
 */
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(waysToChange(6));
    }

    public static int waysToChange(int n) {
        int mod = 1000000007;
        int[] coins = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
                dp[j] = dp[j] % mod;
            }
        }
        return dp[n];
    }
}
