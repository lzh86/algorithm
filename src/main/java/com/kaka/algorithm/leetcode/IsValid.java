package com.kaka.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {
    private  HashMap<Character,Character> leftMap =  new HashMap();
    public static void main(String[] args) {
        IsValid isValid = new IsValid();
    }

    /**
     * https://leetcode-cn.com/problems/valid-parentheses/
     * 最近相关性的问题 考虑用栈解决
     * 遇到左边的括号就入栈，遇到右边的括号就弹出栈顶元素做比较
     * 用两个栈来实现队列，用两个队列来实现栈
     * 还有一种暴力解决方案，碰上成对的括号直接替换成空串，最后比较元素是不是全部被替换成空即可 时间复杂度 O(n2)
     * @param s
     * @return
     */
    public boolean isValid(String s){
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();

    }



    /**
     *
     * @param s
     * @return
     */
    public boolean isValidError(String s) {
        leftMap.put('(', ')');
        leftMap.put('{', '}');
        leftMap.put('[', ']');


        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        if(s.length()%2!=0)return false;

        for (int i = 0;i<s.length()/2 - 1;i++){
            if(leftMap.containsKey(s.charAt(i))) {
                leftStack.push(s.charAt(i));
            }else {
                rightStack.push(s.charAt(i));
            }
        }

        for (int i = s.length() -1;i>=s.length()/2 - 1;i--){
            if(leftMap.containsKey(s.charAt(i))) {
                leftStack.push(s.charAt(i));
            }else {
                rightStack.push(s.charAt(i));
            }
        }

        while (!leftStack.empty()){
            if(leftMap.get(leftStack.pop()) != rightStack.pop()) return false;
        }
        return true;
    }
}
