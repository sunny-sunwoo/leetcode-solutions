package leetcode_study;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like 
 * (i.e., buy one and sell one share of the stock multiple times).
 * 
 * Note: You may not engage in multiple transactions at the same time 
 * (i.e., you must sell the stock before you buy again).
 * 
 * [Approach] single one path
 * add up all diffs between consecutive elems.
 * @author Sunny Park
 *
 */
public class LC122_BestTimetoBuyandSellStock2 {
    public static int maxStockProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
    
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxStockProfit(nums));
    }

}
