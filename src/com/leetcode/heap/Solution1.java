package com.leetcode.heap;

import java.util.PriorityQueue;

/**
 * LeetCode 215 数组中的第K大的元素
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */

public class Solution1 {

    /**
     * 堆排序
     * 建立最小堆，如果比堆顶元素小，直接跳过，否则和堆顶元素交换，然后调整堆
     */
    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums, k);
        for (int i=k;i<nums.length; i++){
            if (nums[i] < nums[0]){
                continue;
            }
            swap(nums, i, 0);
            heapify(nums, k, 0);
        }
        return nums[0];
    }

    public void buildHeap(int[] a, int k) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            heapify(a, k, i);
        }
    }

    public void heapify(int[] a, int k, int i) {
        int minPos = i;
        while (true) {
            if (i * 2 + 1 < k && a[i * 2 + 1] < a[i]) {
                minPos = i * 2 + 1;
            }
            if (i * 2 + 2 < k && a[i * 2 + 2] < a[minPos]){
                minPos = i * 2 + 2;
            }
            if (minPos == i){
                break;
            }
            swap(a, i, minPos);
            i = minPos;
        }
    }


    /**
     * 优先队列
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    /**
     * 快速排序
     */
    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        int target = len - k;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, left);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
