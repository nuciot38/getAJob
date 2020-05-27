package com.algorithm.leetcode.dichotomy;

import java.util.ArrayList;
import java.util.List;

public class Solution7 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        int[] an = {2,3,1,3,1,1};
        int[] an = {2, 1, 1, 2};
        for(int i=0;i<an.length;i++){
            if (list.contains(an[i])){
                list.remove(new Integer(an[i]));
            }else{
                list.add(an[i]);
            }
        }
        System.out.println(list);

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalength = length1 + length2;
        if (totalength % 2 == 1) {
            int midIndex = totalength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalength / 2 - 1, midIndex2 = totalength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }

    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;
        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

}
