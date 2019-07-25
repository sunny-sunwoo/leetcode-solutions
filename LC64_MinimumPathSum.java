package leetcode_study;

/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * Input:
 * [
      [1,3,1],
      [1,5,1],
      [4,2,1]
   ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * @author JungwooP
 *
 */
public class LC64_MinimumPathSum {
    public static int findMinPathSum(int[][] input) {
        int[][] memo = new int[input.length][input.length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo.length; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = input[i][j];
                    continue;
                }
                int up = i > 0 ? memo[i - 1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? memo[i][j - 1] : Integer.MAX_VALUE;
                memo[i][j] = Math.min(up, left) + input[i][j];
            }
        }
        return memo[input.length - 1][input.length - 1];
    }
    
    public static void main(String[] args) {
        int[][] memo = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(findMinPathSum(memo));
    }
}
