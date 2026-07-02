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
    boolean ans=true;
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int l =helper(root.left) + 1;
        int r =helper(root.right) + 1;
        int result = Math.abs(l-r);
        if(result>1){
            ans=false;
        }
        return Math.max(l,r);
    }
    public boolean isBalanced(TreeNode root) {
       int x = helper(root);
       return ans;
    }
}