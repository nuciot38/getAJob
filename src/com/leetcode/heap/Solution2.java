package com.leetcode.heap;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution2 {
    //动态规划
    public static UglyNums u = new UglyNums();

    //堆
    public static Ugly ugly = new Ugly();

    public static int nthUglyNumber(int n) {
        return u.nums[n - 1];
    }

    public static int nthUglyNumber2(int n) {
        return ugly.nums[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber2(10));
    }
}

//动态规划
class UglyNums {
    public int[] nums = new int[1690];

    UglyNums() {
        nums[0] = 1;
        int ugly;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < 1690; i++) {
            ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = ugly;
            if (ugly == nums[i2] * 2) {
                ++i2;
            }
            if (ugly == nums[i3] * 3) {
                ++i3;
            }
            if (ugly == nums[i5] * 5) {
                ++i5;
            }
        }
    }
}

class Ugly {
    public int[] nums = new int[1690];

    Ugly() {
        HashSet<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.add(1L);
        long currUgly, newUgly;
        int[] primes = new int[]{2, 3, 5};
        for (int i = 0; i < 1690; ++i) {
            currUgly = heap.poll();
            nums[i] = (int) currUgly;
            for (int j : primes) {
                newUgly = currUgly * j;
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
    }
}


