package leetcode_study;

import java.util.ArrayDeque;
import java.util.Arrays;

import ds_algo_study.bst.TreeNode;

/**
 * Q. Design an algorithm to serialize and deserialize a binary search tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary search tree can be serialized to a string 
 * and this string can be deserialized to the original tree structure.
 * 
 * [Approach]
 * serialize
 * 
 * @author Sunny Park
 *
 */
public class LC449_SerializeandDeserializeBST {
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(sb, root);
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
    
    private static void serialize(StringBuilder sb, TreeNode node) {
        if (node == null) return;
        serialize(sb, node.left);
        serialize(sb, node.right);
        sb.append(node.val).append(" ");
    }
     
    public static TreeNode deserialize(String data) {
        ArrayDeque<String> list = new ArrayDeque<>();
        list.addAll(Arrays.asList(data.split(" ")));
        return deserialize(list, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static TreeNode deserialize(ArrayDeque<String> list, int min, int max) {
        if (list.isEmpty()) return null;
        
        String top = list.getLast();
        int curr = Integer.parseInt(top);
        if (curr < min || curr > max) return null;
        
        list.pollLast();
        TreeNode newNode = new TreeNode(curr);
        newNode.right = deserialize(list, curr, max);
        newNode.left = deserialize(list, min, curr);
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
        System.out.println(serialize(n4));
        System.out.println(deserialize(serialize(n4)));
    }
}
