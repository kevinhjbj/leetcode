/*
 * root.val can be negative
 */
public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		// 4:06
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> solution = new ArrayList<Integer>();

		findSum(root, sum, solution, result);
		return result;
	}

	private void findSum(TreeNode root, int sum, List<Integer> solution, List<List<Integer>> result) {
		if (root == null) {
			return;
		}

		solution.add(root.val);
		if (root.left == null && root.right == null && root.val == sum) {
			result.add(new ArrayList<Integer>(solution));
			solution.remove(solution.size() - 1);
			return;
		} else if (root.left == null && root.right == null && root.val != sum) {
			solution.remove(solution.size() - 1);
			return;
		}

		findSum(root.left, sum - root.val, solution, result);
		findSum(root.right, sum - root.val, solution, result);
		// Key point: after return from searching child node, remove current node value from solution list 
		solution.remove(solution.size() - 1);
	}
}
