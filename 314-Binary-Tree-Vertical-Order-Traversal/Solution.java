public class Solution {
	public List<List<Integer>> verticalOrder(TreeNode root) {
        	List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
		    return res;
		}

		// left store
		List<List<Integer>> left = new ArrayList<List<Integer>>();
		List<List<Integer>> right = new ArrayList<List<Integer>>();
		// add a dummy head to right
		right.add(new ArrayList<Integer>(Integer.MAX_VALUE));       

		dfs(root, 0, left, right);
		for (int i = left.size() - 1; i >= 0; i--) {
			res.add(left.get(i));
		}
		for (int i = 1; i < right.size(); i++) {
			res.add(right.get(i));
		}

		return res;
	}

	private void dfs(TreeNode root, int width, List<List<Integer>> left, List<List<Integer>> right) {
		if (root == null) {
			return;
		}

		if (width >= 0) {
			if (width + 1 > left.size()) {
				List<Integer> col = new ArrayList<Integer>();
				col.add(root.val);
				left.add(col);			
			} else {
				left.get(width).add(root.val);
			}
		} else {
			if (Math.abs(width) + 1 > right.size()) {
				List<Integer> col = new ArrayList<Integer>();
				col.add(root.val);
				right.add(col);
			} else {
				right.get(Math.abs(width)).add(root.val);
			}
		}
		dfs(root.left, width + 1, left, right);
		dfs(root.right, width - 1, left, right);
	}
}
