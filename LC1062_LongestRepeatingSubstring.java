package leetcode_study;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string S, find out the length of the longest repeating substring(s). 
 * Return 0 if no repeating substring exists.
 * 
 * note: not same with the kmp.
 * @author Sunny Park
 *
 */
public class LC1062_LongestRepeatingSubstring {
    /**
     * Generate all substring from the longest one. 
     * - memory limit exceeded: no need to keep all.
     * @param s
     * @return
     */
    public static int repeatingSubstring(String s) {
        Map<String, Integer> cache = new HashMap<>();
        for (int len = s.length(); len > 0; len--) {
            for (int start = 0; start + len <= s.length(); start++) {
                String curr = s.substring(start, start + len);
                if (cache.containsKey(curr)) {
                    return curr.length();
                }
                cache.put(curr, cache.getOrDefault(curr, 0) + 1);
            }
        }
        return 0;
    }
    
    /**
     * Better solution.
     * Keep the longest one only.
     * @param s
     * @return
     */
    public static int repeatingSubstring_sol(String s) {
        Set<String> cache = new HashSet<>();
        int i = 0;
        int maxLen = 0;
        while (i < s.length()) {
            int j = i + maxLen + 1;
            if (j > s.length()) return maxLen;
            String curr = s.substring(i, j);
            if(cache.contains(curr)) {
                maxLen++;
                cache.clear();
                i = 0;
            } else {
                i++;
                cache.add(curr);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(repeatingSubstring("aaabaabb"));
        System.out.println(repeatingSubstring_sol("aaabaabb"));
    }
    
    
}
