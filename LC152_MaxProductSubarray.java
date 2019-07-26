package leetcode_study;

/**
 * 
 * LC 152 Max product subarray
 * Given an integer array nums, find the contiguous subarray within an array 
 * (containing at least one number) which has the largest product.
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 * [Approach] dp
 * 1. keep max and min. bc/ min can become the max due to the negative nums.
 * 2. find max.
 * 
 * @author Sunny Park
 *
 */
public class LC152_MaxProductSubarray {
    public static int maxProductSubarray(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0]; // keep max
        dp[0][1] = nums[0]; // keep min
                
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int currMax = Math.max(dp[i - 1][0] * curr, dp[i - 1][1] * curr);
            int currMin = Math.min(dp[i - 1][0] * curr, dp[i - 1][1] * curr);
            dp[i][0] = Math.max(currMax, curr);
            dp[i][1] = Math.min(currMin, curr);
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = max < dp[i][0] ? dp[i][0] : max;
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(maxProductSubarray(arr));
    }
}
