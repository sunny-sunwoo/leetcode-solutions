package leetcode_study;

/**
 * LC 238 Product of array except self
 * 
 * Given an array nums of n integers where n > 1,  
 * return an array output such that output[i] is equal to the product 
 * of all the elements of nums except nums[i].
 * 
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * [Approach] 2 pass from both ends. linear!
 * 
 *   [4,          5,       1,      8,     2       ] 
 * =>[1,          4,       4*5,    4*5*1, 4*5*1*8 ]
 * =>[4*1*2*8*1   1*2*8*1  8*2*1   2*1    1       ]
 * 
 * @author Sunny Park
 *
 */
public class LC238_ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        
        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }
        return ans;
    }
}
