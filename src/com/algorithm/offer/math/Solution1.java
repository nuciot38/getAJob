package com.algorithm.offer.math;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(Power(2, -3));
    }

    public static double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent == 1) {
            return base;
        }
        double sum = 1.0;
        int times = exponent;
        boolean flag = true;
        if (exponent < 0) {
            times = (-1) * times;
            flag = false;
        }
        for (int i = 0; i < times; i++) {
            if (flag) {
                sum = sum * base;
            } else {
                sum = sum / base;
            }

        }
        return sum;
    }
}
