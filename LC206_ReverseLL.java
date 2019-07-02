package leetcode_study;


/**
 * Q. Reverse a Singly LL.
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * [Approach1] Recursion.
 * 1. base case: node is the last one. -> return the node.
 * 2. recurse on the next node. 
 * 3. rebuild the next pointer. 
 * 4. keep returning the last as a result.
 * 
 * [Approach2] Iteration.
 * 1. iterate through the nodes. while curr is not null! 
 * 2. use prev, curr pointer with next(tmp) pointer for swap in the loop.
 * 
 * @author Sunny Park
 *
 */
public class LC206_ReverseLL{
    
    public static Node reverseRecursive(Node head) {
        if (head.next == null) {
            return head;
        }
        Node last = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    
    public static Node reverseIterative(Node head) {
        Node prev = null;
        Node curr = head;
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
        int val;
        Node(int val) {
            this.val = val;
        }
        
        @Override
        public String toString() {
            if (next == null) return String.valueOf(val);
            return String.valueOf(val) +  " -> " + next.toString();
        }
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        
        System.out.println(reverseIterative(n1));
    }
}
