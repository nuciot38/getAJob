package com;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 60 第K个排列
 */
public class Solution {
    public static void main(String[] args) {
//        for (int i = 1; i <= 24; i++) {
//            System.out.println(getPermutation(4, i));
//        }
        System.out.println(getPermutation(4, 13));
//        System.out.println(getPermutation(3, 1));
    }

    public static String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            nums[i] = nums[i - 1] * i;
        }
        StringBuilder sb = new StringBuilder();
        int len = n;
        k = k - 1;
        while (sb.length() < n) {
            len--;
            int step = nums[len];
            int index = k / step;
            int num = list.get(index);
            list.remove(new Integer(num));
            sb.append(num);
            k = k - index * step;
        }
        return sb.toString();
    }


    public static String getPermutation2(int n, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        k = k - 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            stack.push(k % i);
            k = k / i;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int index = stack.pop();
            sb.append(list.get(index));
            list.remove(index);
        }
        return sb.toString();
    }


//    public String helper(StringBuilder sb, int n, int k, List<Integer> list, int[] all){
//        all = new int[n];
//        int sum = 1;
//        for (int i=1; i<=n;i++){
//            sum *= i;
//            all[i] = sum;
//        }
//
//        return null;
//    }

}
