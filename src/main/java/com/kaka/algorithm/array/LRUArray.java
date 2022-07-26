package com.kaka.algorithm.array;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 基于数组实现LRU算法
 */
public class LRUArray<T> {
    private static final Integer DEFAULT_CAPACITY = 10;
    /**
     * 数组实际容量
     */
    private int size;
    /**
     * 数组
     */
    private T[] item;
    /**
     * 标记元素所在位置
     */
    private HashMap<T, Integer> map;
    /**
     * 初始化容量
     */
    private int capacity;

    public LRUArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUArray(int capacity) {
        this.item = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }

    /**
     * 添加元素
     *
     * @param element
     */
    void add(T element) {
        int index = findIndexElement(element);
        if (index == -1) {
            if (ifFull()) {
                removeTailElement();
                cache(element, 0);
            } else {
                moveAfterElementByIndex(size);
                cache(element, 0);
            }
        } else {
            moveAfterElement(element);
        }
    }

    /**
     * 移除末尾元素
     */
    void removeTailElement() {
        if (size == 0) return;
        for (int i = size - 1; i > 0; i--) {
            item[i] = item[i - 1];
            map.put(item[i], i);
        }
        size--;
    }

    /**
     * 根据下标移动元素
     *
     * @param index
     */
    void moveAfterElementByIndex(int index) {
        if (index == 0) return;
        for (int i = index; i > 0; i--) {
            item[i] = item[i - 1];
            map.put(item[i - 1], i);
        }
    }

    /**
     * 根据元素移动
     *
     * @param element
     */
    void moveAfterElement(T element) {
        Integer index = map.get(element);
        if (index == 0) return;
        for (int i = index; i > 0; i--) {
            item[i] = item[i - 1];
            map.put(item[i - 1], i);
        }
        size--;
        cache(element, 0);
    }

    /**
     * 缓存元素
     *
     * @param element
     * @param index
     */
    void cache(T element, int index) {
        item[index] = element;
        map.put(element, index);
        size++;
    }

    /**
     * 判断元素是否满
     */
    boolean ifFull() {
        if (size >= capacity)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }

    /**
     * 查找元素所在下标
     *
     * @param element
     * @return
     */
    int findIndexElement(T element) {
        Integer index = map.get(element);
        if (null == index) {
            return -1;
        }
        return index;
    }

    /**
     * 打印元素
     */
    void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(item[i] + ",");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LRUArray<String> lruArray = new LRUArray<>(5);
        Scanner sc = new Scanner(System.in);
        while (true) {
            lruArray.add(sc.next());
            // System.out.println(Arrays.toString(list.toArray()));
            lruArray.printAll();

        }

    }


}
