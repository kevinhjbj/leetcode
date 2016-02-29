public class Solution {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}

		TreeNode succ = null;
		while (root != null) {
		    if (p.val < root.val) {
		        succ = root;
		        root = root.left;
		    } else {
		        root = root.right;
		    }
		}
		return succ;
	}
}