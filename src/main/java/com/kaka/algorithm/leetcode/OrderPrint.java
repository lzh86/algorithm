package com.kaka.algorithm.leetcode;

/**
 * 顺序打印
 */
public class OrderPrint {
    private volatile int value = 1;

    void printA() {
        synchronized (this) {
            while (value != 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": A");
            value = 2;
            notifyAll();
        }

    }

    void printB() {
        synchronized (this) {
            while (value != 2) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": B");
            value = 3;
            notifyAll();
        }
    }

    void printC() {
        synchronized (this) {
            while (value != 3) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": C");
            value = 1;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        OrderPrint orderPrint = new OrderPrint();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10 ; i++) {
                    orderPrint.printA();
                }
            }
        }, "甲线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    orderPrint.printB();
                }
            }
        }, "乙线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    orderPrint.printC();
                }
            }
        }, "丙线程").start();
    }
}




