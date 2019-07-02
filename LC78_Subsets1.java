package leetcode_study;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 *   ]
 * 
 * [Approach] Backtracking with ptr
 * base case: when ptr exceeds the right bound!
 * logic: 2 choices for each time - include / exclude
 * 
 * @author Sunny Park
 *
 */
public class LC78_Subsets1 {
    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subset(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private static void subset(List<List<Integer>> result, List<Integer> tmp, int[] nums, int ptr) {
        if (ptr == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        
        tmp.add(nums[ptr]);
        subset(result, tmp, nums, ptr + 1);
        tmp.remove(tmp.size() - 1);
        subset(result, tmp, nums, ptr + 1);
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(subset(nums));
    }
}
