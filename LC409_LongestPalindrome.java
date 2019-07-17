package leetcode_study;

/**
 * 
 * [Approach] Greedy
 * 1. build a 128-long int[] arr to keep the freq. // ASCII
 * 2. interate through the arr
 *    -> increment result by adding freq/2 * 2.
 *    -> if result is even number & freq is odd -> we can add 1 once.
 * 
 * @author Sunny Park.
 *
 */
public class LC409_LongestPalindrome {
    public static int longestPalindrome(String s) {
        int[] freqArr = buildArr(s);
        int result = 0;
        for (int i = 0; i < freqArr.length; i++) {
            int curr = freqArr[i];
            result += (curr / 2) * 2;
            if (result % 2 == 0 && curr % 2 == 1) {
                result++;
            }
        }
        return result;
    }
    
    private static int[] buildArr(String s) {
        int[] freqArr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            freqArr[s.charAt(i) - 'a']++;
        }
        return freqArr;
    }
    
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
