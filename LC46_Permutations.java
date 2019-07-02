package leetcode_study;

import java.util.ArrayList;
import java.util.List;

/**
 * Q. Given a collection of distinct integers, return all possible permutations.
 * 
 * Input: [1,2,3]
 * Output:
 * [ 
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * 
 * [Approach] backtracking
 * base case: tmp size equals to the nums length
 * logic: iterate through the nums. 
 * - if tmp already has the num, continue.
 * - else, 1)add to the tmp.    2)recurse     3)reset the prev state
 * 
 * @author Sunny Park
 *
 */
public class LC46_Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, new ArrayList<>(), nums);
        return result;
    }
    
    private static void permute(List<List<Integer>> result, List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int num : nums) {
            if (tmp.contains(num)) continue;
            tmp.add(num);
            permute(result, tmp, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        System.out.println(permute(nums));
    }
}
