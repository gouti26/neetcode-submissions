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
    private int helper(TreeNode root){
        if(root==null)
            return 0;
        int leftVal = helper(root.left);
        int rightVal = helper(root.right);
        return Math.max(leftVal,rightVal)+1;
    }
    public int maxDepth(TreeNode root) {
        return helper(root);
    }
}
