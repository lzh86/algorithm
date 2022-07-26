package com.kaka.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            //左右归并
            merge(a, low, mid, high);
        }
        return a;
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {   //可以自己控制排序算法是否稳定
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
// TODO: 2021/11/15 简洁代码实现
//        int start = i;
//        int end = mid;
//        if (i > mid) {
//            start = j;
//            end = high;
//        }
//
//        while (start <= end) {
//            temp[k++] = a[start++];
//        }

        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 4, 1, 2, 6};
        System.out.println(Arrays.toString(a));
        sort(a, 0, 5);
        System.out.println(Arrays.toString(a));
    }


}
