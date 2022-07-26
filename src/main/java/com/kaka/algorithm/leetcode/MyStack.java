package com.kaka.algorithm.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 用队列实现栈
 */
public class MyStack {
    private Queue<Integer> addQueue = new PriorityQueue();
    private Queue<Integer> pollQueue = new PriorityQueue();

    public MyStack() {

    }

    public void push(int x) {
        addQueue.add(x);
    }

    public int pop() {
        if(pollQueue.isEmpty()){
            while (!addQueue.isEmpty()){
                pollQueue.add(addQueue.poll());
            }
        }
        return pollQueue.poll();
    }

    public int top() {
        if(pollQueue.isEmpty()){
            while (!addQueue.isEmpty()){
                pollQueue.add(addQueue.poll());
            }
        }
        return pollQueue.poll();
    }

    public boolean empty() {
        return addQueue.isEmpty() && pollQueue.isEmpty();
    }
}
