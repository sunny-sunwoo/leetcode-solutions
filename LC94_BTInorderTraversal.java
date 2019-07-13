package leetcode_study;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ds_algo_study.bst.TreeNode;

/**
 * 
 * LC#94_ Binary Tree Inorder Traversal
 * [Approach1] Recursion
 * 
 * [Approach2] Iterative with stack
 * 1. push curr node's val up to the left most node.
 * 2. pop -> add to the result.
 * 3. if popped has right? -> push to the stack.
 * 
 * 
 * [Approach3] Morris Traversal - transform BT for traversal.
 * 1. if curr doesn't have left child
 *    - add curr to the result
 *    - move to the right
 *    
 * 2. else
 *    - set prev!!!!
 *    - find the rightmost node R
 *    - put curr @ the R's right.
 *    - keep the curr as temp
 *    - update curr & temp's left
 *    
 * => Time, Space: O(n) 
 * 
 * @author Sunny Park
 *
 */
public class LC94_BTInorderTraversal {
    public static List<Integer> inorder_recursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(result, root);
        return result;
    }
    
    private static void inorder(List<Integer> result, TreeNode node) {
        if (node == null) return;
        inorder(result, node.left);
        result.add(node.val);
        inorder(result, node.right);
    }
    
    // Approach2. using Stack
    public static List<Integer> inorder_stack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        pushLeft(stack, root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            result.add(top.val);
            if (top.right != null) {
                pushLeft(stack, top.right);
            }
        }
        return result;
    }
    
    private static void pushLeft(Stack<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    
    // Approach3. using morris traversal.
    public static List<Integer> inorder_morris (TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        TreeNode prev;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        n1.right = n2;
        n2.left = n3;
       
        System.out.println(inorder_recursive(n1));
        System.out.println(inorder_stack(n1));
        System.out.println(inorder_morris(n1)); 
         
    }
}
