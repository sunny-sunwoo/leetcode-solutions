package leetcode_study;

/**
 * 
 * Q. You are given coins of different denominations and a total amount of money. 
 * Write a function to compute the number of combinations that make up that amount. 
 * You may assume that you have infinite number of each kind of coin.
 * 
 * e.g. 
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1
    
 * Input: amount: 3, coins = [2]
 * Output: 0
 * 
 * [Approach] dynamic programming
 * 1. dp table (with 1 more row & col)
 * 2. init first col with 1
 * 3. if curr coin is enough to include curr amt? prev row + curr row (step back by coin size)
 * 4. rt last cell.
 * 
 * => each cell
 *    = number of cases to represent the amount using curr available coins.
 *    
 * @author Sunny Park
 *
 */
public class LC518_CoinChange2 {
    public static int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length + 1][amount + 1];
        memo[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            memo[i][0] = 1;
            for (int j = 0; j <= amount; j++) {
                memo[i][j] = memo[i - 1][j] + (j >= coins[i - 1] ? memo[i][j - coins[i - 1]] : 0);
            }
        }
        return memo[coins.length][amount];
    }
    
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 5));
    }
}
