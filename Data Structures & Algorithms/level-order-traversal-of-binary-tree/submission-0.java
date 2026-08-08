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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);

        while(!Q.isEmpty()){
            int size=Q.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = Q.poll();
                tempList.add(curr.val);
                if(curr.left!=null)
                    Q.add(curr.left);
                if(curr.right!=null)
                    Q.add(curr.right);
            }
            result.add(tempList);
        }
        return result;
    }
}
