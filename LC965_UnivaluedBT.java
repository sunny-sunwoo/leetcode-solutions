package leetcode_study;

/**
 * Q. A binary tree is univalued if every node in the tree has the same value.
 * Return true if and only if the given tree is univalued.
 * 
 * [Approach]
 * 1. usnig helper method (overloading)
 * 2. pass the value in the param.
 * @author Sunny Park
 *
 */
public class LC965_UnivaluedBT {
    public static boolean isUnivalueBT(TreeNode root) {
        return isUnivalueBT(root, root.val);
    }
    
    private static boolean isUnivalueBT(TreeNode node, int val) {
        if (node == null) return true;
        if (node.val != val) return false;
        return isUnivalueBT(node.left, val) && isUnivalueBT(node.right, val);
    }
    
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(2);
        
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        
        System.out.println(isUnivalueBT(n1));
    }
}
