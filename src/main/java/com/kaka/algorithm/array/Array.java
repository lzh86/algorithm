package com.kaka.algorithm.array;

/**
 * 静态数组
 */
public class Array {
    //数组
    private int[] data;
    //数组总容量
    private int total;
    //实际个数
    private int actualNum;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.total = capacity;
        this.actualNum = 0;
    }

    public Array() {
    }

    //尾部添加元素
    public void addTail(int element) {
        if (actualNum >= total) return;
        data[actualNum] = element;
        actualNum++;
    }

    //头部添加元素
    public void addHead(int element) {
        if (actualNum >= total) return;
        //元素后移一位
        for (int i = total - 1; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = element;
        actualNum++;
    }

    //动态增加
    public void dynamicAdd(int element) {
        if (actualNum >= total) {
            int[] newData = new int[2 * total];
            for (int i = 0; i <= actualNum - 1; i++) {
                newData[i] = data[i];
            }
            total = 2 * total;
            newData[actualNum] = element;
            data = newData;
            actualNum++;
        }

        boolean b = actualNum == data.length / 4 && data.length / 2 != 0;
    }


    //查找元素
    public Integer find(int index) {
        if (index < 0 || index > total) return null;
        return data[index];
    }

    //更新元素
    public void update(int index, int newData) {
        if (index < 0 || index > total) return;
        data[index] = newData;
    }

    //根据指定下标删除元素
    public void delete(int index) {
        if (index < 0 || index > total) return;
        for (int i = index; i < actualNum -1;i++) {
            data[i] = data[i + 1];
        }
        actualNum--;
        data[actualNum] = 0;
    }


    public void printAll() {
        for (int i = 0; i < actualNum; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Array array = new Array(5);
        array.addTail(3);
        array.addTail(4);
        array.addTail(5);
        array.addTail(9);
        array.printAll();
        array.addHead(1);
        array.printAll();
        array.dynamicAdd(2);
        array.printAll();
        array.delete(0);
        array.printAll();
        array.delete(1);
        array.printAll();
        array.delete(2);
        array.printAll();
        array.delete(3);
        array.printAll();

    }
}
