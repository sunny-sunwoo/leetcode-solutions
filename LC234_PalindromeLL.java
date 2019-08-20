package leetcode_study;

import java.util.Stack;

/**
 * Q. Given a singly linked list, determine if it is a palindrome.
 * 
 * e.g.
 * Input: 1->2->2->1
 * Output: true
 * 
 * [Approach]
 * 1 -> 2 -> 2 -> 1
 *           ^       ^
 *           
 *  1. using 2 ptrs, 
 *     iterate while fast or fast.next is not null
 *      -> proceed 1, 2 steps.
 *      -> push slow to the stack.
 *  2. check if fast is not null
 *     => proceed slow by 1 more step.
 *  3. iterate while slow is not null
 *      -> check if equals (stack.pop value and slow.)
 * @author Sunny Park
 *
 */
public class LC234_PalindromeLL {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast != null) {
            slow = slow.next;
        }
        
        while (slow != null) {
            if (stack.pop().intValue() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        
        return true;
    }
    
    private static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
        }
    }
}
