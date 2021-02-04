package com.lzh.linked;

import java.util.HashMap;

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
                removeElementAndElement(element);
            } else {
                if (contain(element)) {
                    //起始位置到元素节点位置元素后移 新增元素插入到头节点
                    removeElement(element);
                } else {
                    //整体元素全部后移 新增元素插入到头节点
                    removeElementAndElement(element);
                    size++;
                }
            }

        }
    }

    void removeElementAndElement(T element) {
        for (int i = size - 1; i > 0; i++) {
            item[i] = item[i - 1];
            map.put(item[i - 1], i);
        }
        cache(element, 0);
    }


    void cache(T element, int index) {
        item[index] = element;
        map.put(element, index);
    }

    void removeElement(T element) {
        Integer index = map.get(element);
        for (int i = index; i > 0; i++) {
            item[i] = item[i - 1];
            map.put(item[i - 1], i);
        }
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
     * 判断元素是否存在
     *
     * @param element
     * @return
     */
    boolean contain(T element) {
        return map.containsKey(element);
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

    void printAll(){
        for(int i = 0;i < size;i++){
            System.out.print(item[i] + ",");
        }
    }


    public static void main(String[] args) {
        LRUArray<String> lruArray = new LRUArray<>(5);
        lruArray.add("1");
        lruArray.add("2");
        lruArray.add("3");
        lruArray.add("4");
        lruArray.printAll();
    }


}
