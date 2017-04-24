package leetcode;

public class ValidateBinarySearchTree_98 {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
		if (root == null) {
			return true;
		}
		if (root.val <= minValue || root.val >= maxValue) {
			return false;
		}

		return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
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
