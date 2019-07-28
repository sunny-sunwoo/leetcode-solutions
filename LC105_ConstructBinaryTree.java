package leetcode_study;
/**
 * Q105. Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 * [Approach] recursion using helper method.
 * 1. base case: inStart > inEnd OR preStart > pre.length -> rt null
 * 2. create a new Node with a value of pre[preStart]
 * 3. find the idx of the value in the inorder array. 
 * 4. recursive calls for newNode.left & right
 *    newNode.left = build(pre, preStart + 1, in, inStart, idx - 1)
 *    newNode.right = build(pre, preStart + (idx - inStart + 1), in, idx + 1, inEnd)
 *                                             ^ the number of left nodes(idx - inStart) + curr newNode
 * @author Sunny Park
 *
 */
public class LC105_ConstructBinaryTree {
    public static TreeNode constructBT(int[] pre, int[] in) {
       return construct(pre, 0, in, 0, in.length - 1);
    }
    
    private static TreeNode construct(int[] pre, int preStart, int[] in, int inStart, int inEnd) {
        if (inStart > inEnd || preStart > pre.length - 1) {
            return null;
        }
        
        TreeNode newNode = new TreeNode(pre[preStart]);
        int idx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                idx = i;
                break;
            }
        }
        
        newNode.left = construct(pre, preStart + 1, in, inStart, idx - 1);
        newNode.right = construct(pre, preStart + idx - inStart + 1, in, idx + 1, inEnd);
        
        return newNode;
    }
    
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right; 
        
        TreeNode(int val) {
            this.val = val;
        }
    }
}
