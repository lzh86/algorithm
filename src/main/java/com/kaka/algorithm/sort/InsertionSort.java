package com.kaka.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {

    // 插入排序，a表示数组，n表示数组大小 升序实现
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }

    /**
     *  降序实现
     * @param nums
     * @return
     */
    public static int[] sort(int[] nums) {
        int length = nums.length;
        for (int j = 1; j < length; j++) {
            int temp = nums[j];
            int i = j - 1;
            for (; i >= 0; --i) {
                if (nums[i] < temp) {  // 降序和升序的区别只在这一个地方
                    nums[i + 1] = nums[i];
                } else {
                    break;
                }
            }
            nums[i + 1] = temp;
        }
        return nums;
    }





    public static void main(String[] args) {
        int[] a = {3,5,4,1,2,6};
        System.out.println(Arrays.toString(a));
        insertionSort(a,6);
        System.out.println(Arrays.toString(a));
    }
}
