package leetcode_study;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LC#20 Valid Parentheses.
 * 
 * Q. Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * 
 * [Approach] using Stack.
 * iterating through the String s
 * 1. check if it's open type -> push to the stack.
 * 2. else(closing type)
 *    - if stack is empty -> false.
 *    - stack.peek() isn't the right pair -> false.
 *    
 * 3. return if stack is empty.
 * 
 * @author Sunny Park
 *
 */
public class LC20_ValidParentheses {
    public static boolean isValid(String s) {
        Map<Character, Character> map = buildMap();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.values().contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (map.keySet().contains(c) 
                        && stack.peek() != map.get(c)) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    private static Map<Character, Character> buildMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        return map;
    }
    
    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
}