package com.lzh.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    // 冒泡排序，a表示数组，n表示数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            System.out.println("#");
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
