package com.leetcode.heap;

import java.util.*;

/**
 * LeetCode 692 前K个高频词
 */
public class Solution4 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>((w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));
        for (String word : map.keySet()) {
            queue.add(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> list = new ArrayList<>();
        for (int i=0;i<k;i++){
            list.add(queue.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
