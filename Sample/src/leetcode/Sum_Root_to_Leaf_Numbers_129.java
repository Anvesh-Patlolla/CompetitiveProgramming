package leetcode;

public class Sum_Root_to_Leaf_Numbers_129 {
	static int retVal = 0;

	public int sumNumbers(TreeNode root) {
		retVal = 0;
		inorder(root, 0);
		return retVal;
	}

	private void inorder(TreeNode root, int sum) {
        if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			retVal += (sum * 10 + root.val);
			return;
		}
		if (root.left != null) {
			inorder(root.left, sum * 10 + root.val);
		}
		if (root.right != null) {
			inorder(root.right, sum * 10 + root.val);
		}

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
