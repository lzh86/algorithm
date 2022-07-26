package com.kaka.algorithm.sort;

import java.util.*;

/**
 * topK问题
 */
public class TopK {
    public static void main(String[] args) {
        String[] str = {"A", "A", "A", "B", "B", "B", "B", "C", "C", "C", "D"};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0, size = str.length; i < size; i++) {
            map.put(str[i], map.getOrDefault(str[i], 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            //按照value值，重小到大排序
//                return o1.getValue() - o2.getValue();

            //按照value值，从大到小排序
            return o2.getValue() - o1.getValue();

        });

//        for (Map.Entry s : list) {
//            System.out.println(s.getKey() + "--" + s.getValue());
//        }

        int n = 2;
        for (int i = 0; i < n; i++) {
            Map.Entry<String, Integer> stringIntegerEntry = list.get(i);
            System.out.println(stringIntegerEntry.getKey() + "--" + stringIntegerEntry.getValue());

        }

    }


    public int[] topKFrequent(int[] nums, int k) {
        int[] ret = new int[k];

        if (null == nums) {
            return ret;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, size = nums.length; i < size; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            //按照value值，重小到大排序
//                return o1.getValue() - o2.getValue();

            //按照value值，从大到小排序
            return o2.getValue() - o1.getValue();

        });

//        for (Map.Entry s : list) {
//            System.out.println(s.getKey() + "--" + s.getValue());
//        }


        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> stringIntegerEntry = list.get(i);
            System.out.println(stringIntegerEntry.getKey() + "--" + stringIntegerEntry.getValue());
            ret[i] = stringIntegerEntry.getKey();
        }

        return ret;
    }


}
