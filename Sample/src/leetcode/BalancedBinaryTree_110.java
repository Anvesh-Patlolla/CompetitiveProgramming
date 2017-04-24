package leetcode;

public class BalancedBinaryTree_110 {
	public boolean isBalanced(TreeNode root) {
		int height = isBalancedTree(root);
		return height > -1 ? true : false;
	}

	private int isBalancedTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = isBalancedTree(root.left);
		int right = isBalancedTree(root.right);
		if (left == -1 || right == -1) {
			return -1;
		}
		if (abs(left - right) > 1) {
			return -1;
		}
		return left > right ? left + 1 : right + 1;
	}

	private int abs(int num) {

		return num > 0 ? num : -1 * num;
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
