package leetcode_study;

import java.util.Arrays;
import java.util.List;

import com.google.common.primitives.Chars;

/**
 * LC 242 valid anagram
 * 
 * Q. Given two strings s and t , write a function to determine if t is an anagram of s.
 * 
 * e.g.
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * 
 * [Approach1] int array, length 26
 * 1. iterate through each char of s - increment the idx by 1.
 * 2. iterate through each char of t 
 *     - if curr idx value <= 0 ? -> rt false.
 *     - decrement by 1.
 *     
 * 3. check if any elem is not zero? -> rt false
 * 4. rt true.
 * 
 * 
 * [Approach2] using HashMap<Character, Integer>
 * 
 * @author Sunny Park
 *
 */
public class LC242_ValidAnagram {
    public static boolean isValidAnagram(String s, String t) {
        int[] checker = new int[26];
        populate(checker, s);
        for (char c : t.toCharArray()) {
            if (checker[c - 'a'] <= 0) return false;
            checker[c - 'a']--;
        }
        return Arrays.stream(checker).allMatch(e -> e == 0);
    }
    
    private static void populate(int[] checker, String s){
        List<Character> chars = Chars.asList(s.toCharArray());
        chars.forEach(c -> checker[c.charValue() - 'a']++);
    }
    
    public static void main(String[] args) {
        System.out.println(isValidAnagram("anagram", "nagaram"));
    }
}
