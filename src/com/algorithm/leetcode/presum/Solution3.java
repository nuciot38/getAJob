package com.algorithm.leetcode.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 944 和可被K整除的子数组
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] A = {4, 7, 0, -2, -3, 1};
        int K = 5;
        System.out.println(solution3.subarraysDivByK(A, K));
    }
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0, sum = 0;
        for (int temp : A) {
            sum += temp;
            int m = (sum % K + K) % K;
            int same = map.getOrDefault(m, 0);
            map.put(m, same + 1);
            ans += same;
        }
        return ans;
    }
}
