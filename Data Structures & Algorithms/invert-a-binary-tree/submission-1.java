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
    private TreeNode helper(TreeNode root){
        if(root==null)
            return null;
        TreeNode leftNode = helper(root.right);
        TreeNode rightNode = helper(root.left);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        return helper(root);
    }
}
