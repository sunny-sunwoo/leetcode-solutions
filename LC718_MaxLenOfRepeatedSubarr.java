package leetcode_study;

/**
 * 
 * LC718. Maximum Length of Repeated Subarray
 * Given two integer arrays A and B, return the maximum length of an subarray
 * that appears in both arrays.
 * 
 * Input: A: [1,2,3,2,1], B: [3,2,1,4,7]
 * Output: 3
 * 
 * [Approach] DP. similar to LCS {@code T2_LCS} 
 * 1. create a 2d array. row and col num should be each length + 1 for convenience.
 * 2. iterate through the 2d arr. as much as a, b lengths.
 *    - if a[i] == b[j] ? fill memo[i][j] = previous count + 1.
 * 3. return the last num.
 * 
 * @author Sunny Park
 *
 */
public class LC718_MaxLenOfRepeatedSubarr {
    public static int findMaxLen(int[] a, int[] b) {
        int[][] memo = new int[a.length + 1][b.length + 1];
        int res = 0;
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                }
                res = Math.max(res, memo[i][j]);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] a = {0,1,1,1,1};
        int[] b = {1,0,1,0,1};
        System.out.println(findMaxLen(a, b));
    }
}
