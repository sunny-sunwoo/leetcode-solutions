package leetcode_study;

/**
 * LC 236 LCA of Binary Tree
 * 
 * [Approach] Recursion
 * 1) base case
 *  1. root == null -> rt null
 *  2. root == p or q -> rt root.
 *  
 * 2) recursive call
 *  1. 2 calls - left, right
 *  2. if both are not null? rt root.
 *  3. rt not-null node.
 *  
 * @author Sunny Park
 *
 */
public class LC236_LCAofBT {
    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
    
    private static class TreeNode {
        TreeNode left;
        TreeNode right;    
    }
}
