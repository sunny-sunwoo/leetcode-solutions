package leetcode_study;

import java.util.Arrays;

/**
 * [Approach] using 2 pointers for partitioning. + proceeding idx.
 * -> move all 0 to the left, 2 to the right.
 * 
 * 1. init all pointers.
 * 2. while idx <= right, check cases.  // edge case: [2, 0, 1]
 *    => if num == 0, swap(idx, left) AND incrementing both.
 *    => if num == 2, swap(idx, right) AND decrementing right only.
 *    => else (// num == 1) just increment idx.
 * 
 * [Note]
 * all index < left: can guarantee "0" is placed!
 * all index > right: can guarantee "2" is placed!
 * 
 * @author Sunny Park.
 *
 */
public class LC75_SortColors {
    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int idx = 0;
        while (idx <= right) {
            if (nums[idx] == 0) {
                swap(nums, idx++, left++);
                continue;
            }
            
            if (nums[idx] == 2) {
                swap(nums, idx, right--);
                continue;
            }
            
            idx++;
        }
        
        System.out.println(Arrays.toString(nums));
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
//        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }
}
