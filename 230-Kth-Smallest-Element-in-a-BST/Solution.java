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
	public int kthSmallest(TreeNode root, int k) {
		// 10:23 - 10:34
		// Hint: Kth node of inorder traversal
		int[] count = new int[1];
		int[] result = new int[1];
		count[0] = 0;
		result[0] = Integer.MIN_VALUE;

		findK(root, k, count, result);

		return result[0];
	}

	private void findK(TreeNode root, int k, int[] count, int[] result) {
		if (root == null) {
			return;
		}

		findK(root.left, k, count, result);
		count[0]++;
		if (count[0] == k) {
			result[0] = root.val;
			return;
		}
		findK(root.right, k, count, result);
	}
}
