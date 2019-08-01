package leetcode_study;
/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

 * @author Sunny Park
 *
 */
public class LC155_MinStack {
   private static class Node {
       int val;
       Node next;
       Node prevMin;
       Node(int val) {
           this.val = val;
       }
   }
   
   Node stack;
   Node min;
   
   LC155_MinStack() {
       stack = null;
       min = null;
   }
   
   public void push(int x) {
       Node newNode = new Node(x);
       if (stack == null) {
           stack = newNode;
       } else {
           newNode.next = stack;
           stack = newNode;
       }
       
       if (min == null || stack.val < min.val) {
           stack.prevMin = min;
           min = stack;
       }
   }
   
   public void pop() {
       Node toPop = stack;
       if (toPop == min) {
           min = toPop.prevMin;
       }
       stack = stack.next;
       toPop = null;
   }
   
   public int top() {
       return stack.val;
   }
   
   public int getMin() {
       return min.val;
   }
   
   public static void main(String[] args) {
       LC155_MinStack minStack = new LC155_MinStack();
       minStack.push(3);
       System.out.println(minStack.getMin());
       minStack.push(2);
       System.out.println(minStack.getMin());
       minStack.push(1);
       System.out.println(minStack.getMin());
       minStack.push(3);
       System.out.println(minStack.getMin());
       minStack.pop();
       minStack.pop();
       System.out.println(minStack.getMin());
       
       
       
   }
   
   
   
}
