package leetcode_study;

/**
 * Q. Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * e.g.
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
 
 * [Approach] array hooper - linear
 * => keep curr and last.
 * => cnt if i passes last.
 * 
 * 1. init curr, last, cnt.
 * 2. iterate through the nums
 *    - if i > last ? increment cnt.
 *    - if i + arr[i] > curr ? update curr.
 * 
 * 
 * @author Sunny Park
 *
 */
public class LC45_JumpGame2 {
    public static int minJump(int[] arr) {
        int curr = 0, last = 0;
        int cnt = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (i > last) {
                cnt++;
                last = curr;
            }
            
            if (i + arr[i] > curr) {
                curr = i + arr[i];
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        System.out.println(minJump(arr));
    }
}
