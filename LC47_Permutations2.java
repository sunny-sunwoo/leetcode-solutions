package leetcode_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Q. Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.
 * Input: [1,1,2]
 * Output:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]

 * [Approach] Backtracking.
 *     think about the search tree when applying Backtracking.
 *     
 *     
       - 1 - 1 - 2
           - 2 - 1
            
       - X
    
       - 2 - 1 - 1
           - X
           
        X means pruning to avoid duplicate permutations.
        
 *   - How do we ensure the permutations to be unique?
 *     The elements with the same value should be used one by one in order.
 *     
 *     So we sort elements first, and prune the branch 
 *     when an element is the same as the previous element 
 *     but the previous element has not been used in current result.
 *     
 *     
 *  - backtrack method
 *  1. base case: when the tmp size is equal to the nums length.
 *  2. logic: iterate through the nums array.
 *      - check if the elem is used OR the nums[i - 1] == nums[i] : continue
 *      - add to the tmp. mark as true in the used[].  
 *  
 * @author Sunny Park
 *
 */

public class LC47_Permutations2 {
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permute2(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    
    private static void permute2(List<List<Integer>> result, List<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && !used[i - 1] && (nums[i - 1] == nums[i])) continue;
            tmp.add(nums[i]);
            used[i] = true;
            permute2(result, tmp, nums, used);
            tmp.remove(tmp.size() - 1);
            used[i] = false;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2};
        System.out.println(permute2(nums));
    }
}
