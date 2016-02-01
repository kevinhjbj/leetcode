/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        // clean up this logic like this 
        // if (root.left == null && root.right == null) {
        //  return root.val == sum;
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        } else if(root.left == null && root.right == null && root.val != sum) {
            return false;
        }
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}