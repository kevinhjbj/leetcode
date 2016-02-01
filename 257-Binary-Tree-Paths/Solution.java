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
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		String path = new String();

		getPath(root, path, result);
		return result;
	}

	private void getPath(TreeNode root, String path, List<String> result) {
		if (root == null) {
			return;
		}

		path = path + String.valueOf(root.val);
		if (root.left == null && root.right == null) {
			result.add(path);
			return;
		}

		if (root.left != null) {
			getPath(root.left, path + "->", result);
		}
		if (root.right != null) {
			getPath(root.right, path + "->", result);
		}
	}
}
