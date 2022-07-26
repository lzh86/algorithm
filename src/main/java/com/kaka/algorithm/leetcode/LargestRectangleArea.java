package com.kaka.algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        // [2,1,5,6,2,3]
        int[] a = {2,1,5,6,2,3};
        int i = largestRectangleArea.largestRectangleArea(a);
        System.out.println(i);
    }

    /**
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram
     *
     */
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        int length = heights.length;
        int maxArea = 0;

        for(int i = 0;i < length; i ++){
            int minHeight= Integer.MAX_VALUE;
            for(int j = i ;j <length; j++){
                minHeight = Math.min(heights[j],minHeight);
                int area = minHeight * (j-i+1) ;
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }


    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int ans = 0;
        for (int mid = 0; mid < n; ++mid) {
            // 枚举高
            int height = heights[mid];
            int left = mid, right = mid;
            // 确定左右边界
            while (left - 1 >= 0 && heights[left - 1] >= height) {
                --left;
            }
            while (right + 1 < n && heights[right + 1] >= height) {
                ++right;
            }
            // 计算面积
            ans = Math.max(ans, (right - left + 1) * height);
        }
        return ans;
    }


    public int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }



}
