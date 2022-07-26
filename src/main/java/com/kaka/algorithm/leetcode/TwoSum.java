package com.kaka.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        HashMap<String, String> map = new HashMap<>();
        map.put("a","2");
        map.put("a","3");
        System.out.println(map.get("a"));
    }

    /**
     * https://leetcode-cn.com/problems/two-sum/
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] a = null;
        for (int i = 0; i < nums.length - 1; i++) {
            int i1 = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (i1 == nums[j]) a = new int[]{i, j};
            }
        }
        return a;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }


}
