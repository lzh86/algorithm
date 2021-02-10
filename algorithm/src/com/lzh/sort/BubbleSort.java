package com.lzh.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    // 冒泡排序，a表示数组，n表示数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; ++j) {
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    public static void main(String[] args) {
        int[] a = {3,5,4,1,2,6};
        System.out.println(Arrays.toString(a));
        bubbleSort(a,6);
        System.out.println(Arrays.toString(a));
    }

}
