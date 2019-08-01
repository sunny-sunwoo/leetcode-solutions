package leetcode_study;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    empty() -- Return whether the stack is empty.
 * @param n
 */
public class LC225_StackUsingQueues {
    Queue<Integer> stack;
    LC225_StackUsingQueues() {
        stack = new LinkedList<>();
    }
    
    public void push(int n) {
        int size = stack.size();
        stack.offer(n);
        while (size > 0) {
            stack.offer(stack.poll());
            size--;
        }
    }
    
    public int pop() {
        return stack.poll();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        LC225_StackUsingQueues s = new LC225_StackUsingQueues();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
