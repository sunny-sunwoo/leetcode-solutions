package leetcode_study;

import java.util.Arrays;

/**
 * Q. Given an array of 2n integers, your task is to group these integers into n pairs of integer, 
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) 
 * for all i from 1 to n as large as possible.
 * 
 * Input: [1,4,3,2]
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * 
 * [Approach] using sorting.
 * 1. sort
 * 2. take every first(index 0, 2, 4, ...) elem of pair should be added to the sum.
 * 
 * When taking (a,b) (a > b), loss is (a - b)
 * Then, the goal is to minimize the loss.
 *       => numbers should be close to each other minimize the loss.
 *       
 * [Time/Space]
 * time: O(nlogn)
 * space: O(1)
 * 
 * @author Sunny Park
 *
 */
public class LC561_ArrayPartition1 {
    public static int getMaxSum(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i += 2) {
            sum += arr[i];
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(getMaxSum(arr));
    }
}
