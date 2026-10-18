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
    int diameter = Integer.MIN_VALUE;
    private int helper(TreeNode root){
        if(root==null)
            return 0;
        int leftVal = helper(root.left);
        int rightVal = helper(root.right);
        diameter = Math.max(leftVal+rightVal,diameter);
        return 1 + Math.max(leftVal,rightVal);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }
}
