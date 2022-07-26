package com.kaka.algorithm.leetcode;

public class IsPalindrome {
    public static void main(String[] args) {

        boolean palindrome = isPalindrome("a,sa");
        System.out.print(palindrome);

    }

    /**
     * https://leetcode-cn.com/problems/valid-palindrome/
     * 回文判断解决方案
     * 1.字符串反转 equals 比较
     * 2.双指针做比较
     * 主要 isLetterOrDigit 应用 char可以直接参与运算
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
