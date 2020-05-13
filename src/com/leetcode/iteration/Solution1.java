package com.leetcode.iteration;

/**
 * LeetCode 50 Pow(x,n)
 */
public class Solution1 {
    //快速幂和迭代
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        double ans = 1.0;
        double x_contribute = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x_contribute;
            }
            x_contribute *= x_contribute;
            N /= 2;
        }
        return ans;
    }

    //快速幂和递归
    public double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul2(x, N) : 1.0 / quickMul2(x, -N);
    }

    public double quickMul2(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul2(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
