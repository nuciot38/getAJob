package com.algorithm.leetcode.pointer;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 202 快乐数
 */
public class Solution1 {

    //快慢指针
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && fast != slow){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }
        return sum;
    }

    //使用集合判断是否有了循环
    public boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int sum = 0;
        while (n != 1) {
            while (n != 0) {
                int temp = n % 10;
                sum += temp * temp;
                n = n / 10;
            }
            n = sum;
            if (n == 1) {
                return true;
            }
            sum = 0;
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }
}
