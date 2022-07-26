package com.kaka.algorithm.leetcode;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        //[0,1,0,3,12]
        int[] a = {0,1,0,3,12};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * https://leetcode-cn.com/problems/move-zeroes/
     * 1.如果能新建数组,遍历旧数组遇到不是 0 的数值放入新数组中
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {

        int left = 0, right = 0, n = nums.length;
        while (left < n) {
            if (0 != nums[left]) {
                swap(nums, left, right);
                right++;
            }
            left++;

        }

    }


    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

    }

    public static void moveZeroes2(int[] nums) {
        //j 记录非零元素位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果非零则移动到 j 对应位置
            if(nums[i] != 0){
                nums[j] = nums[i];
                if(i != j){
                    nums[i] = 0;
                }
                j++;
            }

        }

    }

    public static void moveZeroes3(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }

    }




}
