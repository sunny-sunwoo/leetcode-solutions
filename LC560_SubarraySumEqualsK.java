package leetcode_study;

import java.util.HashMap;
import java.util.Map;

/**
 * Q. Given an array of integers and an integer k, 
 * you need to find the total number of continuous subarrays whose sum equals to k.
 * 
 * e.g.
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * 
 * [Approach] find the starting point of the sum interval!
 * -> to find the starting point, I should check if (sum - k) exists.
 * 
 * 1  1  1
 * ^        subarray1 [1,1]
 *    ^     subarray2 [1,1]
 * 
 * 1. 2 vars for result(count the subarray num), sum(cummulative sum).
 * 2. linear scan 
 *    - update the sum.
 *    - check if (sum - k) exists -> if so, increment the result.
 *    - update the map.
 * 
 * [Complexity]
 * - time: O(n)
 * - space: O(n) for cache.
 * 
 * @author Sunny Park
 *
 */

public class LC560_SubarraySumEqualsK {
    public static int findSubarrayNum(int[] nums, int k) {
        Map<Integer/* sum */, Integer /* cnt */> cache = new HashMap<>();
        cache.put(0, 1);
        int sum = 0, result = 0;
        for (int num : nums) {
            sum += num;
            if (cache.containsKey(sum - k)) {
                result += cache.get(sum - k);
            }
            cache.put(sum, cache.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println(findSubarrayNum(nums, 7));
    }
}
