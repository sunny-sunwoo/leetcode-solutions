package leetcode_study;

import java.util.Stack;

/**
 * 
    push(x) -- Push element x to the back of queue.
    pop() -- Removes the element from in front of queue.
    peek() -- Get the front element.
    empty() -- Return whether the queue is empty.

 * @author Sunny Park
 *
 */
public class LC232_QueueUsingStacks {
    Stack<Integer> in;
    Stack<Integer> out;
    
    LC232_QueueUsingStacks() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int n) {
        in.push(n);
    }
    
    public int pop() {
        peek();
        return out.pop().intValue();
    }
    
    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
    
    public static void main(String[] args) {
        LC232_QueueUsingStacks q = new LC232_QueueUsingStacks();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.pop());
        q.push(4);
        q.push(5);
        System.out.println(q.pop());
    }
}
