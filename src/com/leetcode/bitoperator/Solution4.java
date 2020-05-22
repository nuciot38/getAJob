package com.leetcode.bitoperator;

/**
 * LeetCode 29 两数相除
 */
public class Solution4 {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        long a = dividend;
        long b = divisor;

        long ans;
        if (a > 0 && b > 0) {
            ans = div(a, b);
        } else if (a < 0 && b < 0) {
            ans = div(-a, -b);
        }else{
            ans = -div(Math.abs(a), Math.abs(b));
        }
        return (int) ans;
    }

    public long div(long a, long b) {
        if (a < b) {
            return 0;
        }
        int i = 0;
        while (a >= (b << i)) {
            i++;
        }
        i--;
        return (1 << i) + div(a - (b << i), b);
    }
}
