package com.algorithm.offer.stack;

import java.util.Stack;

public class Solution1 {

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 5, 3, 2, 1};
        int[] poped2 = {4, 3, 5, 1, 2};
        int[] test1 = {1, 0, 2};
        int[] test2 = {2, 1, 0};
        System.out.println(validateStackSequences(pushed, poped));
//        System.out.println(validateStackSequences(new int[0], new int[0]));
//        System.out.println(validateStackSequences(test1, test2));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length || pushed.length == 0 || popped.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < popped.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && index < popped.length && popped[index] == stack.peek()){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
