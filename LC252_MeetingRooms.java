package leetcode_study;

import java.util.Arrays;

/**
 * Q252. meeting rooms
 * 
 * e.g. 
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * 
 * @author Sunny Park
 *
 */
public class LC252_MeetingRooms {
    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return true;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++){
            int[] next = intervals[i];
            if (isOverlapped(curr, next)) {
                return false;
            }
            curr = next;
        }
        return true;
    }
    
    private static boolean isOverlapped(int[] curr, int[] next) {
        return curr[1] > next[0];
    }
}
