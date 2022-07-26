package com.kaka.algorithm.leetcode;

import java.util.HashMap;

public class ClimbStairs {

    private HashMap<Integer,Integer> hasSolvedList = new HashMap();
    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int i = climbStairs.climbStairs(45);
        System.out.println(i);
    }

    /**
     * 1.https://leetcode-cn.com/problems/climbing-stairs/submissions/
     * 采用递归求解斐波那契数列,为了避免重复计算问题,引入缓存
     * 动态规划求解
     * 为什么楼梯可以理解成斐波那契数列求解
     * 第 3 级台阶等于第 2 级台阶 跨一步走上来，或者是 第 1 级台阶 一下跨 2步走上来
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n == 0) return 1;
        if (n == 1) return 1;

        if (hasSolvedList.containsKey(n)) {
            return hasSolvedList.get(n);
        }

        int ret = climbStairs(n - 1) + climbStairs(n - 2);
        hasSolvedList.put(n, ret);
        return ret;
        }

}
