package com.WeekOne;

import java.util.*;

/**
 * 2020/5/10 LeetCode周赛
 * 5406 收集树上所有苹果的最少时间
 */
public class Solution3 {
    private Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    private Set<Integer> set = new HashSet<>();

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            map.put(b, a);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (hasApple.get(i)) {
                list.add(i);
            }
        }
        set.add(0);
        for (Integer c : list) {
            find(c);
        }
        return 2 * res;
    }

    private void find(int cur) {
        if (set.contains(cur)){
            return;
        }
        res++;
        set.add(cur);
        find(map.get(cur));
    }
}
