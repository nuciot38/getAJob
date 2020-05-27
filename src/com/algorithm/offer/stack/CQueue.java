package com.algorithm.offer.stack;

import java.util.Stack;

/**
 * 剑指offer 09 用两个栈实现一个队列
 * 栈的特点是先进后出
 * 队列的特点是先进先出
 * 主要思路有两个
 * 思路1.在插入时，先将元素插入到第一个栈中，然后再出栈，放入第二个栈中，保证在栈顶的元素为先插入的元素，栈底的元素为后插入的元素；
 *  在删除时直接将第二个元素弹出即可。
 * 思路2.在插入时，直接将元素插入到第一个栈中；在删除时，先判断第二个栈中有无元素，如果有则直接弹出，
 *  如果没有，先将第一个栈中的元素插入到第二个栈中，再将第二个栈中的栈顶元素弹出即可。
 * 分析：因为删除操作的可执行次数<=插入操作，所以思路二中的性能将相对更好一些。
 */

public class CQueue {
    Stack<Integer> stackFirst;
    Stack<Integer> stackSecond;
    public CQueue() {
        stackFirst = new Stack<>();
        stackSecond = new Stack<>();
    }

    public void appendTail(int value) {
        stackFirst.push(value);
    }

    public int deleteHead() {
        if (!stackSecond.empty()){
            return stackSecond.pop();
        }
        if (!stackFirst.empty()){
            while(!stackFirst.empty()){
                stackSecond.push(stackFirst.pop());
            }
            return stackSecond.pop();
        }
        return -1;
    }
}
