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
	public TreeNode invertTree(TreeNode root) {
	// create a new tree 9:44
	if (root == null || (root.left == null && root.right == null)) {
		return root;
	}

	TreeNode tmp;
	tmp = root.right;
	root.right = root.left;
	root.left = tmp;
	
//	if (root.left != null) {
//		return (invertTree(root.left));
//	}
//	if (root.right != null) {
//		return invertTree(root.right);
//	}

	invertTree(root.left);
	invertTree(root.right);

	return root;
	}
}
