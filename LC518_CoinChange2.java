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
