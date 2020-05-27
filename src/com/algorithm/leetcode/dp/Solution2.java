package com.algorithm.leetcode.dp;

/**
 * LeetCode 5 最长回文子串
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 1;
        for(int r=1;r<len;r++){
            for(int l=0;l<r;l++){
                if(s.charAt(l) == s.charAt(r) && ( r-l <= 2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(r + 1 - l > maxLen){
                        maxLen = r + 1 - l;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
