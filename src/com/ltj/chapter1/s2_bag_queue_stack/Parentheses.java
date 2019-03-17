package com.ltj.chapter1.s2_bag_queue_stack;


/**
 * Created by ltj on 2019/3/9
 * 括号是否匹配完整
 */
public class Parentheses {

    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';


    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (LEFT_PAREN == s.charAt(i) || LEFT_BRACKET == s.charAt(i) || LEFT_BRACE == s.charAt(i)) {
                stack.push(s.charAt(i));
            } else if (RIGHT_PAREN == s.charAt(i)) {
                if (stack.isEmpty()) return false;
                if (LEFT_PAREN != stack.pop()) return false;
            } else if (RIGHT_BRACKET == s.charAt(i)) {
                if (stack.isEmpty()) return false;
                if (LEFT_BRACKET != stack.pop()) return false;
            } else if (RIGHT_BRACE == s.charAt(i)) {
                if (stack.isEmpty()) return false;
                if (LEFT_BRACE != (stack.pop())) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("[()]{}{[()()]()}"));//为什么调试的时候结果变成false？？？？
        System.out.println(isBalanced("[(})"));
    }
}
