package leetcode;

public class SumofLeftLeaves_404 {
	public int sumOfLeftLeaves(TreeNode root) {
		sumOfLeftLeaves(root, false);
		return counter;

	}

	int counter = 0;

	private void sumOfLeftLeaves(TreeNode root, boolean isLeft) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null && isLeft == true) {
			counter += root.val;
		}
		sumOfLeftLeaves(root.left, true);
		sumOfLeftLeaves(root.right, false);

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
