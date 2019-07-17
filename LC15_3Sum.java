package leetcode_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q. Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * -> -1, -1, 0, 1, 2, -4

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 *
 *[Approach] Binary search.
 * 1. sort - to avoid checking same numbers repeatedly. 
 * 2. iterate over 0 ~ len - 2 (cuz the goal is finding 2 more nums after target.)
 *    - if same number -> skip
 *    - set the target, lo(right after the target), hi.
 *    - while (lo < hi)
 *         case1. sum found
 *                -> add result triplets. proceed lo to the right & hi to the left.
 *         case2. sum < target -> move lo to the right.
 *         case3. sum > target -> move hi to the left.
 *
 * @author Sunny Park
 *
 */
public class LC15_3Sum {
    public static List<List<Integer>> threesum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) continue;
            int target = -arr[i];
            int lo = i + 1;
            int hi = arr.length - 1;
            while (lo < hi) {
                int sum = arr[lo] + arr[hi];
                if (sum == target) {
                    result.add(Arrays.asList(-target, arr[lo], arr[hi]));
                    lo++;
                    hi--;
                    while (lo < hi && arr[lo] == arr[lo - 1]) lo++;
                    while (lo < hi && arr[hi] == arr[hi + 1]) hi--;
                    continue;
                } 
                
                if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.print(threesum(arr));
    }
}
