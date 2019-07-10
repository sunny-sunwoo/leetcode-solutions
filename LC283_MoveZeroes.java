package leetcode_study;

import java.util.Arrays;

/**
 * Q. Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * [Approach1] linear scan with pointer
 *  1. ptr = 0
 *  2. check if the curr is not zero
 *      -> arr[ptr] = curr.
 *      -> ptr++
 *  3. fill zeroes till the end.
 *  
 * [Approach2] use swap!
 * 1. ptr = 0.
 * 2. check if the curr is not zero
 *    -> swap the nums at ptr <-> curr idx 
 *    => no need to fill zero at the end.
 * 
 * @author Sunny Park
 *
 */
public class LC283_MoveZeroes {
    public static int[] moveZeroes(int[] arr) {
        int ptr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[ptr] = arr[i];
                ptr++;
            }
        }
        
        while (ptr < arr.length) {
            arr[ptr] = 0;
            ptr++;
        }
        
        return arr;
    }
    
    public static int[] moveZeroes_swap(int[] arr) {
        int ptr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, ptr, i);
                ptr++;
            }
        }
        return arr;
    }
    
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        System.out.println(Arrays.toString(moveZeroes(arr)));
        System.out.println(Arrays.toString(moveZeroes_swap(arr)));
    }
    
}
