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
    int maxPathSum;
    private int helper(TreeNode root){
        if(root==null)
            return 0;
        int leftVal = Math.max(helper(root.left),0);
        int rightVal = Math.max(helper(root.right),0);

        maxPathSum = Math.max(maxPathSum, leftVal+rightVal+root.val);
        return Math.max(leftVal,rightVal) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        helper(root);
        return maxPathSum;
    }
}
