package leetcode_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LC#56. Merge Intervals
 * 
 * Q. Given a collection of intervals, merge all overlapping intervals.
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * [Approach1] List<int[]> result.
 * 1. sort the input
 * 2. build List of int[]
 * 
 * 3. linear scan of input.
 * compare the prev with curr pair!
 *    1) if merged
 *       -> l2 <= r1 && r1 < r2 
 *          (if the next is fully nexted, no need to update the prev.)
 *    2) else 
 *       -> add prev to the result & update prev
 *       
 * 4. *** NOTE *** 
 *   -> The last pair wasn't added but kept in prev. 
 *   -> Should be considered before returning.
 *   
 * [Approach2] Interval class
 * - By creating Interval class with start and end, enhance the readability.
 * - should be Comparable to sort accordingly.
 * 
 * @author Sunny Park
 *
 */
public class LC56_MergeIntervals {
    // Without Interval object.
    public static int[][] mergeIntervals(int[][] input) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(input, (a,b) -> a[0] - b[0]);
        int[] prev = input[0];
        for (int i = 1; i < input.length; i++) {
            int[] curr = input[i];
            if (curr[0] <= prev[1]) {
                if (prev[1] < curr[1]) {
                    prev[1] = curr[1];
                }
            } else {
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev); // last pair should be added.
        return buildResult(result);
    }
    
    private static int[][] buildResult(List<int[]> result) {
        int[][] ret = new int[result.size()][2];
        int i = 0;
        for (int[] pair : result) {
            ret[i][0] = pair[0];
            ret[i][1] = pair[1];
            i++;
        }
        return ret;
    }
    
    // With Interval object
    public static int[][] mergeIntervals2(int[][] input) {
        List<Interval> intervals = populate(input);
        Collections.sort(intervals);
        Interval prev = intervals.get(0);
        List<Interval> result = new ArrayList<>();
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start <= prev.end) {
                prev.end = Math.max(prev.end, curr.end);
            } else {
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        return convertResult(result);
    }
    
    private static List<Interval> populate(int[][] input) {
        List<Interval> intervals = new ArrayList<>();
        for (int[] pair : input) {
            intervals.add(new Interval(pair[0], pair[1]));
        }
        return intervals;
    }
    
    private static int[][] convertResult(List<Interval> result) {
        int[][] ret = new int[result.size()][2];
        int i = 0;
        for (Interval curr : result) {
            ret[i] = new int[] {curr.start, curr.end};
            i++;
        }
        return ret;
    }
    
    private static class Interval implements Comparable<Interval> {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Interval other) {
            int comp = Integer.compare(start, other.start);
            return comp != 0 ? comp : Integer.compare(end, other.end);
        }
    }
    
    public static void main(String[] args) {
//        int[][] input = {{15,18}, {1,3}, {8,10}, {2,6}};
        int[][] input = {{1,4}, {4,5}};
        int[][] result = mergeIntervals(input);
        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }
    }

}
