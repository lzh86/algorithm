package com.kaka.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void selection(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            //最小数的索引
            int minIndex = i;
            for (int j = i; j < n; j++) {
                //找到最小数，并记录最小数的索引
                if (a[j] < a[minIndex]) { //选择排序的升序降序决定在是找最大还是最小索引
                    minIndex = j;
                }
            }
            //交换符合条件的数
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 4, 1, 2, 6};
        System.out.println(Arrays.toString(a));
        selection(a, 6);
        System.out.println(Arrays.toString(a));
    }

}
