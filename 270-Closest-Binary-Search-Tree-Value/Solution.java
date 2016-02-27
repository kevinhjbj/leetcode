public class Solution {
	public int closestValue(TreeNode root, double target) {
		if (root == null) {
			return 0;
		}

		int[] result = new int[1];
		result[0] = Integer.MAX_VALUE;
		dfs(root, target, Double.MAX_VALUE, result);

		return result[0];
	}

	private void dfs(TreeNode root, double target, double minRemainder, int[] result) {
		if (root == null) {
			return;
		}
		
		double remainder = Math.abs(root.val - target);
		if (remainder < minRemainder) {
		    result[0] = root.val;
		}
		minRemainder = Math.min(remainder, minRemainder);
		if (root.val < target) {
			dfs(root.right, target, minRemainder, result);
		} else if (root.val > target) {
			dfs(root.left, target, minRemainder, result);
		}
	}
}