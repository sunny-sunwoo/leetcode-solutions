package leetcode_study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import ds_algo_study.bst.TreeNode;

/**
 * 
 * Q. Serialization is the process of converting a data structure or object 
 * into a sequence of bits so that it can be stored in a file or memory buffer, 
 * or transmitted across a network connection link to be reconstructed later 
 * in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string 
 * and this string can be deserialized to the original tree structure.
 * 
 * [Approach]
 * Use "preorder"(Self-L-R) traversal to deal with the curr node and defer the rest to the "recursion".
 * 
 * 1) Serialize
 *   - base case: when the node is null.
 *   - logic: SELF + LeftSerialized + RightSerialized.
 *   
 * 2) Deserialize
 *   - use Queue (FIFO).
 *   - poll out the first node and defer the rest. 
 *   - Proceed to the down while creating a new node with the polled String!
 *   
 * [Time/Space]
 * 1. Time: O(n), need to touch every single node once.
 * 2. Space: O(n), for string obj or queue.
 * 
 * @author Sunny Park
 *
 */
public class LC297_SerializeAndDeserializeBT {
    public static String serialize(TreeNode root) {
        if (root == null) return "null,";
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);
        return root.val + "," + leftSerialized + rightSerialized;
    }
    
    public static TreeNode deserialize(String data) {
        System.out.println(data);
        Queue<String> convData = new LinkedList<>();
        convData.addAll(Arrays.asList(data.split(",")));
        return parse(convData);
    }
    
    private static TreeNode parse(Queue<String> convData) {
        String curr = convData.poll();
        if (curr.equals("null")) {
            return null;
        }
        
        TreeNode newNode = new TreeNode(Integer.parseInt(curr));
        newNode.left = parse(convData);
        newNode.right = parse(convData);
        return newNode;
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
        n4.left = n2; // root
        n4.right = n6;
        n6.left = n5;
        n6.right = n7;
        
        System.out.println(n4);
        System.out.println(deserialize(serialize(n4)));
    }
}
