package leetcode_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q. Given a collection of integers that might contain duplicates, nums, 
 * return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Input: [1,2,2]
 * Output:
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 * 
 * [Approach1] Backtracking with global variable. 
 *  checking what's just removed. 
 * 
 * [Approach2] Better bactracking. 
 *   -> recurse on the valid list only!
 *  checking if the previous elem equals to the curr. 
 *  no need to consider remove opr. 
 *  nums should be sorted first!
 *  
 * @author Sunny Park
 * 
 */
public class LC90_Subsets2 {
    public static List<List<Integer>> uniqueSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
//        backtrack1(result, new ArrayList<>(), nums, 0);
        backtrack2(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private static int removed = Integer.MIN_VALUE;
    private static void backtrack1(List<List<Integer>> result, List<Integer> tmp, int[] nums, int ptr) {
        result.add(new ArrayList<>(tmp));
        for (int i = ptr; i < nums.length; i++) {
            if (removed == nums[i]) continue;
            tmp.add(nums[i]);
            backtrack1(result, tmp, nums, i + 1);
            removed = tmp.remove(tmp.size() - 1);
        }
    }
    
    private static void backtrack2(List<List<Integer>> result, List<Integer> tmp, int[] nums, int ptr) {
        result.add(tmp);
        for (int i = ptr; i < nums.length; i++) {
            if (i > ptr && nums[i - 1] == nums[i]) continue;
            List<Integer> path = new ArrayList<>(tmp);
            path.add(nums[i]);
            backtrack2(result, path, nums, i + 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2};
        System.out.println(uniqueSubsets(nums));
    }
}
