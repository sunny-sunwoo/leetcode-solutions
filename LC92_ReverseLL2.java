package leetcode_study;

/**
 * Q. Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * [Approach1] using pointers
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> NULL, m = 2, n = 4
 *       (p) (c)        (s)  (r)
 * pointers for previous, current, stride, remaining.      
 * 
 * Output: 1->4->3->2->5->NULL
 * @author Sunny Park
 *
 */
public class LC92_ReverseLL2 {
    public static Node reverseLL_pointers(Node head, int m, int n) {
        Node prev = head;
        int cnt = 0;
        while (prev != null && cnt < m - 2) {
            prev = prev.next;
            cnt++;
        }
        
        Node curr = prev.next;
        Node stride = curr;
        cnt = 0;
        
        while (stride != null && cnt < n - m) {
            stride = stride.next;
        }
        Node remaining = stride.next;
        prev.next = null;
        stride.next = null;
        
        Node reversed = reverse(curr);
        prev.next = reversed;
        curr.next = remaining;
        
        return head;
    }
    
    private static Node reverse(Node node) {
        Node prev = null;
        Node curr = node;
        
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    private static class Node {
        Node next;
    }
}
