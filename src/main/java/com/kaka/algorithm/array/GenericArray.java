package com.kaka.algorithm.array;

import java.util.Arrays;

/**
 * 动态数组
 * @param <T>
 */
public class GenericArray<T> {
    private T[] data;
    //数组总容量
    private int total;
    //实际个数
    private int actualNum;

    public GenericArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        total = capacity;
        actualNum = 0;
    }

    public GenericArray() {
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 获取当前元素个数
    public int count() {
        return actualNum;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return actualNum == 0;
    }

    // 修改 index 位置的元素
    public void update(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    // 获取对应 index 位置的元素
    public <T> T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    // 查看数组是否包含元素e
    public boolean contains(T e) {
        for (int i = 0; i < actualNum; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标, 未找到，返回 -1
    public int find(T e) {
        for (int i = 0; i < actualNum; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    public void add(int index, T e) {
        checkIndexForAdd(index);
        // 如果当前元素个数等于数组容量，则将数组扩容为原来的2倍
        if (total == actualNum) {
            resize(2 * actualNum);
        }
        data[index] = e;
        actualNum++;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 向数组尾插入元素
    public void addLast(T e) {
        add(actualNum, e);
    }

    //根据指定下标删除元素
    public void delete(int index) {
        if (index < 0 || index > total) return;
        for (int i = index; i < actualNum; i--) {
            data[i] = data[i + 1];
        }
        actualNum--;
        //如果数组容量是 1/4 进行缩容
        if (actualNum == total / 4) {
            resize(total / 2);
        }
        actualNum--;
        data[actualNum] = null;
    }


    // 删除第一个元素
    public void removeFirst() {
        delete(0);
    }

    // 删除末尾元素
    public void removeLast() {
        delete(actualNum - 1);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            delete(index);
        }
    }


    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        //数组拷贝
        for (int i = 0; i <= actualNum - 1; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
        total = 2 * total;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= total) {
            throw new IllegalArgumentException("数组下标不合法");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > total) {
            throw new IllegalArgumentException("数组下标不合法");
        }
    }

    public static void main(String[] args) {
        GenericArray genericArray = new GenericArray(5);
        genericArray.add(0,1);
        genericArray.add(1,"222");
        Object o1 = genericArray.get(0);
        System.out.println(o1);
        Object o = genericArray.get(1);
        System.out.println(o);
        System.out.println(Arrays.toString(genericArray.data));


    }


}
