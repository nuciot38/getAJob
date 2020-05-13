package com.WeekOne;

/**
 * 2020/5/10 LeetCode周赛
 * 5405形成两个异或相等数组的三元组数目
 * a == b 可得 a^b == 0,反之亦成立
 */
public class Solution2 {
    public int countTriplets(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                temp = temp ^ arr[j];
                if (temp == 0) {
                    ans += j - i;
                }
            }
        }
        return ans;
    }
}
