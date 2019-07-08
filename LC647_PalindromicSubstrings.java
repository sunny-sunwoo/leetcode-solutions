package leetcode_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q. Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted 
 * as different substrings even they consist of same characters.
 * 
 * e.g.
 * 1)
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 2)
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * [Approach1] Brute force (memory limit exceeded)
 * 1. generate all combinations of substrings
 * 2. validate if it's palindrome.
 * 
 * [Approach2] Expanding from center.
 * - number of possible center: 2n + 1
 * - expand only if valid.
 * 
 * [Approach3] DP
 * @see <a href="https://leetcode.com/problems/palindromic-substrings/discuss/258917/Java-Simple-Code%3A-DP-short"></a>
 *    0  1  2  3  4
     i\j | a  b  b  a  c  
    --------------------
     0 a | T  F  F  T  F
     1 b | F  T  T  F  F 
     2 b | F  F  T  F  F
     3 a | F  F  F  T  F
     4 c | F  F  F  F  T
     
     i = starting index, j = last index
     
 * 1) i > j: always false
 * 2) i == j: always true
 * 3) i < j: we should compare 2 heads at i and j.
 *    if 1. s.charAt(i) == s.charAt(j) &&  2. isPalindrome(i + 1, j - 1) => true
 *    However, left diagonals should be calculated first all the time
 *    to check 2 letter or 3 letter substrings first.
 *    
 *    e.g. ONLY First-Last index check is required.
 *    -> j - i == 2     aba
 *    -> j - i == 1     aa
 *    
 * @author Sunny Park
 *
 */
public class LC647_PalindromicSubstrings {
    /**
     * Approach1. Generate all substrings!
     * @param s
     * @return
     */
    public static int countSubstring_bruteforce(String s) {
        List<String> list = new ArrayList<>();
        generateAll(list, "", s, 0);
        int count = 0;
        for (String sub : list) {
            if (isPalindrome(sub)) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Approach2. Recursion to expand to the left & right.
     * @param s
     * @return
     */
    public static int countSubstring_recursive(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i+1); // even-len substring
            count += expand(s, i, i); // odd-len substring
        }
        return count;
    }
    
    /**
     * Approach3. DP
     * @param s
     * @return
     */
    public static int countSubstring_dp(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        
        for (int d = 0; d < len; d++) {  // diagonal count
            for (int i = 0; i + d < len; i++) { // row count
                int j = i + d; // col
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (j - i <= 2) ? true : dp[i + 1][j - 1];
                    if (dp[i][j]) count++;
                }
            }
        }
        return count;
    }
    

    public static void main(String[] args) {
    }
    
}
