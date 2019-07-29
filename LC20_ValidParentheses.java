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
    
    /**
     * given a string which inclue (,) only.
     * -> no need to use stack separately.
     * @param s
     * @return
     */
    public static boolean validate(String s) {
        int leftCount = 0;
        for(char c : s.toCharArray()) {
            if (c == '(') leftCount++;
            else {
                if (leftCount <= 0) return false;
                leftCount--;
            }
        }
        return leftCount == 0;
    }
    
    public static boolean validateParenetheses(String input) {
        int round = 0, curly = 0, square = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') {
                round++;
                continue;
    }
            if (c == '{') {
                curly++;
                continue;
    }
    if (c == '[') {
                square++;
                continue;
    }

    if (c == ')') {
        if (round < 1) return false;
        round--;
        continue;
    }

    if (c == '}') {
        if (curly < 1) return false;
        curly--;
        continue;
    }
    if (c == ']') {
        if (square < 1) return false;
        square--;
        continue;
    }
    }
    return (round == 0) && (curly == 0) && (square == 0);
    }

    public static void main(String[] args) {
//        System.out.println(isValid("{[]}"));
        System.out.println(validate(")()("));
        System.out.println(validateParenetheses("([{]()})"));
    }
}
