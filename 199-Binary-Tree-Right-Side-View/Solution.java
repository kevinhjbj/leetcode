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
	public List<Integer> rightSideView(TreeNode root) {
		// 11:20 - 11:31
		List<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				if (curNode.left != null) {
					queue.offer(curNode.left);
				}
				if (curNode.right != null) {
					queue.offer(curNode.right);
				}
				if (i == size - 1) {
					result.add(curNode.val);
				}
			}
		}

		return result;
	}
}
