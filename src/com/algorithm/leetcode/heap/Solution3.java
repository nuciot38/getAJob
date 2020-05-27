package com.algorithm.leetcode.heap;

import java.util.*;

/**
 * LeetCode 347 前K个高频元素
 */
public class Solution3 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (int n : map.keySet()) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] topK = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            topK[i] = (queue.poll());
        }
        return topK;
    }
}
