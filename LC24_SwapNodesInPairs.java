package leetcode_study;

/**
 * Q. Given a linked list, swap every two adjacent nodes and return its head.
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * [Approach]
 * 
 * 1. pointer
 * By proceeding with prev, curr pointer each time, 
 * iterate through the nodes.
 * 
 * 2. recursion
 * Defer the next part to the recursive call.
 * 
 * @author Sunny Park
 *
 */

public class LC24_SwapNodesInPairs {
    public static ListNode swapNode(ListNode head) {
        int cnt = 0;
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null && cnt < 2) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }
        
        if (curr != null) {
            head.next = swapNode(curr);
        }
        
        return prev;
    }
    
    private static class ListNode {
        ListNode next;
    }
}
