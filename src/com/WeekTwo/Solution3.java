package com.WeekTwo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode 2020/5/17 周赛
 * 1452 收藏清单
 */
public class Solution3 {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        String str1 = "leetcode";
        String str2 = "google";
        String str3 = "facebook";
        String str4 = "microsoft";
        String str5 = "amazon";
        List<String> a1 = new ArrayList<>();
        a1.add(str1);
        a1.add(str2);
        a1.add(str3);
        List<String> a2 = new ArrayList<>();
        a2.add(str2);
        a2.add(str4);
        List<String> a3 = new ArrayList<>();
        a3.add(str2);
        a3.add(str3);
        List<String> a4 = new ArrayList<>();
        a4.add(str2);
        List<String> a5 = new ArrayList<>();
        a5.add(str5);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.peopleIndexes(list));

    }
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        if (favoriteCompanies == null || favoriteCompanies.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> list = favoriteCompanies.get(i);
            boolean flag = true;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i == j){
                    continue;
                }
                List<String> home = favoriteCompanies.get(j);
                Set<String> set = new HashSet<>(home);
                //set和list的containsAll实现方法不同，set的复杂度是O(n), list的复杂度是O(m*n)
                if (set.containsAll(list)){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }

}
