package leetcode_study;

import java.util.Stack;

/**
 * Q. Given a Binary Search Tree (BST), convert it to a Greater Tree 
 * such that every key of the original BST is changed to the original key plus sum of
 * all keys greater than the original key in BST.
 * 
 * [Approach1] Recursion - with global variable.
 * - collect the sum using global variable.
 * - not preferable.
 * 
 * [Approach2] Better Recursion - without global variable.
 * -    2
 *    1   3
 * 
 * - traversal order: right first! right -> left -> curr.
 * - think about what to return, what to pass.
 * 
 * - e.g. 
 * to the right: sum should be passed. 
 * to the left: sum + curr.val should be passed. 
 *              the *updated value* should be returned from the left!  
 *  
 * - Complexity
 *   time: O(n)
 *   space: O(n), bst is not specified to balanced bst.
 *   
 * [Approach3] using Stack
 * - push all nodes up to (and including) this subtree's maximum on the stack. 
 * - all nodes with values between the current and its parent lie in the left subtree.
 * - Complexity: O(n) time, O(n) space,  n = # of nodes.
 * 
 * @see <a href="https://leetcode.com/problems/convert-bst-to-greater-tree"> LC#538 </a>
 * @author Sunny Park
 *
 */
public class LC538_ConvertBSTtoGreaterTree {
    static int globalSum = 0;
    public static TreeNode convert_recursion(TreeNode root) {
        if (root == null) return root;
        convert_recursion(root.right);
        globalSum += root.val;
        root.val = globalSum;
        convert_recursion(root.left);
        return root;
    }
    
    public static TreeNode convert_better(TreeNode root) {
        convert(root, 0);
        return root;
    }
    
    private static int convert(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        
        int right = convert(node.right, sum);
        int left = convert(node.left, right + node.val);
        node.val += right;
        
        // after completing all updates
        return left;
        
    }
    
    public static TreeNode convert_stack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int sum = 0;
        
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            
            node = node.left;
        }
        
        return root;
    }
    
    private static class TreeNode {
        static int cnt = 1;
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
            this.val = cnt;
            cnt++;
        }
        
        @Override
        public String toString() {
            if (left == null && right == null) return "Node-" + String.valueOf(val);
            return left + " // " + "Node-" + this.val + " // " + right;
        }
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode();
        TreeNode n2 = new TreeNode();
        TreeNode n3 = new TreeNode();
        TreeNode n4 = new TreeNode();
        TreeNode n5 = new TreeNode();
        TreeNode n6 = new TreeNode();
        TreeNode n7 = new TreeNode();
        
        n2.left = n1;
        n2.right = n3;
        n4.left = n2;
        n4.right = n6;
        n6.left = n5;
        n6.right = n7;
        
//        System.out.println(convert_recursion(n4));
//        System.out.println(convert_better(n4));
        System.out.println(convert_stack(n4));
    }
}
