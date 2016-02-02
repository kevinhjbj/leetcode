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
	public int countNodes(TreeNode root) {
		// 10:05 - 10:19
		if (root == null) {
			return 0;
		}

		int lHeight = getLeftHeight(root);
		int rHeight = getRightHeight(root);

		if (lHeight == rHeight) {
			return ((1 << lHeight ) - 1);
		} else {
			return (1 + countNodes(root.left) + countNodes(root.right));
		}
	}

	private int getLeftHeight(TreeNode root) {
		int lHeight = 0;
		while (root != null) {
			lHeight++;
			root = root.left;
		}
		return lHeight;
	}

	private int getRightHeight(TreeNode root) {
		int rHeight = 0;
		while (root != null) {
			rHeight++;
			root = root.right;
		}
		return rHeight;
	}
}
