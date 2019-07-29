package leetcode_study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * LC 322 Coin change
 * 
 * Q. You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1
 * 
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * [Approach1] DP - bottom up
 *      0 1 2 3 4 5 6 7 8 9 10 11
 *   1                              <- only coin [1] is available.
 *   2                              <- [1, 2]
 *   5                              <- [1, 2, 5]
 *   
 *   if (j >= coins[i])  
 *      memo[i][j] = Math.min(memo[i - 1][j], memo[i][j - coins[i]] + 1)
 *   else
 *      memo[i][j] = memo[i - 1][j]
 *      
 * => T.C = O(coin number * amount) // pseudo-polynomial.
 * => note. no need to keep all 2d array cells.
 * 
 * [Approach2] Recursion - top down
 * 1. memoization using hashmap: remaining total -> min number
 * 2. recursive call with total - curr coin.
 *     - recursive
 *     - keep track of min value.
 *     - rt min + 1 if it's not the max int.
 * 
 * @author Sunny Park
 *
 */
public class LC322_CoinChange {
    public static int minimumCoin(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(memo, max);
        memo[0] = 0;
        
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
                }
            }
        }
        return memo[amount] < amount ? memo[amount] : -1;
    }
    
    public static int minimumCoin_TopDown(int[] coins, int amount) {
        return minimumCoin(new HashMap<Integer, Integer>(), coins, amount);
    }
    
    private static int minimumCoin(Map<Integer, Integer> map, int[] coins, int amount) {
        if (amount == 0) return 0;
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) continue;
            int curr = minimumCoin(map, coins, amount - coin);
            if (min > curr) {
                min = curr;
            }
        }
        min = min != Integer.MAX_VALUE ? min + 1 : min;
        map.put(amount, min);
        return min;
    }
    
    
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(minimumCoin(coins, amount));
        System.out.println(minimumCoin_TopDown(coins, amount));
    }
}
