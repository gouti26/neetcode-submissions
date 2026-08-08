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
    Map<Integer,Integer> indexMap;
    private TreeNode buildTreeHelper(int[] pre,int low,int high,int preIndex){
        if(low>high)
            return null;
        TreeNode root = new TreeNode(pre[preIndex]);
        int mid = indexMap.get(root.val);
        int leftTreeSize = mid - low;

        root.left = buildTreeHelper(pre,low,mid-1,preIndex+1);
        root.right = buildTreeHelper(pre,mid+1,high,preIndex+leftTreeSize+1);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for(int i =0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }

        return buildTreeHelper(preorder,0,preorder.length-1,0);
    }
}
