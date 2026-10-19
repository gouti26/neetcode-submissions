/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int height(TreeNode A){
        if(A==null)
            return 0;
        int left = height(A.left);
        int right = height(A.right);

        return Math.max(left,right)+1;
    }
    private boolean helper(TreeNode A){
        if(A==null)
            return true;
        int leftHeight = height(A.left);
        int rightHeight = height(A.right);

        if(Math.abs(leftHeight-rightHeight)>1)
            return false;
        return helper(A.left) && helper(A.right);
        
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root);
    }
}
