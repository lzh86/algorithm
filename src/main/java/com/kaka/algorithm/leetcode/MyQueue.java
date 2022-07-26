package com.kaka.algorithm.leetcode;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueue(Stack<Integer> pushStack, Stack<Integer> popStack) {
        this.pushStack = pushStack;
        this.popStack = popStack;
    }

    public MyQueue() {
    }

    /**
     * 压入元素，压入左边栈
     *
     * @param x
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * 弹出元素
     *
     * @return
     */
    public int pop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
