package leetcode_study;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * [Approach] 2 ptrs and hashset
 * 
 * abcabcab
 *  ^^^
 *  |  
 *  
 * [solution]
 * 1. linear scan all chars.
 * 2. if set doesn't contain curr char, add to the char. expand right pointer.
 * 3. else, remove from the set, increase left to proceed to the right.
 * 
 * @author Sunny Park
 *
 */
public class LC3_LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> cache = new HashSet<>();
        int maxLen = 0;
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!cache.contains(s.charAt(j))) {
                cache.add(s.charAt(j));
                j++;
                maxLen = Math.max(maxLen, j - i);
            } else {
                cache.remove(s.charAt(i));
                i++;
            }
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("abcabcab"));
    }
}
