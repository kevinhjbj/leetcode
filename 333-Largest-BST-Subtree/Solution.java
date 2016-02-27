public class Solution {
	public int largestBSTSubtree(TreeNode root) {
		// 9:50 - 10:08
		// trivial method - no optimization
		if (root == null) {
			return 0;
		}
		
		int[] max = new int[1];
		max[0] = 0;
		helper(root, max);
		
		return max[0];
	}

	private void helper(TreeNode root, int[] max) {
		if (root == null) {
			return;
		}

		if (isValidBST(root, null, null)) {
			max[0] = Math.max(max[0], countNode(root));
		}
		helper(root.left, max);
		helper(root.right, max);	
	}

	private boolean isValidBST(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}

		if (min != null && root.val <= min) {
			return false;
		}
		if (max != null && root.val >= max) {
			return false;
		}
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}

	private int countNode(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return (countNode(root.left) + countNode(root.right) + 1);
	}
}
