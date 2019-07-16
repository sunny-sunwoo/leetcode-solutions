package leetcode_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Q. Given a non-empty array of integers, return the k most frequent elements.
 * 
 * e.g.
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * [Approach1] NLogN time using minHeap.
 * => O(NLogK) time, O(N) space.
 * 
 * [Approach2] N time with multiple interation.
 * - solution is interesting, 
 * but won't work if elem can include negative nums or have same freq numbers.
 * 1. build a freq map.
 * 2. build an array and fill -1 at first.
 *    index(value - 1) = elem (key)
 *    => this array has an ascending order of freq.
 * 3. take k nums to the result.
 * 
 * @author Sunny Park
 *
 */
public class LC347_TopKFreqElement {
    public static List<Integer> topKElement(int[] num, int k) {
        Map<Integer, Integer> map = buildFreqMap(num);
        int[] arr = buildFreqArr(map, num.length);
        List<Integer> result = new ArrayList<>();
        int idx = arr.length - 1;
        while (k > 0) {
            int curr = arr[idx];
            if (curr != -1) {
                k--;
                result.add(curr);
            }
            idx--; 
        }
        return result;
    }
    
    private static int[] buildFreqArr(Map<Integer, Integer> map, int len) {
        int[] arr = new int[len];
        Arrays.fill(arr, -1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[entry.getValue() - 1] = entry.getKey();
        }
        return arr;
    }
    
    private static Map<Integer, Integer> buildFreqMap(int[] num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : num) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return map;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,3,3,3,3,4,4,4,4};
        System.out.println(topKElement(arr, 3));
    }
}
