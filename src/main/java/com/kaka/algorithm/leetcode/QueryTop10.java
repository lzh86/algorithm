package com.kaka.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class QueryTop10 {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{7,8,9};



    }

    /**
     *
     * @param list
     * @return
     */
    public static int[] queryTop10(List<int[]> list){
        int[] num = new int[1000];
        int i = 0;
        for (int[] nums : list){
            //默认有序数组升序排列,取最后一个元素
            num[i++] = nums[nums.length-1];
        }
        //对 1000 个元素排序
        int[] sort = sort(num, 0, 999);

        int[] result = new int[10];
        for(int j = 0,z=0 ;j < 10;j++ ){
            result[j++] = sort[z++];
        }
        return  result;
    }


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



}
