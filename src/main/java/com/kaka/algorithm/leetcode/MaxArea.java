package com.kaka.algorithm.leetcode;

public class MaxArea {

    public static void main(String[] args) {

    }

    /**
     * https://leetcode-cn.com/problems/container-with-most-water/
     * 1.定义双指针，短的指针移动
     * todo 双指针的原理
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int length = height.length;
        int left = 0, right = length - 1, maxArea = 0;

        while (left < right) {
            int i = Math.min(height[left], height[right]) * (right - left);
            //if (i > maxArea) maxArea = i;
            maxArea = Math.max(i, maxArea);

            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }

        }
        return maxArea;
    }

    public static int maxArea2(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int maxHeight = height[i] < height[j] ? height[i++] : height[j++];
            maxArea = Math.max(maxArea, (j - i + 1) * maxHeight);
        }
        return maxArea;
    }
}
