package com.kaka.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class IsAnagram {

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        boolean anagram2 = isAnagram.isAnagram2("qwe", "qwer");
        System.out.println(anagram2);
    }


    /**
     * https://leetcode-cn.com/problems/valid-anagram/
     * @param s
     * @param t
     * @return
     */

    private HashMap<Character,Integer> map = new HashMap();

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
