package com.kaka.algorithm.array;

import java.util.Arrays;

/**
 * 数组合并
 */
public class ArrayMerge {
    public static void main(String[] args) {
        int a[] = {2, 5, 8, 9, 10};
        int b[] = {3, 6, 9, 9, 9, 9, 9};
        int[] newArray = merge(a, b);
        System.out.println(Arrays.toString(newArray));
    }

    /**
     * 构建新数组合并
     *
     * @param a 数组A
     * @param b 数组B
     * @return
     */
    public static int[] merge(int[] a, int[] b) {
        int lenA = a.length;
        int lenB = b.length;
        if (lenA == 0 && lenB == 0) return null;
        //新数组
        int[] newInt = new int[lenA + lenB];
        //数组A指针
        int i = 0;
        //数组B指针
        int j = 0;
        //新数组指针
        int z = 0;
        while (i < lenA && j < lenB) {
            if (a[i] <= b[j]) {
                newInt[z++] = a[i++];
            } else {
                newInt[z++] = b[j++];
            }
        }

        //判断哪个数组还有剩余
        int start = i, end = lenA - 1;
        if (i == lenA) {
            start = j;
            end = lenB - 1;
            while (start <= end) {
                newInt[z++] = b[start++];
            }
        }

        while (start <= end) {
            newInt[z++] = a[start++];
        }
        return newInt;
    }

    /**
     * 合并到任意一个数组上，然后用归并排序
     * @param a
     * @param b
     * @return
     */
    public int[] mergeSort(int[] a,int[] b){
        //todo 合并中注意数组0情况 用Integer包装类型 注意空指针问题


        return null;
    }



}
