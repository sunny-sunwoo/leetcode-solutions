package leetcode_study;

import com.google.common.primitives.Ints;

/**
 * Q. Given two words word1 and word2, 
 * find the minimum number of operations required to convert word1 to word2.
 * 
 * e.g.
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
    Explanation: 
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')
    
 * 
 * [Intuition] DP
 * There are 4 types of situation.
 *                                         (SUBPROBLMS)
 * 1) when chars are matched: 
 *      A[0, 4] -> B[0, 4]         <=>      A[0, 3] -> B[0,3]
 *      sunn'y' -> rain'y'                  sunn    -> rain
 *      
 * 2) not matched (3 actions):
 *    Action1. replace    
         A[0, 3] ->  B[0, 2]       <=>     A[0, 2] -> B[0,1] then replace (y to h)
         ben'y'  ->  ep'h'                  ben    -> ep
 *    
 *    Action2. insert
         A[0, 3] ->  B[0, 2]       <=>     A[0, 2] -> B[0,1] then insert h
         ben'y'  ->  ep'h'                  ben    -> ep   
         
 *    Action3. delete
         A[0, 3] ->  B[0, 2]       <=>     A[0, 2] -> B[0,2] (y is deleted) 
         ben'y'  ->  ep'h'                  ben    -> eph    
 * 
 * 
 * In the 2d array,
 *                  A 
     *      -----------------
     *      Replace | Insert
     *  B   --------|--------
     *      Delete  | "HERE"
     *      -----------------
     *      
     * Transformation: A -> B
 * 
 * 
 * [Approach] DP
 * 1. make a 2d array, int[][] dp,  and init the first row & col.
 * 2. iterate through the arr
 *      1) if chars match: subproblem == just replace without them.
 *      2) else: get minimum of 3 actions + 1.
 *      
 * [Time/Space]  O(ab) (a = s1.length(), b = s2.length())     
 *      
 * @see <a href="https://leetcode.com/problems/edit-distance/"> LC#72 </a>
 * @author JungwooP
 *
 */

public class LC72_EditDistance {
    public static int editDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        init(dp);
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Ints.min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    
    private static void init(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) dp[i][j] = j;
                if (j == 0) dp[i][j] = i;
                else continue;
            }
        }
    }
    
    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "cab";
        System.out.println(editDistance(s1, s2));
    }
}
